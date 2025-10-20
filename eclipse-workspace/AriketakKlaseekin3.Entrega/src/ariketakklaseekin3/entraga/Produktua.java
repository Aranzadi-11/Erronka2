package ariketakklaseekin3.entraga;

public abstract class Produktua {
	
	private String izena;
	private Double salmentaPrezioa;
	
	public Produktua () {
		
	}

	public Produktua(String izena, Double salmentaPrezioa) {
		this.izena = izena;
		this.salmentaPrezioa = salmentaPrezioa;
	}
	
	public abstract void inprimatuInformazioa();

	@Override
	public String toString() {
		return "Produktua [izena=" + izena + ", salmentaPrezioa=" + salmentaPrezioa + "]";
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Double getSalmentaPrezioa() {
		return salmentaPrezioa;
	}

	public void setSalmentaPrezioa(double salmentaPrezioa) {
		this.salmentaPrezioa = salmentaPrezioa;
	}
	

}
