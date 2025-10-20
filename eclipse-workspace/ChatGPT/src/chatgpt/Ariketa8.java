package chatgpt;

import java.util.Scanner;

public class Ariketa8 {

	public static void main(String[] args) {
		int aukera;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Opción 1 \nOpción 2 \nOpción 3 \nTu seleccion:");
		aukera = sc.nextInt();
		
		switch(aukera) {
		
		case 1:
			System.out.println("¡Bienvenido!");
			break;
			
		case 2:
			System.out.println("¡Hasta luego!");
			break;
			
		case 3:
			System.out.println("Termino el programa!");
			break;
			default:
				System.out.println("Pon un numero entre el 1 y 3.");
		}
		

	}

}
