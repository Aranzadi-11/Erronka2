package Enplegatuak;

public class Main {
    public static void main(String[] args) {
        //Enpresa sortu
        Enpresa indra = new Enpresa("A12345678", "Indra");

        //Departamentuak sortu
        Departamentua informatika = new Departamentua("D01", "Informatika", "Madrid", indra);
        Departamentua personal = new Departamentua("D02", "Personal", "Barcelona", indra);

        
        //Departamentuak enpresan gehitu
        indra.addDepartamentua(informatika);
        indra.addDepartamentua(personal);

        
        //Enplegatuak sortu
        Enplegatua enplegatua1 = new Enplegatua("12345678A", "Iosu Perez", 30, "Alta", "Programatzailea", 3000, informatika);
        Enplegatua enplegatua2 = new Enplegatua("87654321B", "Beñat Aranzadi", 25, "Bajan emanda", "Datu Base analista", 3200, informatika);
        Enplegatua enplegatua3 = new Enplegatua("45678901C", "Aitor Lopez", 28, "Alta", "Entrebistatzailea", 2800, personal);

        //Enplegatuak departamentuan gehitu
        informatika.altaEnplegatua(enplegatua1);
        informatika.altaEnplegatua(enplegatua2);
        personal.altaEnplegatua(enplegatua3);

        
        //Enplegatuen metodoak 
        System.out.println(enplegatua1);
        System.out.println(enplegatua2);
        System.out.println(enplegatua3);

        //Departamentuen metodoak 
        System.out.println(informatika);
        System.out.println(personal);

        //Enpresaren metodoak 
        System.out.println(indra);
    }
}