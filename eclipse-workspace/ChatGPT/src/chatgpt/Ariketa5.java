package chatgpt;

import java.util.Scanner;

public class Ariketa5 {

	public static void main(String[] args) {
		
		int numero1;
		int numero2;
		int emaitza;
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduce que el numero que corresponde a la operacion que quieras realizar; \n 1-Suma \n 2-Resta \n 3-Division \n 4-Multiplicacion \n Tu eleccion: ");
		int eleccion = sc.nextInt();
		
		switch (eleccion) {
		case 1:
			System.out.print("Introduce el valor del primer numero: ");
			numero1 = sc.nextInt(); 
			
			System.out.print("Introduce el valor del segundo numero: ");
			numero2 = sc.nextInt();
			
			emaitza = numero1 + numero2;
			System.out.print("El resultado de tu operacion es: \n " +numero1+ " + " +numero2+ " = " +emaitza);
			break;
			
		case 2:
			System.out.print("Introduce el valor del primer numero: ");
			numero1 = sc.nextInt();
			
			System.out.print("Introduce el valor del segundo numero: ");
			numero2 = sc.nextInt();
			
			emaitza = numero1 - numero2;
			System.out.print("El resultado de tu operacion es: \n " +numero1+ " - " +numero2+ " = " +emaitza);
			break;
			
		case 3:
			System.out.print("Introduce el valor del primer numero: ");
			numero1 = sc.nextInt();
			
			System.out.print("Introduce el valor del segundo numero: ");
			numero2 = sc.nextInt();
			
			emaitza = numero1 / numero2;
			System.out.print("El resultado de tu operacion es: \n " +numero1+ " / " +numero2+ " = " +emaitza);
			break;
			
		case 4:
			System.out.print("Introduce el valor del primer numero: ");
			numero1 = sc.nextInt();
			
			System.out.print("Introduce el valor del segundo numero :");
			numero2 = sc.nextInt();
			
			emaitza = numero1 * numero2;
			System.out.print("El resultado de tu operacion es: \n " +numero1+ " * " +numero2+ " = " +emaitza);
			break;
			
			default:
				System.out.println("Mete un numero que este dentro de los disponibles.");
		}
	}
		
}
