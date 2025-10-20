package klasekoariketak;

import java.util.Scanner;

public class Bilatu {
 
	public static void main(String[] args) {
		
		int zenbaki,i;
		int array []=new int [] {1,2,3,4,5,6,7,8,9,10};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sartu mesedez, bilatu nahi duzun zenbakia:");
		zenbaki = sc.nextInt();
		
		//Bilaketa
		int emaitza = bilatuAN(zenbaki,array);
		if(emaitza==-1) {
			System.out.println("ez dugu zure zenbakia aurkitu!");
		}else {
			System.out.println("Zure zenbakia "+emaitza+" posizioan dago!");
		}
		//Inprimatu
		for(i=0;i<array.length;i++) {
			System.out.print(array[i]+" | ");
		}
	}
	private static int bilatuAN(int zenbaki,int[] array) {
		int i;
		for(i=0;i<array.length;i++) {
			if(array[i]==zenbaki) {
				
				break;
			}
			if(i==array.length) {
				i=-1;
			}
		}
		return i;
	}
 
}