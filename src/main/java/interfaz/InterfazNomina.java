package interfaz;

import empresa.Empleado;
import empresa.EmpleadoFijo;
import empresa.EmpleadoPorHoras;
import empresa.HorasInvalidasException;
import empresa.Nomina;
import javax.swing.JOptionPane;

public class InterfazNomina extends javax.swing.JFrame {

    private Nomina nomina = new Nomina();

    public InterfazNomina() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblTarifa = new javax.swing.JLabel();
        txtTarifa = new javax.swing.JTextField();
        lblHoras = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        btnAgregarFijo = new javax.swing.JButton();
        btnAgregarHoras = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        scrollResultado = new javax.swing.JScrollPane();
        areaResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("taller 7 nomina");

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("datos del empleado"));
        panelDatos.setLayout(new java.awt.GridLayout(4, 2, 8, 8));

        lblNombre.setText("nombre");
        panelDatos.add(lblNombre);
        panelDatos.add(txtNombre);

        lblSalario.setText("salario fijo");
        panelDatos.add(lblSalario);
        panelDatos.add(txtSalario);

        lblTarifa.setText("tarifa por hora");
        panelDatos.add(lblTarifa);
        panelDatos.add(txtTarifa);

        lblHoras.setText("horas");
        panelDatos.add(lblHoras);
        panelDatos.add(txtHoras);

        panelBotones.setLayout(new java.awt.GridLayout(1, 4, 8, 8));

        btnAgregarFijo.setText("agregar fijo");
        btnAgregarFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFijoActionPerformed(evt);
            }
        });
        panelBotones.add(btnAgregarFijo);

        btnAgregarHoras.setText("agregar por horas");
        btnAgregarHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHorasActionPerformed(evt);
            }
        });
        panelBotones.add(btnAgregarHoras);

        btnMostrar.setText("mostrar empleados");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        panelBotones.add(btnMostrar);

        btnLimpiar.setText("limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelBotones.add(btnLimpiar);

        areaResultado.setColumns(20);
        areaResultado.setRows(5);
        scrollResultado.setViewportView(areaResultado);

        panelSuperior.setLayout(new java.awt.BorderLayout(8, 8));
        panelSuperior.add(panelDatos, java.awt.BorderLayout.CENTER);
        panelSuperior.add(panelBotones, java.awt.BorderLayout.SOUTH);

        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));
        getContentPane().add(panelSuperior, java.awt.BorderLayout.NORTH);
        getContentPane().add(scrollResultado, java.awt.BorderLayout.CENTER);

        setSize(700, 450);
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void btnAgregarFijoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nombre = txtNombre.getText().toLowerCase();
            double salario = Double.parseDouble(txtSalario.getText());

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "escriba el nombre");
                return;
            }

            nomina.agregarEmpleado(new EmpleadoFijo(nombre, salario));
            areaResultado.append("empleado fijo agregado " + nombre + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "el salario debe ser un numero");
        }
    }

    private void btnAgregarHorasActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nombre = txtNombre.getText().toLowerCase();
            double tarifa = Double.parseDouble(txtTarifa.getText());
            int horas = Integer.parseInt(txtHoras.getText());

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "escriba el nombre");
                return;
            }

            EmpleadoPorHoras empleado = new EmpleadoPorHoras(nombre, tarifa);
            empleado.registrarHoras(horas);
            nomina.agregarEmpleado(empleado);

            areaResultado.append("empleado por horas agregado " + nombre + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "tarifa y horas deben ser numeros");
        } catch (HorasInvalidasException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {
        areaResultado.setText("empleados\n");

        for (Empleado e : nomina.getEmpleados()) {
            areaResultado.append(e.resumen().toLowerCase() + "\n");
        }
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        txtNombre.setText("");
        txtSalario.setText("");
        txtTarifa.setText("");
        txtHoras.setText("");
        areaResultado.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazNomina().setVisible(true);
            }
        });
    }

    private javax.swing.JTextArea areaResultado;
    private javax.swing.JButton btnAgregarFijo;
    private javax.swing.JButton btnAgregarHoras;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTarifa;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JScrollPane scrollResultado;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTarifa;
}
