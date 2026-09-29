package empresa;

public class EmpleadoFijo extends Empleado {

    public EmpleadoFijo(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    public double calcularPago() {
        return salarioBase;
    }
}
