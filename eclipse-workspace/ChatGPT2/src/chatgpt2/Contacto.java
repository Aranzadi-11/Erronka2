package chatgpt2;

public class Contacto {
	
	private String nombre;
	private String numero;
	
	public Contacto(String nombre, String numero) {
		this.nombre = nombre;
		this.numero = numero;
	}

	public void mostrarContacto() {
		System.out.println("----------------------------");
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Número: "+this.numero);
		System.out.println("----------------------------");
	}
	
	public void modificarTelefono(String nuevoTelefono) {
        this.numero = nuevoTelefono; 
        System.out.println("Teléfono actualizado a: " + nuevoTelefono);
    }
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	

}
