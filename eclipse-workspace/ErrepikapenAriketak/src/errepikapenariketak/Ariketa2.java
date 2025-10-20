package errepikapenariketak;

import java.util.Scanner;

public class Ariketa2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Zenbat lagunen adina sartu nahi duzu?: ");
        int lagunKopurua = scanner.nextInt();
        int gazteenarenAdina = 0; 

        for (int i = 1; i <= lagunKopurua; i++) {
            System.out.print("Sartu " + i + ". lagunaren adina: ");
            int adina = scanner.nextInt();

            if (i == 1 || adina < gazteenarenAdina) {
                gazteenarenAdina = adina;
            }
        }

        System.out.println("Gazteenaren adina: " + gazteenarenAdina);
        
        scanner.close();
    }
}
