package ariketakobp;

public class Produktua {

	private String kodea;
	private String izena;
	private String deskripzioak;
	private double prezioa;
	
	
	public Produktua(String kodea, String izena, String deskripzioak, double prezioa) {
		this.kodea = kodea;
		this.izena = izena;
		this.deskripzioak = deskripzioak;
		this.prezioa = prezioa;
	}

	public Produktua() {
	}

	public Produktua(String kodea, double prezioa) {
		this.kodea = kodea;
		this.prezioa = prezioa;
	}
	
}
	
	

