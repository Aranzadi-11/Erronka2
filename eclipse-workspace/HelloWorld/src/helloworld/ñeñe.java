package helloworld;

import java.util.Scanner;

public class ñeñe {
		public static void main(String[] args) {
			double batazbestekoa, batura=0;
			int zenbat = 5;
			Scanner sc = new Scanner(System.in);
			
			for(int i=0;i<zenbat;i++)	{
				System.out.println("Sartu "+i+ " zenbaki bat mesedez: ");
				batura = batura + sc.nextDouble();
			}
			batazbestekoa = batura/zenbat;
			System.out.println("Zure zenbakien batazbestekoa da: "+batazbestekoa);
	}
	}
