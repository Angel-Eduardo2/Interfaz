package empresa;

public abstract class Empleado implements Calculable {

    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularPago();

    public String resumen() {
        return nombre + ": $" + calcularPago();
    }

    public String getNombre() {
        return nombre;
    }
}
