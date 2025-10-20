package chatgpt;

import java.util.Scanner;

public class Ariketa6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduce un numero: ");
		int zenbakia = sc.nextInt();
		
		if(zenbakia > 10) {
			System.out.println("Zure zenbakia 10 baino handiagoa da.");
		} else if (zenbakia < 10){ 
			System.out.println("Zure zenbakia 10 baino txikiagoa da.");
		} else if (zenbakia == 10){
			System.out.println("Zure zenbakia 10 da.");
		}
	}

}
