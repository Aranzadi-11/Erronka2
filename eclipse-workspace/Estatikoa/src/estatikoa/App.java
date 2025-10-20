package estatikoa;

public class App {
	
	public static void main(String[] args) {
	
		Kotxea kotxe1 = new Kotxea();
		Kotxea kotxe2 = new Kotxea("Urdina");
		
		kotxe1.inprimatuInformazioa();
		System.out.println("Orain arte egindako kotxeak: "+Kotxea.getKotxeKopurua());
		//System.out.println("Kotxe1 deituta, orain arte egindako kotxeak: " +kotxe1.getKotxeKopurua());
		
	}
}
