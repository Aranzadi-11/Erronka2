package Enplegatuak;

import java.util.ArrayList;
import java.util.List;

public class Enpresa {
    private String CIF; 
    private String izena; 
    private List<Departamentua> departamentuak; 

    //Sortzailea
    public Enpresa(String CIF, String izena) {
        this.CIF = CIF;
        this.izena = izena;
        this.departamentuak = new ArrayList<>();
    }

    //Enpresaren CIF zenbakia lortu

    public String getCIF() {
        return CIF;
    }

    //Enpresaren izena lortu
    public String getIzena() {
        return izena;
    }

  //Enpresaren CIF zenbakia ezarri
    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

  //Enpresaren izena ezarri
    public void setIzena(String izena) {
        this.izena = izena;
    }

    @Override
    public String toString() {
        return "Enpresa{" +
                "CIF='" + CIF + '\'' +
                ", izena='" + izena + '\'' +
                ", departamentuak=" + departamentuak +
                '}';
    }

    //Enpresaren departamentuak lortu

    public List<Departamentua> getDepartamentuak() {
        return departamentuak;
    }

    //Enpresa batean departamentu bat gehitzeko metodoa
    public void addDepartamentua(Departamentua departamentua) {
        departamentuak.add(departamentua);
    }
}