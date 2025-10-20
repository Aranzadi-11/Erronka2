package ariketakarrayekin_entrega;

import java.util.Scanner;

public class Ariketa4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[][] matrizea = new int[3][3];
        int batura = 0;

        System.out.println("Sartu 3x3 matrizeko elementuak:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elementua (" + i + "," + j + "): ");
                matrizea[i][j] = s.nextInt();
                batura = batura + matrizea[i][j];
            }
        }

        System.out.println("Matrizeko elementuen batura: " + batura);
        s.close();
    }
}

