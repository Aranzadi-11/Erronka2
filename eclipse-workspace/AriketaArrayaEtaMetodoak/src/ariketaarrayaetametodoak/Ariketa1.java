package ariketaarrayaetametodoak;

import java.util.Scanner;

public class Ariketa1 {
    private static String[][] eserlekuak = new String[25][4]; // 25 errenkada eta 4 zutabe

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aukera;

        do {
            System.out.println("1. Erreserbatu  2. Ezeztatu  3. Egoera  4. Irten"); 
            aukera = scanner.nextInt();

            if (aukera == 1)
                erreserbatu(scanner); //Erreserba egiteko ekintzari deitu
            else if (aukera == 2)
            	ezabatu(scanner); //Erreserba ezabatzeko ekintzari deitu
            else if (aukera == 3)
                erakutsiEgoera(); //Egoera erakusteko ekintzari deitu
        } while (aukera != 4);
        scanner.close();
    }

    private static void erreserbatu(Scanner scanner) {
        int errenkada;
        do { //Errekada eskatu
            System.out.print("Errenkada (1-25): ");
            errenkada = scanner.nextInt();
            if (errenkada < 1 || errenkada > 25) { //Ez badago 1 eta 25 artean mezu hau erakutsi eta berriro eskatu
                System.out.println("Errorea: Errenkada baliogabea. Mesedez, sartu 1 eta 25 artean dagoen aukera bat.");
            }
        } while (errenkada < 1 || errenkada > 25);

        int zutabea;
        do { //Zutabea eskatu
            System.out.print("Zutabea (1-4): ");
            zutabea = scanner.nextInt();
            if (zutabea < 1 || zutabea > 4) {  //Ez badago 1 eta 4 artean mezu hau erakutsi eta berriro eskatu
                System.out.println("Errorea: Zutabe baliogabea. Mesedez, sartu 1 eta 4 artean dagoen aukera bat.");
            }
        } while (zutabea < 1 || zutabea > 4);

        errenkada--;  //Aukeratu duen errenkada okupatuta bezala erakutsi
        zutabea--;    //Aukeratu duen zutabea okupatuta bezala erakutsi

        if (eserlekuak[errenkada][zutabea] == null) { // Aukeratu duen eserkekua libre badago
            System.out.print("Sartu NAN: "); //DNI-a eskatu
            eserlekuak[errenkada][zutabea] = scanner.next();
            System.out.println("Erreserbatuta!");
        } else { //Aukeratu duen eserlekua okupatuta badago
            System.out.println("Eserlekua okupatuta dago."); 
        }
    }

    private static void ezabatu(Scanner scanner) {  //Ezabatzeko kodea
        System.out.print("Errenkada (1-25): "); //Errenkada aukeratzeko esan
        int errenkada = scanner.nextInt() - 1;
        System.out.print("Zutabea (1-4): ");//Zutabea aukeratzeko esan
        int zutabea = scanner.nextInt() - 1;

        if (eserlekuak[errenkada][zutabea] != null) { //Ez bada null
            System.out.print("Sartu NAN: "); //DNI-a eskatu
            if (eserlekuak[errenkada][zutabea].equals(scanner.next())) {  //DNI-a egokia bada
                eserlekuak[errenkada][zutabea] = null; //Erreserba ezabatu
                System.out.println("Ezeztatuta!");
            } else { //DNI-a ez bada egokia
                System.out.println("NANa ez da egokia.");
            }
        } else { //Eserlekua null bada
            System.out.println("Eserlekua hutsik dago.");
        }
    }

    private static void erakutsiEgoera() { //Erakutsi egazkinaren egoera nola dagoen
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((eserlekuak[i][j] == null ? "[Libre] " : "[Okupatuta] "));
            }
            System.out.println();
        }
    }
}

