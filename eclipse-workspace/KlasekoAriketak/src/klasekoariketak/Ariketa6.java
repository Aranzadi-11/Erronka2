package klasekoariketak;
/*
 * Programa honek erabiltzaileari a eta b zenbakiak sartzen uzten dio, eta gero kalkulatzen du zenbat gehitu behar zaion
 * a zenbakiari b zenbakiaren multiploa izan dadin.
 */
import java.util.Scanner;

public class Ariketa6{

    public static void main(String[] args) {
        // Scanner objektua sortu erabiltzailearen input-a irakurtzeko
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari lehen zenbakia eskatzen diogu
        System.out.print("Sartu lehenengo zenbaki oso bat: ");
        int a = scanner.nextInt();

        // Erabiltzaileari bigarren zenbakia eskatzen diogu
        System.out.print("Sartu bigarren zenbaki oso bat: ");
        int b = scanner.nextInt();

        // Kalkulatu zenbat gehitu behar zaion lehenengo zenbakiari bigarrenaren multiploa izan dadin
        int emaitza = (b - (a % b)) % b;

        // Emaitza erabiltzaileari erakutsi
        System.out.println("Lehenengo zenbakia bigarren zenbakiaren multiploa izan dadin, " + emaitza + " gehitu behar zaio.");

        // Scanner objektua itxi
        scanner.close();
    }
}
