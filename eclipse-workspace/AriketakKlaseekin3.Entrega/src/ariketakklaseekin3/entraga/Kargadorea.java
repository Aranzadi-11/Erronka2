package ariketakklaseekin3.entraga;

public class Kargadorea extends Osagarria{
	
	@Override
	public void inprimatuInformazioa () {
		System.out.println("Izena: "+super.getIzena());
		System.out.println("Prezioa: "+super.getSalmentaPrezioa()+" €");
		System.out.println("---------------");
		System.out.println("Ondorengo mugikorrekin konpatiblea:");
		
		for (int i=0; i<super.getKonpatibleak().size();i++) {
			super.getKonpatibleak().get(i).inprimatuInformazioa();
		}
	}
}