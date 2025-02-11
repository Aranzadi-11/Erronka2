package erronka2;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.awt.Color;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//PDF formatuan faktura sortzeko klasea
public class PdfSortzailea {

    //Erabiltzailearen eta eskaeraraen datuak konbinatuz faktura bat sortzen da
    public static boolean generatePDF(String idErabiltzailea, String eskaeraData, File outputFile) {
        // Erabiltzailearen datuak gordetzeko aldagaiak
        String izena = "";
        String abizena = "";
        String helbidea = "";

        // Produktuen informazioa gordetzeko zerrenda eta prezio totala kalkulatzeko aldagaia
        List<ProductInfo> productList = new ArrayList<>();
        double prezioTotala = 0.0;

        //Erabiltzailearen datuak lortu DBtik
        try (Connection conn = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT Izena, Abizena, Helbidea FROM erabiltzaileak WHERE ID = ?")) {
            pstmt.setString(1, idErabiltzailea);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Datuak aldagaietan gorde
                    izena = rs.getString("Izena");
                    abizena = rs.getString("Abizena");
                    helbidea = rs.getString("Helbidea");
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        //Eskaerako produktuen datuak lortu datu basetik
        try (Connection conn = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT ID_Produktua, Kantitatea, Prezioa FROM eskaerak WHERE ID_Erabiltzailea = ? AND Eskaera_Data = ?")) {
            pstmt.setString(1, idErabiltzailea);
            pstmt.setString(2, eskaeraData);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Produktuaren datuak lortu 'eskaerak' taulatik
                    String idProduktua = rs.getString("ID_Produktua");
                    int kantitatea = rs.getInt("Kantitatea");
                    double prezioa = rs.getDouble("Prezioa");
                    String produktuaIzena = "";
                    // Produktuaren izena lortu 'stock' taulatik
                    try (PreparedStatement pstmt2 = conn.prepareStatement(
                            "SELECT Izena FROM stock WHERE ID = ?")) {
                        pstmt2.setString(1, idProduktua);
                        try (ResultSet rs2 = pstmt2.executeQuery()) {
                            if (rs2.next()) {
                                produktuaIzena = rs2.getString("Izena");
                            }
                        }
                    }
                    // Produktuaren informazioa zerrendan gehitu eta prezio totala eguneratu
                    productList.add(new ProductInfo(produktuaIzena, kantitatea, prezioa));
                    prezioTotala += prezioa * kantitatea;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        // PDF dokumentua sortu
        try (PDDocument document = new PDDocument()) {
            // Orria gehitu dokumentura
            PDPage page = new PDPage();
            document.addPage(page);

            // Edukiaren letra eta koloreak ezarri
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setStrokingColor(Color.BLACK);

            int yPosition = 750; 
            int lineHeight = 20; 

         // Fakturaren izenburua header-aren konfigurazioa
            int headerHeight = 30;     
            int headerX = 50;           
            int headerWidth = 500;      
            int headerY = yPosition - headerHeight;  

            contentStream.setNonStrokingColor(Color.GRAY);// Header-aren atzealdea griz kolorez jarri
            contentStream.addRect(headerX, headerY, headerWidth, headerHeight);
            contentStream.fill();

            // Testuaren kolorea berriz ezarri beltzera 
            contentStream.setNonStrokingColor(Color.BLACK);

            // "Faktura" izenburua idatzi header gainean
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.beginText();
            float textX = headerX + 10;
            float textY = headerY + ((headerHeight - 16) / 2f);
            contentStream.newLineAtOffset(textX, textY);
            contentStream.showText("Faktura");
            contentStream.endText();

            yPosition = headerY - lineHeight;

            // Bezeroaren datuak idatzi
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Bezeroa: " + izena + " " + abizena);
            contentStream.endText();
            yPosition -= lineHeight;

            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Helbidea: " + helbidea);
            contentStream.endText();
            yPosition -= lineHeight;

            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Eskaera Data: " + eskaeraData);
            contentStream.endText();
            yPosition -= lineHeight * 2;

            // Produktuen taularen titulua idatzi
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Produktua");
            contentStream.newLineAtOffset(350, 0);
            contentStream.showText("Kantitatea");
            contentStream.newLineAtOffset(80, 0);
            contentStream.showText("Prezioa (€)");
            contentStream.endText();
            yPosition -= lineHeight;

            // Produktuen informazioa taulan adierazi
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            for (ProductInfo p : productList) {
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText(p.productName);
                contentStream.newLineAtOffset(350, 0);
                contentStream.showText(String.valueOf(p.quantity));
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText(String.format("%.2f €", p.price));
                contentStream.endText();
                yPosition -= lineHeight;
            }

            // Prezio totala erakutsi
            yPosition -= lineHeight;
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Prezio Totala: " + String.format("%.2f €", prezioTotala));
            contentStream.endText();

            // Edukiaren fluxua itxi eta dokumentua gorde
            contentStream.close();
            document.save(outputFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    //Produktuen informazioa gordetzeko laguntza klasea.
    
    private static class ProductInfo {
        String productName;
        int quantity;
        double price;

        //Produktu baten informazioa ezarri

        public ProductInfo(String productName, int quantity, double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }
    }
}

