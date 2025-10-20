package ariketakarrayekin_entrega;

import java.util.Scanner;

public class Ariketa3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Sartu N (lerro kopurua): ");
        int n = s.nextInt();
        System.out.print("Sartu M (zutabe kopurua): ");
        int m = s.nextInt();

        int[][] matriz = new int[n][m];
        int maximo = Integer.MIN_VALUE;

        System.out.println("Sartu matrizeko elementuak:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Elementua (" + i + "," + j + "): ");
                matriz[i][j] = s.nextInt();
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                }
            }
        }

        System.out.println("Matrizeko balio handiena: " + maximo);
        s.close();
    }
}
