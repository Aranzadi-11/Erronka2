package klasekoariketak;
/*
 * Ur-parke bat kudeatzen duen enpresarentzat aplikazio bat, erabiltzaileak erosten dituen sarreren kopuruaren arabera
 * zenbatekoa kalkulatzen du eta, 100 € edo gehiagoko guztizkoa bada, % 5eko deskontua aplikatzen du.
 */
import java.util.Scanner;

public class Ariketa9 {

    public static void main(String[] args) {
        // Scanner objektua sortu erabiltzailearen input-a irakurtzeko
        Scanner scanner = new Scanner(System.in);

        // Sarreren prezioak
        double haurSarreraPrezioa = 15.50;
        double helduSarreraPrezioa = 20.00;

        // Erabiltzaileari haurren sarreren kopurua eskatzen diogu
        System.out.print("Sartu haurren sarreren kopurua: ");
        int haurSarrerak = scanner.nextInt();

        // Erabiltzaileari helduen sarreren kopurua eskatzen diogu
        System.out.print("Sartu helduen sarreren kopurua: ");
        int helduSarrerak = scanner.nextInt();

        // Guztizko zenbatekoa kalkulatu
        double guztizkoZenbatekoa = (haurSarrerak * haurSarreraPrezioa) + (helduSarrerak * helduSarreraPrezioa);

        // % 5eko deskontua aplikatu guztizko zenbatekoa 100 € edo gehiagokoa bada
        if (guztizkoZenbatekoa >= 100) {
            guztizkoZenbatekoa = guztizkoZenbatekoa * 0.95;
        }

        // Emaitza erabiltzaileari erakutsi
        System.out.println("Ordaindu beharreko guztizko zenbatekoa: " + String.format("%.2f", guztizkoZenbatekoa) + " €");

        // Scanner objektua itxi
        scanner.close();
    }
}
