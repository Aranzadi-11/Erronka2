package ariketaklaseekin_2.entrega;

public class Produktua {
    private String kodea;
    private String izena;
    private String deskribapena;
    private double prezioa;
    private double deskontua;

    // Argumenturik gabeko eraikitzailea
    public Produktua() {}

    // Argumentu guztiekin eraikitzailea
    public Produktua(String kodea, String izena, String deskribapena, double prezioa, double deskontua) {
        this.kodea = kodea;
        this.izena = izena;
        this.deskribapena = deskribapena;
        this.prezioa = prezioa;
        this.deskontua = deskontua;
    }

    // Getters eta Setters
    public String getKodea() {
        return kodea;
    }

    public void setKodea(String kodea) {
        this.kodea = kodea;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    public double getDeskontua() {
        return deskontua;
    }

    public void setDeskontua(double deskontua) {
        this.deskontua = deskontua;
    }

    // Produktuaren prezioaren arabera sailkatzen duen metodoa
    public String prezioarenSailkapena() {
        if (prezioa < 1.0) {
            return "GANGA";
        } else if (prezioa >= 1.0 && prezioa < 10.0) {
            return "NORMALA";
        } else {
            return "LUXUA";
        }
    }

    // Deskontua aplikatuz prezio finala kalkulatzeko metodoa
    public double prezioFinala() {
        return prezioa * (1 - deskontua);
    }

    // equals eta hashCode gainidaztea
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produktua produktua = (Produktua) obj;
        return kodea.equals(produktua.kodea);
    }

    @Override
    public int hashCode() {
        return kodea.hashCode();
    }

    // toString gainidaztea
    @Override
    public String toString() {
        return "Produktua{" +
                "kodea='" + kodea + '\'' +
                ", izena='" + izena + '\'' +
                ", deskribapena='" + deskribapena + '\'' +
                ", prezioa=" + prezioa +
                ", deskontua=" + deskontua +
                '}';
    }
}