package klasekoariketak;
/*
 * Programa honek erabiltzaileari lau zenbaki sartzen uzten dio (a, b, c eta x), eta gero kalkulatzen du y-ren balioa
 * ax^2 + bx + c ekuazioan.
 */
import java.util.Scanner;

public class Ariketa7 {

    public static void main(String[] args) {
        // Scanner objektua sortu erabiltzailearen input-a irakurtzeko
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari a, b, c eta x balioak eskatzen dizkiogu
        System.out.print("Sartu a zenbakia: ");
        int a = scanner.nextInt();

        System.out.print("Sartu b zenbakia: ");
        int b = scanner.nextInt();

        System.out.print("Sartu c zenbakia: ");
        int c = scanner.nextInt();

        System.out.print("Sartu x zenbakia: ");
        int x = scanner.nextInt();

        // Ekuazioa ax^2 + bx + c = y kalkulatzen dugu
        int y = (int) (a * Math.pow(x, 2) + b * x + c);

        // Emaitza erabiltzaileari erakutsi
        System.out.println("Ekuazioaren emaitza y da: " + y);

        // Scanner objektua itxi
        scanner.close();
    }
}
