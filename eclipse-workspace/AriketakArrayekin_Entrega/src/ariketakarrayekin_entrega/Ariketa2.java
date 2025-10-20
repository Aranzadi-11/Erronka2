package ariketakarrayekin_entrega;

import java.util.Scanner;

public class Ariketa2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Sartu array-aren tamaina: ");
        int tamaina = scanner.nextInt();

        int[] zenbakiak = new int[tamaina];

        for (int i = 0; i < tamaina; i++) {
            System.out.print("Sartu " + (i + 1) + ". elementua: ");
            zenbakiak[i] = scanner.nextInt();
        }
       
        int batura = 0;
        for (int i = 0; i < zenbakiak.length; i++) {
        	batura = batura + zenbakiak[i];
        }

        System.out.println("Array-eko elementuen batura hau da: " + batura);
        
        scanner.close();
    }
}
