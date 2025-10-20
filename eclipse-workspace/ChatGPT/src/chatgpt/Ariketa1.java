package chatgpt;

import java.util.Scanner;

public class Ariketa1 {
	public static void main(String[] args) {
		int numero1;
		int numero2;
		int calculadora;
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el primer numero: ");
		numero1 = sc.nextInt();
		
		System.out.print("Introduce el segundo numero: ");
		numero2 = sc.nextInt();
		
		System.out.print("Mete el numero acorde a la operacion que quieras realizar: 1-Suma, 2-Resta, 3-Multiplicar y 4-Dividir ");
		calculadora = sc.nextInt();
		
		int calculo = 0;
		switch (calculadora) {
			case 1:
				calculo = numero1+numero2;
				break;
			case 2:
				calculo = numero1-numero2;
				break;
			case 3:
				calculo = numero1*numero2;
				break;
			case 4:
				calculo = numero1/numero2;
				break;
			default:
				System.out.println("Eragiketa sartu 1 eta 4ren arteko zenbaki bat.");
		}
		System.out.println("Zure eragiketaren emaitza: " +calculo+ " da.");
		}

}
