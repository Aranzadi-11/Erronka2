package klasekoariketak;
import java.util.Scanner;

public class IfAriketa {

    public static void main(String[] args) {
        // Scanner objektua sortu erabiltzailearen input-a irakurtzeko
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari zenbaki bat eskatzen diogu (1 eta 10 bitartean, dezimalekin)
        System.out.print("Sartu 1 eta 10 arteko zenbaki bat (dezimalekin sar daiteke): ");
        double nota = scanner.nextDouble();

        // Balidatu zenbakia 1 eta 10 artekoa den
        if (nota >= 0 && nota <= 10) {
            // Aprobatu duen edo ez erabaki
            if (nota >= 5) {
                System.out.println("Aprobatu duzu!");

                // Aprobatu duenez, beste if batean sartuko gara nota zehazteko
                if (nota >= 5 && nota < 6) {
                    System.out.println("Zure nota: Nahiko");
                } else if (nota >= 6 && nota < 7) {
                    System.out.println("Zure nota: Ongi");
                } else if (nota >= 7 && nota <= 8.5) {
                    System.out.println("Zure nota: Oso Ongi");
                } else if (nota > 8.5 && nota <= 10) {
                    System.out.println("Zure nota: Bikain");
                }

            } else {
                System.out.println("Ez duzu gainditu.");
            }
        } else {
            System.out.println("Sartutako zenbakia ez dago tartean. Mesedez, sartu 1 eta 10 bitarteko zenbaki bat.");
        }

        // Scanner objektua itxi
        scanner.close();
    }
}

