package SISTEMA_VENTAS;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Usuarios {

    private String nombres;
    private String apellidos;
    private String dni;
    private String celular;
    private String correo;

    public Usuarios(String nombres, String apellidos, String dni, String celular, String correo) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public Usuarios() {

    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    DefaultTableModel modelo = new DefaultTableModel();

    public void CabeceraUsuario(JTable TableUsuarios) {
        String[] cabecera = new String[]{"NOMBRES", "APELLIDOS", "DNI", "CELULAR", "CORREO"};
        modelo.setColumnIdentifiers(cabecera);
        TableUsuarios.setModel(modelo);
    }

    public void AgregarUsuario(JTextField nombres, JTextField apellidos, JTextField dni, JTextField celular, JTextField correo) {

        this.nombres = nombres.getText();
        this.apellidos = apellidos.getText();
        this.dni = dni.getText();
        this.celular = celular.getText();
        this.correo = correo.getText();
        modelo.addRow(new Object[]{this.nombres, this.apellidos, this.dni, this.celular, this.correo});
    }

    public void LimpiarDatosUsuario(JTextField nombres, JTextField apellidos, JTextField dni, JTextField celular, JTextField correo) {
        nombres.setText("");
        apellidos.setText("");
        dni.setText("");
        celular.setText("");
        correo.setText("");
    }

    public void eliminarfilaUsuario(JTable tablaUsuario) {
        int fila = tablaUsuario.getSelectedRow();
        if (tablaUsuario.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            modelo.removeRow(fila);
        }

    }
}
