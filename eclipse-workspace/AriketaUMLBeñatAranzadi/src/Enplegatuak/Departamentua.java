package Enplegatuak;

import java.util.ArrayList;
import java.util.List;


public class Departamentua {
    private List<Enplegatua> enplegatuak; 
    private Enpresa enpresa; 
    private String ID; 
    private String kokapena; 
    private String izena;

    //Sortzailea
    public Departamentua(String ID, String izena, String kokapena, Enpresa enpresa) {
        this.ID = ID;
        this.izena = izena;
        this.kokapena = kokapena;
        this.enpresa = enpresa;
        this.enplegatuak = new ArrayList<>();
    }

    //Alta emateko metodoa
    public void altaEnplegatua(Enplegatua enplegatua) {
        enplegatuak.add(enplegatua);
        enplegatua.setDepartamentua(this);
    }

  //Baja emateko metodoa
    public void bajaEnplegatua(Enplegatua enplegatua) {
        enplegatuak.remove(enplegatua);
        enplegatua.setDepartamentua(null);
    }

    //Enplegatuak lortu
    public List<Enplegatua> getEnplegatuak() {
        return enplegatuak;
    }

    //Departamentua enpresara lotu
    public Enpresa getEnpresa() {
        return enpresa;
    }

    //Departamentuaren identifikazio zenbakia lortu
    public String getID() {
        return ID;
    }

    // Departamentuaren kokapena lortu
    public String getKokapena() {
        return kokapena;
    }

    //Departamentuaren izena lorut
    public String getIzena() {
        return izena;
    }

    //Departamentua enpresa batera ezarri
    public void setEnpresa(Enpresa enpresa) {
        this.enpresa = enpresa;
    }

    //Departamentuari identifikazio izena ezarri
    public void setID(String ID) {
        this.ID = ID;
    }

    //Departamentuaren kokapena lortu
    public void setKokapena(String kokapena) {
        this.kokapena = kokapena;
    }

    //Departamentuaren izena ezarri
    public void setIzena(String izena) {
        this.izena = izena;
    }

    @Override
    public String toString() {
        return "Departamentua{" +
                "ID='" + ID + '\'' +
                ", izena='" + izena + '\'' +
                ", kokapena='" + kokapena + '\'' +
                ", enpresa=" + (enpresa != null ? enpresa.getIzena() : "Enpresarik gabe") +
                ", enplegatuak=" + enplegatuak +
                '}';
    }
}