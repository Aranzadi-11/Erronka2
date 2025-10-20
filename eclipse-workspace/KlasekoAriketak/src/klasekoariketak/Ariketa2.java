package klasekoariketak;

import java.util.Scanner;

/**
 * Eskatu erabiltzaileari bere adina eeta bueltatu datorren urtean izango duena.
 */
public class Ariketa2 {
	
	public static void main(String[] args) {
		int adina;
		System.out.println("Sartu zure adina mesedez: ");
		   Scanner sc = new Scanner(System.in);
		    adina = sc.nextInt(); //Itxaron erabiltzailea bere urteak sartu harte hurrengo pausora jarraitzeko
		 adina=adina + 1;
	  System.out.println("Hurrengo urtean, "+adina+" urte izango dituzu");
	}
}
