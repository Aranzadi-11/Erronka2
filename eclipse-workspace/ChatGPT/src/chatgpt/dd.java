package chatgpt;

import java.util.Scanner;

public class dd  {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String erabiltzailea;
	        String pasahitza;
	        int intentos = 3; // Número de intentos permitidos

	        // Bucle while con condición para limitar los intentos
	        do{
	            System.out.print("Sartu erabiltzailea: ");
	            erabiltzailea = scanner.nextLine();

	            System.out.print("Sartu pasahitza: ");
	            pasahitza = scanner.nextLine();

	            // Comprobar si el usuario y la contraseña son correctos
	            if (erabiltzailea.equals("admin") && pasahitza.equals("1234")) {
	                System.out.println("Ongi etorri, " + erabiltzailea + "!");
	                break; // Salir del bucle cuando los datos son correctos
	            } else {
	                intentos--; // Restar un intento si los datos no son correctos
	                System.out.println("Erabiltzailea edo pasahitza ez da zuzena. Gelditzen diren saiakerak: " + intentos);
	            }
	        }while (intentos > 0);

	        // Si se acaban los intentos, mostrar mensaje de bloqueo
	        if (intentos == 0) {
	            System.out.println("Kontua blokeatuta saiakera gehiegikeriagatik.");
}
	    }
}
