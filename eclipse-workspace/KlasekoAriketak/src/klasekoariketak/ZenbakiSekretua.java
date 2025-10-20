package klasekoariketak;

import java.util.Scanner;

public class ZenbakiSekretua{
    public static void main(String[] args) {
        // Zenbaki aleatorioa sortu Math.random() erabiliz (1etik 100era)
        int zenbakiAleatorioa = (int) (Math.random() * 100) + 1;
        int saiakera;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zenbaki aleatorio bat sortu dut 1 eta 100 artean.");
        System.out.println("Saiatu asmatzen, programa gelditzeko -1 idatzi.");

        // Erabiltzaileari hainbat saiakera uzteko bucla
        do {
            System.out.print("Sartu zure zenbakia: ");
            saiakera = scanner.nextInt();

            if (saiakera==-1) {
            	System.out.println("Zenbaki sekretua " +zenbakiAleatorioa+ " da.");
            	
            } else if (saiakera > zenbakiAleatorioa) {
                System.out.println("Zenbakia " +saiakera+ " baino txikiagoa da.");
            } else if (saiakera < zenbakiAleatorioa) {
                System.out.println("Zenbakia " +saiakera+ " baino handiagoa da.");
            } else {
                System.out.println("Zorionak! Zenbakia asmatu duzu.");
            }
        } while (saiakera != zenbakiAleatorioa);

        // Itxi scanner-a
        scanner.close();
    }
}

