package Enplegatuak;

public class Pertsona {
    private String DNI; 
    private int adina; 
    private String egoera; 
    private String izena; 

    //Sortzailea
    public Pertsona(String DNI, String izena, int adina, String egoera) {
        this.DNI = DNI;
        this.izena = izena;
        this.adina = adina;
        this.egoera = egoera;
    }

    //Pertsonaren adina urtero bat gehitzeko
    public void Urtebetetzea() {
        this.adina++;
    }

    //Pertsonaren adina lortu
    public int getAdina() {
        return adina;
    }

    //Pertsonaren egoera lortu
    public String getEgoera() {
        return egoera;
    }

    //Pertsonaren NAN zenbakia lortu
    public String getDNI() {
        return DNI;
    }

    //Pertsonaren izena lortu

    public String getIzena() {
        return izena;
    }

    //Pertsonaren adina ezarri

    public void setAdina(int adina) {
        this.adina = adina;
    }

    //Pertsonaren egoera ezarri

    public void setEgoera(String egoera) {
        this.egoera = egoera;
    }

    @Override
    public String toString() {
        return "Pertsona{" +
                "DNI='" + DNI + '\'' +
                ", adina=" + adina +
                ", egoera='" + egoera + '\'' +
                ", izena='" + izena + '\'' +
                '}';
    }
}