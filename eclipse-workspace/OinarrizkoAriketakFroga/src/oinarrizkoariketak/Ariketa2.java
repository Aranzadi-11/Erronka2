package oinarrizkoariketak;

import java.util.Scanner;

public class Ariketa2 {

	public static void main(String[] args) {
		int zenbakia;
		int zenbakia1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Sartu lehenengo zenbakia: ");
		zenbakia = scanner.nextInt();
		
		System.out.print("Sartu bigarren zenbakia: ");
		zenbakia1 = scanner.nextInt();
		
		int zenbakia2 = (zenbakia1 - (zenbakia % zenbakia1)) % zenbakia1;
		
		System.out.println("Zure lehenengo zenbakiaren ("+zenbakia+"), ("+zenbakia1+") zenbakiaren multiploa izateko, "+zenbakia2+" gehitu behar zaio zure zenbakiari.");
	}

}
