package klasekoariketak;

public class App {

	public static void main(String[] args) {

		Kotxea kotxe1 = new Kotxea("Ford","Focus",2018);
		Kotxea kotxe2 = new Kotxea();
		Kotxea kotxe3 = new Kotxea("Mercedes","Clase C");
		
		System.out.println(kotxe1);
		//kotxe1.marka="Ford";
		//kotxe1.modeloa="Focus";
		
		
		//kotxe2.marka="Mercedes";
		//kotxe2.modeloa="Clase C";
		
		kotxe2.setMarka("Seat");
		kotxe2.setModeloa("Ibiza");
		kotxe2.setUrtea(2020);
		System.out.println(kotxe2);
		
		kotxe3.setUrtea(1995);
		System.out.println(kotxe3);
		
		
		kotxe1.martxanjarri();
		kotxe3.gelditu();
		kotxe1.martxanjarri();
		kotxe2.martxanjarri();
		
	}
}

