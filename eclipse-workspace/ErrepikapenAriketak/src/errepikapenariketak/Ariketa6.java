package errepikapenariketak;

import java.util.Scanner;

public class Ariketa6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aukera = 0;

        // Programa bukatu arte buelta egingo du
        while (aukera != 5) {
            // Erabiltzaileari bi zenbaki eskatzen dizkio
            System.out.print("Sartu lehen zenbakia: ");
            double zenbaki1 = scanner.nextDouble();
            System.out.print("Sartu bigarren zenbakia: ");
            double zenbaki2 = scanner.nextDouble();

            // Menua erakutsi
            System.out.println("\nAukeratu eragiketa:");
            System.out.println("1. Gehiketa");
            System.out.println("2. Kenketa");
            System.out.println("3. Biderketa");
            System.out.println("4. Zatiketa");
            System.out.println("5. Irten");
            System.out.print("Sartu zure aukera: ");
            aukera = scanner.nextInt();

            // Aukeraren arabera eragiketa burutu
            switch (aukera) {
                case 1:
                    System.out.println("Gehiketaren emaitza: " + (zenbaki1 + zenbaki2));
                    break;
                case 2:
                    System.out.println("Kenketa emaitza: " + (zenbaki1 - zenbaki2));
                    break;
                case 3:
                    System.out.println("Biderketaren emaitza: " + (zenbaki1 * zenbaki2));
                    break;
                case 4:
                    if (zenbaki2 != 0) {
                        System.out.println("Zatiketaren emaitza: " + (zenbaki1 / zenbaki2));
                    } else {
                        System.out.println("Errorea: Zeroz zatitu ezin da!");
                    }
                    break;
                case 5:
                    System.out.println("Programa bukatu da. Agur!");
                    break;
                default:
                    System.out.println("Aukera baliogabea. Saiatu berriro.");
                    break;
            }
            System.out.println(); // Lerro huts bat erantsiko du menua berriro erakutsi aurretik
        }
    }
}
