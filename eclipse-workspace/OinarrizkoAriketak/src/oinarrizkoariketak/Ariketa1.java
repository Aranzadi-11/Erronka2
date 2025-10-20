package oinarrizkoariketak;
/*
 * Programa honek erabiltzaileari zenbaki oso bat sartzen uzten dio, eta gero kalkulatzen du zenbat gehitu behar zaion
 * zenbaki hori 7ren multiploa izan dadin.
 */

import java.util.Scanner;

public class Ariketa1 {

	 public static void main(String[] args) {
	        // Scanner objektua sortu erabiltzailearen input-a irakurtzeko
	        Scanner scanner = new Scanner(System.in);

	        // Erabiltzaileari zenbaki oso bat eskatzen diogu
	        System.out.print("Sartu zenbaki oso bat: ");
	        int zenbakia = scanner.nextInt();

	        // Kalkulatu zenbat gehitu behar zaion 7ren multiploa izan dadin
	        int zenbakia1 = (7 - (zenbakia % 7)) % 7;

	        // Emaitza erabiltzaileari erakutsi
	        System.out.println("Zenbakia 7ren multiploa izan dadin, " + zenbakia1 + " gehitu behar zaio.");

	        // Scanner objektua itxi
	        scanner.close();
	    }
	}
