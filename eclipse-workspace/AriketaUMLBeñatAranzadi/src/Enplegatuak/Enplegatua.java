package Enplegatuak;

public class Enplegatua extends Pertsona {
    private String kargua; // Enplegatuaren kargua
    private Departamentua departamentua; // Enplegatuaren departamentua
    private double soldata; // Enplegatuaren soldata

    //Sortzailea
    public Enplegatua(String DNI, String izena, int adina, String egoera, String kargua, double soldata, Departamentua departamentua) {
        super(DNI, izena, adina, egoera);
        this.kargua = kargua;
        this.soldata = soldata;
        this.departamentua = departamentua;
    }

    
    //Enplegatuaren kargua lortu
    public String getKargua() {
        return kargua;
    }

    //Enplegatuaren departamentua lortu
    public Departamentua getDepartamentua() {
        return departamentua;
    }

    //Enplegatuaren soldata lortu
    public double getSoldata() {
        return soldata;
    }

    //Enlegatuaren kargua ezarri
    public void setKargua(String kargua) {
        this.kargua = kargua;
    }

    //Enpleagatuari departamentua ezarri
    public void setDepartamentua(Departamentua departamentua) {
        this.departamentua = departamentua;
    }

    //Enplegatuari soldata ezarri
    public void setSoldata(double soldata) {
        this.soldata = soldata;
    }

    @Override
    public String toString() {
        return "Enplegatua{" +
                "kargua='" + kargua + '\'' +
                ", departamentua=" + (departamentua != null ? departamentua.getIzena() : "Departamenturik gabe") +
                ", soldata=" + soldata +
                "} " + super.toString();
    }
}