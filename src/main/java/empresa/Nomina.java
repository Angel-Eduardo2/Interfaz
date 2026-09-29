package empresa;

import java.util.*;

public class Nomina {

    private List<Empleado> empleados = new ArrayList<>();
    private Set<String> cedulas = new HashSet<>();
    private Map<String, Empleado> empleadosMapa = new HashMap<>();
    private Queue<Solicitud> solicitudes = new ArrayDeque<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleadosMapa.put(empleado.getNombre(), empleado);
    }

    public void agregarCedula(String cedula) {
        cedulas.add(cedula);
    }

    public void agregarSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public Empleado buscarEmpleado(String nombre) {
        return empleadosMapa.get(nombre);
    }

    public Solicitud atenderSolicitud() {
        return solicitudes.poll();
    }
}
