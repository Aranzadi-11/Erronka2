package chatgpt2;

import java.util.ArrayList;

public class ListaContactos {

    private ArrayList<Contacto> contactos;

    // Constructor
    public ListaContactos() {
        contactos = new ArrayList<>(); // Inicializa la lista de contactos
    }

    // Método para añadir un nuevo contacto
    public void añadirContacto(Contacto contacto) {
        contactos.add(contacto); // Añade el contacto a la lista
    }

    // Método para mostrar todos los contactos
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la lista.");
        } else {
            for (Contacto contacto : contactos) {
                contacto.mostrarContacto(); // Muestra la información de cada contacto
            }
        }
    }

    // Método para modificar el teléfono de un contacto por su nombre
    public void modificarTelefono(String nombre, String nuevoTelefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contacto.setNumero(nuevoTelefono); // Modifica el teléfono
                System.out.println("Teléfono de " + nombre + " actualizado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Método para obtener la lista de contactos
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    // Método para establecer la lista de contactos
    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
