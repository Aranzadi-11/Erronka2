package klasekoariketak;
 
import java.util.Scanner;
 
public class AriketaHurrengoDataZuzenduta {
 
	public static void main(String[] args) {
		int eguna, hilabetea, urtea;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sartu mesedez gaurko data, eguna, hilabetea eta urtea. Datu bakoitzaren ostean enter sakatu");
		
		eguna = sc.nextInt();
		hilabetea = sc.nextInt();
		urtea = sc.nextInt();
		
		if(hilabetea == 2) {
			eguna++;
			if(eguna ==30)	{
				eguna =1;
				hilabetea++;
			}
		}else if(hilabetea == 4 || hilabetea == 6 || hilabetea == 9 || hilabetea == 11)	{
			eguna++;
			if(eguna ==31) {
				eguna =1;
				hilabetea++;
			}
		}else	{
			eguna++;
			if(eguna ==32 && hilabetea!=12)	{
				eguna=1;
				hilabetea++;
			}else if(eguna==32 && hilabetea==12)	{
				eguna =1;
				hilabetea=1;
				urtea++;
			}
		}
		if(eguna>31 || hilabetea>12)	{
			System.out.println("Sartutako informazioa okerra da");
		}else {
			System.out.println("Bihar "+urtea+"/"+hilabetea+"/"+eguna+" izango da.");
		}
	
	}
 
}
