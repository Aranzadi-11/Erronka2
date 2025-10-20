package empleados;

public class Empleado extends Persona {
    private String puesto;
    private double salario;
    private Departamento departamento;

    public Empleado(String nombre, String apellido, int edad, String puesto, double salario) {
        super(nombre, apellido, edad);
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "puesto='" + puesto + '\'' +
                ", salario=" + salario +
                ", departamento=" + (departamento != null ? departamento.getNombre() : "Sin departamento") +
                "} " + super.toString();
    }
}