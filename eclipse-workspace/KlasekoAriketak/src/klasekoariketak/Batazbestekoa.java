package klasekoariketak;

import java.util.Scanner;

public class Batazbestekoa {

		public static void main (String[] args) {
			double batazbestekoa, batura=0;
			int zenbat;
			Scanner sc = new Scanner(System.in);
			System.out.println("Zenbat zenbakiekin nahi duzu batazbestekoa egin?");
			zenbat=sc.nextInt();
			
			for (int i=0;i<zenbat;i++) {
				System.out.println("Sartu zenbaki bat mesedez: ");
				batura = batura + sc.nextDouble();
			}
			batazbestekoa= batura/zenbat;
			System.out.println("Zure zenbakiaren baatazbestekoa " +batazbestekoa+ " da.");
		}
}  
