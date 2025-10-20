package klasekoariketak;

import java.util.Scanner;

public class AriketaHurrengoData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Erabiltzaileari eguna, hilabetea eta urtea sartzeko eskatu
        System.out.println("Sartu urtea:");
        int urtea = sc.nextInt();
        
        System.out.println("Sartu hilabetea (1-12):");
        int hilabetea = sc.nextInt();
        
        System.out.println("Sartu eguna (1-31):");
        int eguna = sc.nextInt();

        // Urtea bisurtea den edo ez zehaztu
        boolean bisurteaDa = (urtea % 4 == 0 && urtea % 100 != 0) || (urtea % 400 == 0);

        // Hilabete bakoitzean zenbat egun dauden
        int[] egunHilabetean = {31, (bisurteaDa ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Egun bat gehitu
        eguna++;

        // Hilabetea edo urtea aldatu behar den egiaztatu
        if (eguna > egunHilabetean[hilabetea - 1]) {
            eguna = 1;
            hilabetea++;
            if (hilabetea > 12) {
                hilabetea = 1;
                urtea++;
            }
        }

        // Emaitza inprimatu
        System.out.println("Hurrengo egunaren data: " + urtea + "-" + hilabetea + "-" + eguna);
    }
}
