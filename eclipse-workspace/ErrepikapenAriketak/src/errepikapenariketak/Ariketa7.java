package errepikapenariketak;

import java.util.Scanner;

public class Ariketa7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Erabiltzailerari datuak eskatzea
        System.out.print("Sartu zure jaiotze eguna (1-31): ");
        int eguna = scanner.nextInt();
        System.out.print("Sartu zure jaiotze hilabetea (1-12): ");
        int hilabetea = scanner.nextInt();

        // Zodiac seina zehaztea
        String seina = "";

        if ((hilabetea == 3 && eguna >= 21) || (hilabetea == 4 && eguna <= 20)) {
            seina = "Aries";
        } else if ((hilabetea == 4 && eguna >= 21) || (hilabetea == 5 && eguna <= 21)) {
            seina = "Taurus";
        } else if ((hilabetea == 5 && eguna >= 22) || (hilabetea == 6 && eguna <= 21)) {
            seina = "Geminis";
        } else if ((hilabetea == 6 && eguna >= 22) || (hilabetea == 7 && eguna <= 22)) {
            seina = "Cáncer";
        } else if ((hilabetea == 7 && eguna >= 23) || (hilabetea == 8 && eguna <= 23)) {
            seina = "Leo";
        } else if ((hilabetea == 8 && eguna >= 24) || (hilabetea == 9 && eguna <= 23)) {
            seina = "Virgo";
        } else if ((hilabetea == 9 && eguna >= 24) || (hilabetea == 10 && eguna <= 23)) {
            seina = "Libra";
        } else if ((hilabetea == 10 && eguna >= 24) || (hilabetea == 11 && eguna <= 22)) {
            seina = "Escorpio";
        } else if ((hilabetea == 11 && eguna >= 23) || (hilabetea == 12 && eguna <= 21)) {
            seina = "Sagitario";
        } else if ((hilabetea == 12 && eguna >= 22) || (hilabetea == 1 && eguna <= 20)) {
            seina = "Capricornio";
        } else if ((hilabetea == 1 && eguna >= 21) || (hilabetea == 2 && eguna <= 19)) {
            seina = "Acuario";
        } else if ((hilabetea == 2 && eguna >= 20) || (hilabetea == 3 && eguna <= 20)) {
            seina = "Piscis";
        } else {
            seina = "Data okerra, mesedez sartu egunezko eta hilabeteko datuak egoki.";
        }

        // Zodiakoaren seina erakutsi
        if (!seina.isEmpty()) {
            System.out.println("Zure Zoodiakoaren seina: " + seina);
        }
    }
}
