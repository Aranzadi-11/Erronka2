package erronka2;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Datu Basean egin ahal diren ekintzak konfiguratu funtzioekin.
public class DBEkintzak {

	//Erregistroak gehitzeko funtzioa 
    public boolean erregistroaGehitu(String taulaIzena, String[] zutabeIzenak, String[] balioak) {
        int kop = zutabeIzenak.length;
        StringBuilder sql = new StringBuilder("INSERT INTO " + taulaIzena + " (");
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < kop; i++) {
            sql.append(zutabeIzenak[i]);
            placeholders.append("?");
            if (i < kop - 1) {
                sql.append(", ");
                placeholders.append(", ");
            }
        }
        sql.append(") VALUES (").append(placeholders).append(")");
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = konexioa.prepareStatement(sql.toString())) {
            for (int i = 0; i < kop; i++) {
                pstmt.setString(i + 1, balioak[i]);
            }
            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Erregistroak eguneratzeko funtzioa 
    public boolean erregistroaEguneratu(String taulaIzena, String idZutabe, String idBalio, 
                                        String[] eguneratuZutabeak, String[] eguneratuBalioak) {
        int kop = eguneratuZutabeak.length;
        StringBuilder sql = new StringBuilder("UPDATE " + taulaIzena + " SET ");
        for (int i = 0; i < kop; i++) {
            sql.append(eguneratuZutabeak[i]).append(" = ?");
            if (i < kop - 1) {
                sql.append(", ");
            }
        }
        sql.append(" WHERE ").append(idZutabe).append(" = ?");
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = konexioa.prepareStatement(sql.toString())) {
            for (int i = 0; i < kop; i++) {
                pstmt.setString(i + 1, eguneratuBalioak[i]);
            }
            pstmt.setString(kop + 1, idBalio);
            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //Erregistroak ezabatzeko funtzioa
    public boolean erregistroaEzabatu(String taulaIzena, String idZutabe, String idBalio) {
        String sql = "DELETE FROM " + taulaIzena + " WHERE " + idZutabe + " = ?";
        try (Connection konexioa = DBKonexioa.lortuKonexioa();
             PreparedStatement pstmt = konexioa.prepareStatement(sql)) {
            pstmt.setString(1, idBalio);
            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}