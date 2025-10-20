package klasekoariketak;
/*
 * Programa honek erabiltzaileari bere jaiotze urtea sartzen uzten dio, eta gero kalkulatzen du zenbat urte, hilabete, 
 * egun, ordu, minutu eta segundo daramatzan bizirik.
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ariketa8 {

    public static void main(String[] args) {
        // Scanner objektua sortu erabiltzailearen input-a irakurtzeko
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari jaiotze urtea eskatzen diogu
        System.out.print("Sartu zure jaiotze urtea (adibidez, 1990): ");
        int jaiotzeUrtea = scanner.nextInt();

        // Lortu egungo data
        LocalDate gaurkoData = LocalDate.now();
        
        // Jaiotze data sortu (urtarrilaren 1ean jaiotakoa balitz bezala)
        LocalDate jaiotzeData = LocalDate.of(jaiotzeUrtea, 1, 1);

        // Kalkulatu zenbat egun oso daramatzan bizirik
        long egunOsoak = ChronoUnit.DAYS.between(jaiotzeData, gaurkoData);

        // Kalkulatu zenbat urte daramatzan bizirik
        long urteak = ChronoUnit.YEARS.between(jaiotzeData, gaurkoData);

        // Kalkulatu zenbat hilabete, egun, ordu, minutu eta segundo daramatzan bizirik
        long hilabeteak = egunOsoak * 12 / 365; // Hurbilketa batez besteko batekin
        long orduak = egunOsoak * 24;
        long minutuak = orduak * 60;
        long segundoak = minutuak * 60;

        // Emaitza erabiltzaileari erakutsi
        System.out.println("Zure bizitza denbora:");
        System.out.println("Urteak: " + urteak);
        System.out.println("Hilabeteak (hurbilketa): " + hilabeteak);
        System.out.println("Egunak: " + egunOsoak);
        System.out.println("Orduak: " + orduak);
        System.out.println("Minutuak: " + minutuak);
        System.out.println("Segundoak: " + segundoak);

        // Scanner objektua itxi
        scanner.close();
    }
}

