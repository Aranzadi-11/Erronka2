package chatgpt;

import java.util.Scanner;

public class Ariketa4 {
    public static void main(String[] args) {
        int numero;
        int cuadrado;
        int emaitza;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.print("Elige una opción: \n 1 - Ver la hora. \n 2 - Calcular el cuadrado de un número. \n 3 - Salir del programa. \n Tu elección: ");
            numero = sc.nextInt();

            switch (numero) {
                case 1:
                    System.out.println("La hora actual es 23:16:00");
                    break;
                case 2:
                    System.out.print("Introduce el número del cual quieres calcular el cuadrado: ");
                    cuadrado = sc.nextInt();
                    emaitza = (int) Math.pow(cuadrado, 2);
                    System.out.println("Tu número (" + cuadrado + ") elevado al cuadrado es: " + emaitza);
                    break;
                case 3:
                    System.out.println("Has salido del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Elige entre 1 y 3.");
            }
        } while (numero != 3);
        
        sc.close(); // Cerrar el escáner al final
    }
}
