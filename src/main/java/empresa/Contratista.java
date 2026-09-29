package empresa;

public class Contratista implements Calculable {

    private String nombre;
    private double valorPago;

    public Contratista(String nombre, double valorPago) {
        this.nombre = nombre;
        this.valorPago = valorPago;
    }

    public double calcularPago() {
        return valorPago;
    }

    public String getNombre() {
        return nombre;
    }
}
