package klasekoariketak;
 
import java.util.Scanner;
 
public class bug2 {
 
	public static void main(String[] args) {
		boolean berdinak = konparatu();
		
		if(berdinak) {
			System.out.println("Sartutako zenbakiak berdinak dira.");
		}else {
			System.out.println("Sartutako zenbakiak ezberdinak dira.");
		}
	}
 
 
	public static boolean konparatu() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu lehenengo zenbakia: ");
		int zenbakia1 = sc.nextInt();
		System.out.println("Sartu bigarrern zenbakia");
		int zenbakia2 = sc.nextInt();
		
		boolean berdinak;
	
		if(zenbakia1 == zenbakia2) {
			berdinak = true;
		}else {
			berdinak = false;
		}
		return berdinak;
	}
}
 