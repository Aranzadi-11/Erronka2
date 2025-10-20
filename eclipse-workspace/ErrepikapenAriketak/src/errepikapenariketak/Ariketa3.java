package errepikapenariketak;

import java.util.Scanner;

public class Ariketa3 {

    public static void main(String[] args) {
        // Scanner objektua sortu erabiltzailearen sarrera irakurtzeko
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari zenbaki bat sartzeko eskatu
        System.out.print("Sartu zenbaki bat: ");
        int zenbakia = scanner.nextInt();

        // Sartutako zenbakiaren biderketa-taula inprimatu
        System.out.println(zenbakia + " zenbakiaren biderketa-taula:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(zenbakia + " x " + i + " = " + (zenbakia * i));
        }

        // Scanner itxi
        scanner.close();
    }
}
