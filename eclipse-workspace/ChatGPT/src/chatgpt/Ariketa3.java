package chatgpt;

import java.util.Scanner;

public class Ariketa3 {
    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);

        // Pedimos un número hasta que sea válido (entre 1 y 10)
        do {
            System.out.print("Introduce un número entre 1 y 10: ");
            numero = sc.nextInt();
            if (numero < 1 || numero > 10) {
                System.out.println("Número inválido. Por favor, introduce un número entre 1 y 10.");
            }
        } while (numero < 1 || numero > 10);

        // Generamos y mostramos la tabla de multiplicar
        for (int i = 1; i <= 10; i++) {
            int emaitza = i * numero;
            System.out.println(i + " * " + numero + " = " + emaitza);
        }
    }
}
