package oinarrizkoariketak;

import java.util.Scanner;

public class Ariketa5 {

	public static void main(String[] args) {
		
		int HaurSarrera;
		int HelduSarrera;
		double Prezioa;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Sartu haurren sarrera kopurua: ");
		HaurSarrera = sc.nextInt();
		
		System.out.print("Sartu helduen sarrera kopurua: ");
		HelduSarrera = sc.nextInt();
		
		Prezioa = (HaurSarrera*15.50)+(HelduSarrera*20);
		
		if (Prezioa>=100) {
			Prezioa=Prezioa-(Prezioa*0.05);
		}else {
			Prezioa = Prezioa;
		}
		
		System.out.println("Zure sarreren prezioa "+String.format("%.2f", Prezioa)+" eurokoa da.");
		
	}

}
