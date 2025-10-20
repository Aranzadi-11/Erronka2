package ariketaklaseekin_2.entrega;

import java.util.Random;

public class Password {
    String karaktereak;

    // Sortzaileak
    public Password(String karaktereak) {
        this.karaktereak = karaktereak;
    }

    public Password() {}

    // Getter-ak
    public String getKaraktereak() {
        return karaktereak;
    }

    // Setter-ak
    public void setKaraktereak(String karaktereak) {
        this.karaktereak = karaktereak;
    }

    // Luzeera kalkulatu
    public int LuzeeraKalkulatu() {
        if (karaktereak == null) {
            return 0; 
        }
        return karaktereak.length();
    }
        
    // Pasahitzaren seguritatea
    public boolean isStrong(Password password) {
        boolean indartsuaDa = false;

        // 4 karaktere baino gehiago eta 20 baino gutxiago
        if ((this.karaktereak.length() < 20 && this.karaktereak.length() > 4) || (password.karaktereak.length() < 20 && password.karaktereak.length() > 4)) {
            // karaktere bat gutxienez letra larriz eta beste karaktere bat gutxienez letra xehez
            if ((this.karaktereak.matches(".*[A-Z].*") && this.karaktereak.matches(".*[a-z].*") || (password.karaktereak.matches(".*[A-Z].*") && password.karaktereak.matches(".*[a-z].*")))) {
                // "$", "%", "_" edo "*"; gutxienez hauetako karaktere bat
                if ((this.karaktereak.matches(".*[$%_*].*") || password.karaktereak.matches(".*[$%_*].*"))) {
                    // gutxienez zenbakizko karaktere bat
                    if ((this.karaktereak.matches(".*[0-9].*") || password.karaktereak.matches(".*[0-9]."))) {

                        indartsuaDa = true;
                    }
                }
            }
        }
        return indartsuaDa;
    }

    public static String generateRandomPassword(int length) {
        if (length < 0 || length > 30) {
            throw new IllegalArgumentException("Luzera 0 eta 30 artean egon behar da.");
        }

        //Erabilgarri dauden karaktere guztiak ezarri
        String karaktereGuztiak = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$%_*";

        Random random = new Random();
        StringBuilder pasahitza = new StringBuilder();

        //luzeeraren arabera ezarritako karaktereen artean random eginez pasahitza sortu
        for (int i = 0; i < length; i++) {
            pasahitza.append(karaktereGuztiak.charAt(random.nextInt(karaktereGuztiak.length())));
        }

        return pasahitza.toString();
    }
}
 


