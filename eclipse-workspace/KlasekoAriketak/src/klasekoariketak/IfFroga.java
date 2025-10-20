package klasekoariketak;

public class IfFroga {
	 public static void main(String[] args) {
		 int zenbaki1 = 3;
		 int zenbaki2 = 4;
		 // int zenbaki3 = 9;
		 
		 if (zenbaki1 > zenbaki2) {
			 System.out.println("Zenbaki1 Zenbaki2 baino handiagoa da.");
		 }else if (zenbaki2 > zenbaki1) {
			 System.out.println("Zenbaki2 Zenbaki1 baino handiagoa da.");
		 }else if (zenbaki1 == zenbaki2) {
			 System.out.println("Zenbaki1 eta Zenbaki2 berdinak dira.");	
		 }
		 System.out.println("Mezu hau beti agertzen da.");	 
	 }
}