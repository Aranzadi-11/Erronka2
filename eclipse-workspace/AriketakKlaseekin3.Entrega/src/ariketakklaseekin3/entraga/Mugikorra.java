package ariketakklaseekin3.entraga;

public class Mugikorra extends Produktua {

	private double pantailaTamaina;
	private double RAM;
	private double memoria;

	public Mugikorra() {
		super();
	}

	public Mugikorra(String izena, Double salmentaPrezioa, double pantaila, double RAM, double memoria) {
		super(izena, salmentaPrezioa);
		this.pantailaTamaina=pantaila;
		this.RAM=RAM;
		this.memoria=memoria;
	}

	@Override
	public void inprimatuInformazioa() {
		System.out.println("Pruduktua: "+super.getIzena());
		System.out.println("Prezioa: "+super.getSalmentaPrezioa()+" €");
		System.out.println("Pantaila: "+this.pantailaTamaina+" px.");
		System.out.println("RAM: "+this.RAM+" Giga.");
		System.out.println("Memoria: "+this.memoria+" Giga.");

	}

	public double getPantailaTamaina() {
		return pantailaTamaina;
	}

	public void setPantailaTamaina(double pantailaTamaina) {
		this.pantailaTamaina = pantailaTamaina;
	}

	public double getRAM() {
		return RAM;
	}

	public void setRAM(double rAM) {
		RAM = rAM;
	}

	public double getMemoria() {
		return memoria;
	}

	public void setMemoria(double memoria) {
		this.memoria = memoria;
	}

}
