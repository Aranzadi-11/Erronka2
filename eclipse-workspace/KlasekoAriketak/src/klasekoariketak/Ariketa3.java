package klasekoariketak;

import java.util.Scanner;

/*
 * Erabiltzaileari eskatu bi nota eta beraien arteko batazbestekoa atera.
 */
public class Ariketa3 {

	public static void main(String[] args) {


		double nota1, nota2, batazbestekoa; //double es para hacer numeros con decimales.
		
		System.out.println("Sartu zure lehenengo ikasgaiaren nota: ");
			Scanner sc = new Scanner(System.in);
		    	nota1 = sc.nextDouble();
	    System.out.println("Sartu zure bigarren ikasgaiaren nota: ");
			Scanner sc1 = new Scanner(System.in);
		    	nota2 = sc.nextDouble();
		batazbestekoa = (nota1 + nota2)/2;
		String emaitza = String.format("%.2f", batazbestekoa); //Segun que numero pongas pone esa cantidad de decimales.
		System.out.println("Zure bi noten batazbestekoa "+emaitza+" da");
	}
}
