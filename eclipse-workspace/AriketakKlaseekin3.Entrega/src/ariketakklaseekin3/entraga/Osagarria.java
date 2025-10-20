package ariketakklaseekin3.entraga;

import java.util.ArrayList;

public abstract class Osagarria extends Produktua {
	
	private ArrayList <Mugikorra> konpatibleak;

	public ArrayList<Mugikorra> getKonpatibleak() {
		return konpatibleak;
	}

	public void setKonpatibleak(ArrayList<Mugikorra> konpatibleak) {
		this.konpatibleak = konpatibleak;
	}
	
	

}
