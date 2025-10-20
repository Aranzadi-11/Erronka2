package ariketakklaseekin3.entraga;

import java.util.ArrayList;

public class App {
	
	public static void main (String[] args) {
		
		Mugikorra m = new Mugikorra();
		Produktua m1 = new Mugikorra();
		Kargadorea k = new  Kargadorea();
		ArrayList <Mugikorra> konpatibleak = new ArrayList <Mugikorra>();
		
		m.setIzena("Iphone 15");
		m.setSalmentaPrezioa(900);
		m.setPantailaTamaina(20);
		m.setRAM(12);
		m.setMemoria(500);
		konpatibleak.add(m);
		
		k.setIzena("Kargadorea 1");
		k.setSalmentaPrezioa(20.0);
		k.setKonpatibleak(konpatibleak);
		
		m.inprimatuInformazioa();
		System.out.println();
		k.inprimatuInformazioa();
	}

}
