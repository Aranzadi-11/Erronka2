package empleados;

public class Main {
    public static void main(String[] args) {
        // Crear empresa
        Empresa indra = new Empresa("Indra");

        // Crear departamentos
        Departamento informatica = new Departamento("Informática", "Madrid");
        Departamento personal = new Departamento("Personal", "Barcelona");

        // Agregar departamentos a la empresa
        indra.addDepartamento(informatica);
        indra.addDepartamento(personal);

        // Crear empleados
        Empleado empleado1 = new Empleado("Juan", "Pérez", 30, "Desarrollador", 3000);
        Empleado empleado2 = new Empleado("María", "García", 25, "Analista", 3200);
        Empleado empleado3 = new Empleado("Carlos", "López", 28, "Reclutador", 2800);

        // Agregar empleados a los departamentos
        informatica.addEmpleado(empleado1);
        informatica.addEmpleado(empleado2);
        personal.addEmpleado(empleado3);

        // Probar métodos de los empleados
        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);

        // Probar métodos de los departamentos
        System.out.println(informatica);
        System.out.println(personal);

        // Probar métodos de la empresa
        System.out.println(indra);
    }
}