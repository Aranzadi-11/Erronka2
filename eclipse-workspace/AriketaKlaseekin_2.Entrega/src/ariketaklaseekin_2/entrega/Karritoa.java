package ariketaklaseekin_2.entrega;

public class Karritoa {

	private Produktua[] produktuak;
	private int kantitatea;

	// Sortzailea
	public Karritoa() {
		this.produktuak = new Produktua[10]; 
		this.kantitatea = 0;
	}

	//Kantitatea itzuli
	public int getProduktuenKantitatea() {
		return kantitatea;
	}

	// Prezioa kalkulatu
	public double getPrezioTotala() {
		double prezioTotala = 0;
		for (int i = 0; i < kantitatea; i++) {
			prezioTotala = prezioTotala + produktuak[i].getPrezioa();
		}
		return prezioTotala;
	}

	// produktuak gehitzeko metodoa
	public void produktuaGehitu(Produktua Produktua) {
		if (kantitatea == produktuak.length) {
			arrayaAldatu();
		}
		produktuak[kantitatea] = Produktua;
		kantitatea++;
	}

	// produktuak kentzeko metodoa
	public void produktuaKendu(Produktua produktua) {
	    int OPosizioa = -1;
	    for (int i = 0; i < kantitatea; i++) {
	        if (produktuak[i].equals(produktua)) {
	        	OPosizioa = i;
	            break;
	        }
	    }
	    for (int i = OPosizioa; i < kantitatea - 1; i++) {
	        produktuak[i] = produktuak[i + 1];
	    }
	    produktuak[kantitatea - 1] = null;
	    kantitatea--;
	}

	
	// arraya aldatzeko metodoa
	private void arrayaAldatu() {
		Produktua[] arrayBerria = new Produktua[produktuak.length * 2];
		for (int i = 0; i < produktuak.length; i++) {
			arrayBerria[i] = produktuak[i];
		}
		produktuak = arrayBerria;
	}
}