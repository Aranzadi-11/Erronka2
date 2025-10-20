package helloworld;

import java.util.Scanner;

public class Ariketa {

	public static void main(String[] args) {
		
		int HilabetearenZenbakia;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Sartu zure hilabetearen zenbakia: ");
		HilabetearenZenbakia = sc.nextInt();
		String hilabetearenizena;
		
		switch (HilabetearenZenbakia) {
	    case 1:
	    	hilabetearenizena = "Urtarrila";
	    	break;
	    	
	    case 2:
	    	hilabetearenizena = "Otsaila";
	    	break;
	    	
	    case 3:
	    	hilabetearenizena = "Martxoa";
	    	break;
	    	
	    case 4:
	    	hilabetearenizena = "Apirila";
	    	break;
	    
	    case 5:
	    	hilabetearenizena = "Maitza";
	    	break;
	    	
	    case 6:
	    	hilabetearenizena = "Ekaina";
	    	break;
	    	
	    case 7:
	    	hilabetearenizena = "Uztaila";
	    	break;
	    	
	    case 8:
	    	hilabetearenizena = "Abuztua";
	    	break;
	    	
	    case 9:
	    	hilabetearenizena = "Iraila";
	    	break;
	    	
	    case 10:
	    	hilabetearenizena = "Urria";
	    	break;
	    	
	    case 11:
	    	hilabetearenizena = "Azaroa";
	    	break;
	    	
	    case 12:
	    	hilabetearenizena = "Abendua";
	    	break;
	    	default:
	    		System.out.println("1 eta 12 artean dagoen zenbaki bat sartu behar dezu");
		}
		System.out.println("Zure hilabetearen izena " +hilabetearenizena+ " da.");
	   
		
	}

}
