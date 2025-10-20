package klasekoariketak;
 
import java.util.Scanner;
 
public class Ariketa4 {
 
    public static void main(String[] args) {
        
        // Aldagaiak sortu
        double erradioa, perimetroa, azalera;
        double PI = 3.14159; // Pi balioa
 
        // Erabiltzailea erradioa sartu
        Scanner sc = new Scanner(System.in);
        System.out.print("Sartu zirkunferentziaren erradioa: ");
        erradioa = sc.nextDouble();
 
        // Zirkunferentziaren luzeera eta azalera kalkulatu
        perimetroa = 2 * PI * erradioa; // formula
        azalera = PI * Math.pow(erradioa, 2); // formula
 
        // Emaitzak inprimatu
        System.out.println("Zirkunferentziaren luzeera: " + String.format("%.2f", perimetroa));
        System.out.println("Zirkunferentziaren azalera: " + String.format("%.2f", azalera));
    }
}
 
 
 