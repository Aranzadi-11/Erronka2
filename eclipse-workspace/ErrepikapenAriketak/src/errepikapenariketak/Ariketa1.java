package errepikapenariketak;

import java.util.Scanner;

/*
 * Bistaratu lehen 100 zenbaki osoen batura.
 */
public class Ariketa1 {

	public static void main(String[] args) {
		int emaitza=0;
		int zenbakiMaximoa;
		int emaitza2;
		Scanner sc = new Scanner (System.in);
		System.out.println("Sartu zein zenbakirarte nahi duzu eragiketa egin: ");
		zenbakiMaximoa=sc.nextInt();
		for (int i=1;i<=zenbakiMaximoa;i++) {
			emaitza2 = emaitza+i;
			System.out.println(emaitza +" + "+i+ " = " +emaitza2);
			emaitza = emaitza+i;			
		}
		System.out.println("Lehen "+zenbakiMaximoa+" zenbakien batura da: "+emaitza);
		
	}

}