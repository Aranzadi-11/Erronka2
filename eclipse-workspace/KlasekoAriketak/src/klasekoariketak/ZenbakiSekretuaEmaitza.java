package klasekoariketak;

import java.util.Scanner;

/**
 * 
 */
public class ZenbakiSekretuaEmaitza {

	/**
	 * 2) Zenbaki sekretuaren jokua programatu. 
	 * Zenbaki aleatorio bat sortuko du programak (Math.random())
 		Erabiltzaileak zenbaki bat sartuko du eta programak esango dio, 
 		zenbaki sekretua baina handiagoa edo txikiagoa den.
	 *  Jokua bukatzen da erabiltzaileak asmatzen duenean edo -1 balioa sartzen duenean.
	 */
	public static void main(String[] args) {
		int sartutakoZenbakia, zenbakiSekretua;
		zenbakiSekretua = (int)(Math.random()*10 +1);//random-ek 0 eta 1 arteko zenbaki
		//bat bueltatuko digu. 
		System.out.println("Ea asmatzen duzun nire zenbaki sekretua!");
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("Sartu zenbaki bat!");
			sartutakoZenbakia=sc.nextInt();
			if(sartutakoZenbakia == zenbakiSekretua || sartutakoZenbakia==-1) {
				break;
			}
			if (sartutakoZenbakia > zenbakiSekretua) {
				System.out.println("Zenbaki Sekretua txikiagoa da!");
			}else {
				System.out.println("Zenbaki Sekretua handiagoa da!");
			}
		}while (zenbakiSekretua != sartutakoZenbakia && sartutakoZenbakia!= -1);
		
		if (sartutakoZenbakia == -1) {
			System.out.println("Pena bat da ez asmatu izana!");
			System.out.println("Zenbaki Sekretua da: "+zenbakiSekretua);
		}else {
			System.out.println("ZORIONAK! ASMATU DUZU!!");
			System.out.println("Zenbaki Sekretua da: "+zenbakiSekretua);
		}
		

	}

}