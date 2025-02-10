package erronka2;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PdfSortzailea {

    /**
     * Genera un PDF con la información del pedido indicado.
     *
     * @param idErabiltzailea El ID del usuario (según la tabla eskaerak)
     * @param eskaeraData     La fecha del pedido
     * @param outputFile      El archivo destino donde se guardará el PDF
     * @return true si se generó correctamente; false en caso de error.
     */
    public static boolean generatePDF(String idErabiltzailea, String eskaeraData, File outputFile) {
        // Variables para almacenar los datos del usuario
        String izena = "";
        String abizena = "";
        String helbidea = "";

        // Lista para almacenar la información de los productos del pedido
        List<ProductInfo> productList = new ArrayList<>();
        double prezioTotala = 0.0;

        // Consultamos la información del usuario en la tabla "erabiltzaileak"
        try (Connection conn = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT Izena, Abizena, Helbidea FROM erabiltzaileak WHERE ID = ?")) {
            pstmt.setString(1, idErabiltzailea);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    izena = rs.getString("Izena");
                    abizena = rs.getString("Abizena");
                    helbidea = rs.getString("Helbidea");
                } else {
                    // Si no se encuentra el usuario, se aborta la generación
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        // Consultamos los productos asociados al pedido (tabla "eskaerak")
        try (Connection conn = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT ID_Produktua, Kantitatea, Prezioa FROM eskaerak WHERE ID_Erabiltzailea = ? AND Eskaera_Data = ?")) {
            pstmt.setString(1, idErabiltzailea);
            pstmt.setString(2, eskaeraData);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String idProduktua = rs.getString("ID_Produktua");
                    int kantitatea = rs.getInt("Kantitatea");
                    double prezioa = rs.getDouble("Prezioa");
                    // Consultamos en la tabla "stock" para obtener el nombre del producto
                    String produktuaIzena = "";
                    try (PreparedStatement pstmt2 = conn.prepareStatement(
                            "SELECT Izena FROM stock WHERE ID = ?")) {
                        pstmt2.setString(1, idProduktua);
                        try (ResultSet rs2 = pstmt2.executeQuery()) {
                            if (rs2.next()) {
                                produktuaIzena = rs2.getString("Izena");
                            }
                        }
                    }
                    productList.add(new ProductInfo(produktuaIzena, kantitatea));
                    prezioTotala += prezioa;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        // Creación del PDF usando PDFBox
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Configuramos la posición inicial y los tamaños de fuente
            int yPosition = 750;
            int lineHeight = 20;

            // Título
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Pedido");
            contentStream.endText();
            yPosition -= lineHeight * 2;

            // Datos del usuario: Erabiltzailea
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Erabiltzailea: " + izena + " " + abizena);
            contentStream.endText();
            yPosition -= lineHeight;

            // Helbidea
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Helbidea: " + helbidea);
            contentStream.endText();
            yPosition -= lineHeight;

            // Eskaera data
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Eskaera Data: " + eskaeraData);
            contentStream.endText();
            yPosition -= lineHeight * 2;

            // Encabezado para los productos
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Eskaerako produktuak:");
            contentStream.endText();
            yPosition -= lineHeight;

            // Listamos cada producto con su cantidad
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            for (ProductInfo p : productList) {
                contentStream.beginText();
                contentStream.newLineAtOffset(60, yPosition);
                contentStream.showText("- " + p.productName + " (Kantitatea: " + p.quantity + ")");
                contentStream.endText();
                yPosition -= lineHeight;
            }

            yPosition -= lineHeight;
            // Mostramos el precio total
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yPosition);
            contentStream.showText("Prezio Totala: " + prezioTotala);
            contentStream.endText();

            contentStream.close();
            document.save(outputFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    // Clase interna para almacenar la información de cada producto
    private static class ProductInfo {
        String productName;
        int quantity;

        public ProductInfo(String productName, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }
    }
}
