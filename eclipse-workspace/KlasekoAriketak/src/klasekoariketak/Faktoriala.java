package klasekoariketak;

import java.util.Scanner;

public class Faktoriala {

    public static void main(String[] args) {
        int zenbakia, faktoriala = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mesedez sartu zenbaki bat: ");
        zenbakia = sc.nextInt();
        
        if (zenbakia < 0) { 
            System.out.println("Ez da egokia");
        } else {
            for (int i = zenbakia; i > 0; i--) {
                faktoriala = faktoriala * i;
            }
            System.out.println("Faktoriala " + faktoriala + " da!");
        }
    }
}
