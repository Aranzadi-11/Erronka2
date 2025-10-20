package hirulerroan;

import java.util.Scanner;

public class HiruLerroan {

    public static void main(String[] args) {
        // Scanner sortu erabiltzailearen datuak jasotzeko
        Scanner sc = new Scanner(System.in);

        // Taula hasieratu (' ' hutsunez beteta)
        char[] taula = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        // Hasierako aldagaien definizioa
        char jokalaria = 'X'; // Jokalaria X hasiko da
        int mugimenduak = 0; // Mugimendu kopurua
        boolean irabazlea = false; // Irabazlea dagoen ala ez

        System.out.println("Hiru en raya jokora ongi etorri!");

        // Jokoa hasten da
        while (mugimenduak < 9 && !irabazlea) {
            // Taula inprimatu
            inprimatuTaula(taula);

            // Jokalarien txanda: Posizioa eskatu
            System.out.println("Jokalaria " + jokalaria + ", sartu posizioa (1-9):");
            int posizioa = sc.nextInt();

            // Posizio balioztapena
            if (posizioa < 1 || posizioa > 9 || taula[posizioa - 1] != ' ') {
                System.out.println("Posizio baliogabea! Saiatu berriro.");
                continue; // Hasiera berriro
            }

            // Posizioa markatu
            taula[posizioa - 1] = jokalaria;
            mugimenduak++;

            // Irabazlea dagoen egiaztatu
            irabazlea = irabazleaDago(taula, jokalaria);

            if (irabazlea) {
                inprimatuTaula(taula);
                System.out.println("Zorionak! Jokalaria " + jokalaria + " irabazi du!");
                break;
            }

            // Jokalarien txanda aldatu
            jokalaria = (jokalaria == 'X') ? 'O' : 'X';
        }

        // Berdinketa kasua
        if (!irabazlea && mugimenduak == 9) {
            inprimatuTaula(taula);
            System.out.println("Partida berdinduta amaitu da!");
        }

        sc.close(); // Scanner itxi
    }

    // Taula inprimatzeko metodoa
    public static void inprimatuTaula(char[] taula) {
        // Taula marrazteko lerroak
        System.out.println("-------------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + taula[i] + " | " + taula[i + 1] + " | " + taula[i + 2] + " |");
            System.out.println("-------------");
        }
    }

    // Irabazlea dagoen egiaztatzeko metodoa
    public static boolean irabazleaDago(char[] taula, char jokalaria) {
        // Konbinazio irabazleak
        int[][] konbinazioak = {
            {0, 1, 2}, // Lerro horizontala 1
            {3, 4, 5}, // Lerro horizontala 2
            {6, 7, 8}, // Lerro horizontala 3
            {0, 3, 6}, // Lerro bertikala 1
            {1, 4, 7}, // Lerro bertikala 2
            {2, 5, 8}, // Lerro bertikala 3
            {0, 4, 8}, // Diagonala 1
            {2, 4, 6}  // Diagonala 2
        };

        // For erabiliz, irabazleak egiaztatu
        for (int i = 0; i < konbinazioak.length; i++) {
            if (taula[konbinazioak[i][0]] == jokalaria &&
                taula[konbinazioak[i][1]] == jokalaria &&
                taula[konbinazioak[i][2]] == jokalaria) {
                return true; // Irabazlea aurkitua
            }
        }
        return false; // Ez dago irabazlerik
    }
}

