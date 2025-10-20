package ariketaklaseekin_2.entrega;

import java.util.Random;

public class PasswordApp {
    public static void main(String[] args) {
        Random random = new Random();
        
        int length1 = random.nextInt(31);

        String password1 = Password.generateRandomPassword(length1);
        Password p1 = new Password(password1);
        
        // Pasahitzak erakutsi
        System.out.println("Pasahitza "+ password1 +" da.");
        
        System.out.println();
        System.out.println("Zure pasahitza "+ p1.LuzeeraKalkulatu() +" karaktere ditu.");
        
        System.out.println();
        if (p1.isStrong(p1)) {
        System.out.println("Pasahitza indartsua da.");
        }else {
        System.out.println("Pasahitza ez da indartsua.");	
        }

    }
}
