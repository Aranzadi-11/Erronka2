package klasekoariketak;

import java.util.Scanner;

public class CaseAriketa {
	
	public static void main (String[] args) {
			int hilabetea;
			Scanner sc = new Scanner (System.in);
		    System.out.println("Sartu gauden hilabetearen zenbakia: ");
		    hilabetea = sc.nextInt();
		    String hilabetearenIzena;
		    
		    switch (hilabetea) {
		    case 1:
		    	hilabetearenIzena = "Urtarrila";
		    	break;
		    	
		    case 2:
		    	hilabetearenIzena = "Otsaila";
		    	break;
		    	
		    case 3:
		    	hilabetearenIzena = "Martxoa";
		    	break;
		    	
		    case 4:
		    	hilabetearenIzena = "Apirila";
		    	break;
		    	
		    case 5:
		    	hilabetearenIzena = "Maiatza";
		    	break;
		    	
		    case 6:
		    	hilabetearenIzena = "Ekaina";
		    	break;
		    	
		    case 7:
		    	hilabetearenIzena = "Uztaila";
		    	break;
		    	
		    case 8:
		    	hilabetearenIzena = "Abuztua";
		    	break;
		    	
		    case 9:
		    	hilabetearenIzena = "Iraila";
		    	break;

		    case 10:
		    	hilabetearenIzena = "Urria";
		    	break;

		    case 11:
		    	hilabetearenIzena = "Azaroa";
		    	break;

		    case 12:
		    	hilabetearenIzena = "Abendua";
		    	break;
		    	
		    	default:
		    		hilabetearenIzena = "Sartutako balorea ez da egokia."; 
		    }
	        System.out.println (hilabetearenIzena);                          
}
}