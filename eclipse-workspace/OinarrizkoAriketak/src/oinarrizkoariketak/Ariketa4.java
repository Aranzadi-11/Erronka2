package oinarrizkoariketak;
/*
 * Programa honek erabiltzaileari bere jaiotze urtea sartzen uzten dio, eta gero kalkulatzen du zenbat urte, hilabete, 
 * egun, ordu, minutu eta segundo daramatzan bizirik, kontuan izanik eguna 2024ko irailaren 24a dela.
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ariketa4 {

    public static void main(String[] args) {
        // Scanner objektua sortu erabiltzailearen input-a irakurtzeko
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari jaiotze urtea eskatzen diogu
        System.out.print("Sartu zure jaiotze urtea (adibidez, 1990): ");
        int jaiotzeUrtea = scanner.nextInt();
        
	     // Erabiltzaileari jaiotze hilabetea eskatzen diogu
	        System.out.print("Sartu zure jaiotze hilabetea (adibidez, 5): ");
	        int jaiotzeHilabetea = scanner.nextInt();
	        
	     // Erabiltzaileari jaiotze eguna eskatzen diogu
	        System.out.print("Sartu zure jaiotze eguna (adibidez, 24): ");
	        int jaiotzeEguna = scanner.nextInt();

        // Simulatu egungo data (2024ko irailaren 24a)
        LocalDate gaurkoData = LocalDate.of(2024, 9, 24);
        
        // Jaiotze data sortu
        LocalDate jaiotzeData = LocalDate.of(jaiotzeUrtea, jaiotzeHilabetea, jaiotzeEguna);

        // Kalkulatu zenbat urte dauden tartean
        long urteak = gaurkoData.getYear() - jaiotzeData.getYear();
        
        // Kalkulatu zenbat egun dauden tartean
        
       long egunak	= gaurkoData.getDayOfYear() - jaiotzeData.getDayOfYear();

        // Kalkulatu zenbat hilabete, egun, ordu, minutu eta segundo daramatzan bizirik
        long hilabeteak = urteak * 12; // Hurbilketa batez besteko batekin
        long egunak2 = egunak + urteak * 365; 
        long orduak = egunak2 * 24;
        long minutuak = orduak * 60;
        long segundoak = minutuak * 60;

        // Emaitza erabiltzaileari erakutsi
        System.out.println("Zure bizitza denbora (2024ko irailaren 24ra arte):");
        System.out.println("Urteak: " + urteak);
        System.out.println("Hilabeteak (hurbilketa): " + hilabeteak);
        System.out.println("Egunak: " + egunak2);
        System.out.println("Orduak: " + orduak);
        System.out.println("Minutuak: " + minutuak);
        System.out.println("Segundoak: " + segundoak);

        // Scanner objektua itxi
        scanner.close();
    }
}
