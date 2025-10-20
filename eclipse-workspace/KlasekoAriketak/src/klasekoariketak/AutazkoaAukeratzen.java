package klasekoariketak;

import java.util.Scanner;

public class AutazkoaAukeratzen {
	
	public static void main(String[] args) {	
		int aukera;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Aukeratu mesedeez zure zaletasun bat: ");
		System.out.println("1.Musika");
		System.out.println("2.Zinema");
		System.out.println("3.Antzerkia");
		System.out.println("4.Irratia");
		System.out.println("5.Futbola");
		aukera = sc.nextInt();
		switch(aukera) {
		case 1:
			System.out.println("Musika aukeratu duzu! Ze auekera ona");
			break;
		case 2:
			System.out.println("Zinema aukeratu duzu! Ze auekera ona");
			break;
		case 3:
			System.out.println("Antzerkia aukeratu duzu! Ze auekera ona");
			break;
		case 4:
			System.out.println("Irratia aukeratu duzu! Ze auekera ona");
			break;
		case 5:
			System.out.println("Futbola aukeratu duzu! Ze auekera ona");
			break;
			default:
				System.out.println("Aukera hori ez da existitzen! Saiatu berriro");
				break;
		}
	}
 
}