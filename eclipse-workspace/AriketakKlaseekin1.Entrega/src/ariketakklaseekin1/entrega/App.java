package ariketakklaseekin1.entrega;

public class App {
    public static void main(String[] args) {
        // Argumenturik gabeko produktua sortu
        Produktua produktua1 = new Produktua();
        produktua1.setKodea("001");
        produktua1.setIzena("Arkatza");
        produktua1.setDeskribapena("Arkatz bat");
        produktua1.setPrezioa(0.75);
        produktua1.setDeskontua(0.0);

        // Argumentu guztiekin produktua sortu
        Produktua produktua2 = new Produktua("002", "Mugikorra", "Mugikor bat", 250.00, 0.2);
        Produktua produktua3 = new Produktua("003", "Telebista", "Telebista bat", 500.00, 0.6);
        Produktua produktua4 = new Produktua("004", "Teklatua", "Teklatu kabledun bat", 9.00, 0.0);

        // Produktuen informazioa erakutsi
        System.out.println(produktua1);
        System.out.println("Prezioaren sailkapena: " + produktua1.prezioarenSailkapena());
        System.out.println("Prezio finala: " + produktua1.prezioFinala());

        System.out.println(produktua2);
        System.out.println("Prezioaren sailkapena: " + produktua2.prezioarenSailkapena());
        System.out.println("Prezio finala: " + produktua2.prezioFinala());

        // Produktuak alderatu
        System.out.println("Produktua1 berdina da Produktua2-rekin? " + produktua1.equals(produktua2));
        
        
        
        System.out.println(produktua3);
        System.out.println("Prezioaren sailkapena: " + produktua3.prezioarenSailkapena());
        System.out.println("Prezio finala: " + produktua3.prezioFinala());

        System.out.println(produktua4);
        System.out.println("Prezioaren sailkapena: " + produktua4.prezioarenSailkapena());
        System.out.println("Prezio finala: " + produktua4.prezioFinala());

        System.out.println("Produktua3 berdina da Produktua4-rekin? " + produktua3.equals(produktua4));
    }
}
