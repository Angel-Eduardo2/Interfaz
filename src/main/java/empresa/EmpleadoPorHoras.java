package empresa;

public class EmpleadoPorHoras extends Empleado {

    private int horas;
    private double tarifa;

    public EmpleadoPorHoras(String nombre, double tarifa) {
        super(nombre, 0);
        this.tarifa = tarifa;
    }

    public void registrarHoras(int horas) throws HorasInvalidasException {
        if (horas < 0 || horas > 300) {
            throw new HorasInvalidasException("horas fuera de rango " + horas);
        }

        this.horas = horas;
    }

    public double calcularPago() {
        return horas * tarifa;
    }
}
