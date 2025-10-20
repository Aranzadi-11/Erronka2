package klasekoariketak;


public class ArraiakLandu {

	public static void main(String[] args) {
		int [] arr1 = new int[6]; //[?,?,?,?,?]
		String [] arr2= new String[2];
		arr2[0]="Kaixo";
		arr2[1]="Mundua";
		String [] arr3= {"Kaixo","Mundua","Javatik"};
		
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		
		/*arr1[0]=1;
		arr1[1]=2;
		arr1[2]=3;
		arr1[3]=4;
		arr1[4]=5;
		arr1[5]=6;
		*/
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=i*2;
		}
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+",");
		}
		
		var arr4=arr1.clone();
		System.out.println();
		
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=i*4;
		}
		for(int elem:arr1) {
			System.out.print(elem+",");
		}
		System.out.println();
		
		for(int elem:arr4) {
			System.out.print(elem+"|");
		}
		System.out.println();
		
		int [][]arr2d=new int[3][2];
		//[?,?]
		//[?,?]
		//[?,?]
		int[][]arr2d2= {{1,2},{3,4},{5,6}};
		//[1,2]
		//[3,4]
		//[5,6]
		
		for(int row=0;row<arr2d2.length;row++) {
			for(int col=0;col<arr2d2[row].length;col++) {
				System.out.print("|"+arr2d2[row][col]+"|");
			}
		System.out.println();
		}
	}
}