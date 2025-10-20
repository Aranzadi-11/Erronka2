package chatgpt;

import java.util.Scanner;

public class Ariketa7 {

	public static void main(String[] args) {
		int zenbakia;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un numero:");
		zenbakia = sc.nextInt();
		
		if (zenbakia < 1) {
			System.out.println("Mete un numero mayor que 1");
	}else {
		for(int i=1; i <= zenbakia ;i++) {
			System.out.println(i);
		}
	}
	}
}
