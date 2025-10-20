package klasekoariketak;

import java.util.Scanner;

public class DNI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // DNI-ren zenbakia eskatu
        System.out.print("Sartu zure DNI zenbakia (letrarik gabe): ");
        int dniZenbakia = scanner.nextInt();

        // Kalkulua egin
        int hondarra = dniZenbakia % 23;

        // Letra atera zatiketaren hondarraren arabera
        String letra;
        switch (hondarra) {
            case 0:
                letra = "T";
                break;
            case 1:
                letra = "R";
                break;
            case 2:
                letra = "W";
                break;
            case 3:
                letra = "A";
                break;
            case 4:
                letra = "G";
                break;
            case 5:
                letra = "M";
                break;
            case 6:
                letra = "Y";
                break;
            case 7:
                letra = "F";
                break;
            case 8:
                letra = "P";
                break;
            case 9:
                letra = "D";
                break;
            case 10:
                letra = "X";
                break;
            case 11:
                letra = "B";
                break;
            case 12:
                letra = "N";
                break;
            case 13:
                letra = "J";
                break;
            case 14:
                letra = "Z";
                break;
            case 15:
                letra = "S";
                break;
            case 16:
                letra = "Q";
                break;
            case 17:
                letra = "V";
                break;
            case 18:
                letra = "H";
                break;
            case 19:
                letra = "L";
                break;
            case 20:
                letra = "C";
                break;
            case 21:
                letra = "K";
                break;
            case 22:
                letra = "E";
                break;
            default:
                letra = "Ez da baliozkoa";
                break;
        }

        // Mostrar el resultado
        System.out.println("Zure DNI letra: " + letra);
        scanner.close();
    }
}
