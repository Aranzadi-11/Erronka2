package oinarrizkoariketak;

import java.util.Scanner;

public class Ariketa1 {

	public static void main(String[] args) {
		int zenbakia;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Sartu zure zenbakia: ");
		zenbakia = scanner.nextInt();
		
		int zenbakia1 = (7 - (zenbakia % 7)) % 7;
		
		System.out.println("Zure zenbakia ("+zenbakia+") zazpiren multiploa izateko, "+zenbakia1+" gehitu behar zaio zure zenbakiari.");
	}

}
