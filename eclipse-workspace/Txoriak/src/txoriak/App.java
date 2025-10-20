package txoriak;

public class App {

	public static void main(String[] args) {
		
		int zenbakia;
		String izena;
		Txoriak  txori1 = new Txoriak();
		Txoriak  txori2 = new Txoriak("Txantxangorria", 5, 5);
		Txoriak  txori3 = new Txoriak("Kakatua");
		
		txori1.setIzena("Usoa");
		txori1.setX(25);
		txori1.setY(15);
		
		System.out.println("Txoriaren izena: "+txori1.getIzena());
		System.out.println("Txoriaren X posizioa: "+txori1.getX());
		System.out.println("Txoriaren X posizioa: "+txori1.getY());
		
		System.out.println(txori1);
		
		if (txori1.equals(txori2)) {
			System.out.println("Lehenengo txoria eta bigarrena berdinak dira!");
		}else {
			System.out.println("Lehenengo txoria eta bigarrena ez dira berdinak.");
		}
		
		System.out.println(txori1.hashCode());
		System.out.println(txori2.hashCode());
		System.out.println(txori3.hashCode());
	}

}
