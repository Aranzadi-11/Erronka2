package chatgpt2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaContactos listaContactos = new ListaContactos(); 
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir un nuevo contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Modificar el teléfono de un contacto");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, telefono);
                    listaContactos.añadirContacto(nuevoContacto);
                    System.out.println("Contacto añadido correctamente.");
                    break;

                case 2:
                    System.out.println("\nLista de contactos:");
                    listaContactos.mostrarContactos();
                    break;

                case 3:
                    System.out.print("Introduce el nombre del contacto a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Introduce el nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    listaContactos.modificarTelefono(nombreModificar, nuevoTelefono);
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
