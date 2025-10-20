package klasekoariketak;

import java.util.Scanner;

public class Abiadura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datuak erabiltzailearen eskutik
        System.out.print("Sartu ibilgailuaren abiadura (km/h): ");
        double abiaduraKmH = scanner.nextDouble(); // Ibilgailuaren hasierako abiadura (km/h)

        System.out.print("Sartu ibilgailuaren dezelerazioa (m/s^2): ");
        double dezelerazioa = scanner.nextDouble(); // Dezelerazioa (m/s^2)
        dezelerazioa = -Math.abs(dezelerazioa); // Dezelerazioa negatiboa izateko (balaztatzean abiadura galtzen da)

        // Beste parametroak
        double oinezkoarenDistantzia = 5.0; // Oinezkoaren distantzia (m)

        // Abiadura km/h-tik m/s-ra pasatzea
        double abiaduraMs = abiaduraKmH * 1000 / 3600;

        // Balaztatze-denbora kalkulatzea (t)
        double denbora = abiaduraMs / -dezelerazioa;

        // Ibilitako distantzia kalkulatzea (Sf)
        double ibilitakoDistantzia = abiaduraMs * denbora + 0.5 * dezelerazioa * denbora * denbora;

        // Emaitzak erakustea
        System.out.printf("Balaztatze-denbora: %.2f segundu\n", denbora);
        System.out.printf("Ibilitako distantzia: %.2f metro\n", ibilitakoDistantzia);

        // Egiaztatu oinezkoa harrapatzen duen ala ez
        if (ibilitakoDistantzia <= oinezkoarenDistantzia) {
            System.out.println("Ez du oinezkoa harrapatuko.");
        } else {
            System.out.println("Oinezkoa harrapatuko du.");
        }

        scanner.close();
    }
}

