package klasekoariketak;

import java.util.Scanner;

public class bug {

	public static void main(String[] args) {
		double a;
		System.out.print("Introduce el radio de un circulo: ");
		a = calculatarArea();
		System.out.println("El área es: " + a);

	}

	public static double calculatarArea() {
		Scanner s = new Scanner(System.in);
		int r1 = s.nextInt();

		System.out.println("La radio es: " + r1);
		double a = Math.PI * (r1 * r1);
		return a;

	}

}
