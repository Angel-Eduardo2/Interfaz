package empresa;

public class Solicitud {

    private String empleado;
    private int antiguedad;

    public Solicitud(String empleado, int antiguedad) {
        this.empleado = empleado;
        this.antiguedad = antiguedad;
    }

    public String getEmpleado() {
        return empleado;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
}
