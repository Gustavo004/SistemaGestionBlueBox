/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SISTEMA_VENTAS;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventas {

    private Usuarios usuarios;
    private ArrayList<Productos> ListaProducto;
    private double total;
    private double subtotalventas;

    public Ventas(Usuarios usuarios, ArrayList<Productos> producto) {
        this.usuarios = usuarios;
        this.ListaProducto = producto;
    }

    public Ventas() {

    }

    public Usuarios getCliente() {
        return this.usuarios;
    }

    public void setCliente(Usuarios cliente) {
        this.usuarios = usuarios;
    }

    public ArrayList<Productos> getProducto() {
        return this.ListaProducto;
    }

    public void setProducto(ArrayList<Productos> producto) {
        this.ListaProducto = producto;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotalventas() {
        return this.subtotalventas;
    }

    public void setSubtotalventas(double subtotalventas) {
        this.subtotalventas = subtotalventas;
    }

    DefaultTableModel modelo = new DefaultTableModel();

    public void CebecerasubTotalVenta(JTable tablaSubtotal) {
        String[] cabecera = new String[]{"NOMBRE PRODUCTO", "SUBTOTAL"};
        modelo.setColumnIdentifiers(cabecera);
        tablaSubtotal.setModel(modelo);
    }

    public double CalcularSubtotalVenta(JTextField cantidad, JTable tablaProductos) {
        this.subtotalventas = 0;
        tablaProductos.getSelectedRow();
        for (int i = 0; i < tablaProductos.getRowCount(); i++) {

            double valorTabla = Double.parseDouble(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2).toString());

            this.subtotalventas = valorTabla * Integer.parseInt(cantidad.getText());
        }
        return this.subtotalventas;
    }

    public void AgregarTablaVentas(JTextField cantidad, JTable tablaProductos, JTable tablaVentas, JTextField total) {

        if (cantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa la Cantida a comprar");
        } else {
            if (tablaProductos.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor Selecione un producto");
            } else {
                modelo.addRow(new Object[]{tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0), this.CalcularSubtotalVenta(cantidad, tablaProductos)});
                total.setText(String.valueOf(this.CalcularTotalVenta(tablaVentas)));
                cantidad.setText("");
            }
        }

    }

    public double CalcularTotalVenta(JTable tablaSubtotal) {
        this.total = 0;
        for (int i = 0; i < tablaSubtotal.getRowCount(); i++) {
            double valorTabla = Double.parseDouble(tablaSubtotal.getValueAt(i, 1).toString());
            this.total = this.total + valorTabla;

        }
        System.out.println("Total compra = "+this.total);
        return this.total;
    }

    public void eliminarfilaventa(JTable tablaVenta, JTextField total) {
        int fila = tablaVenta.getSelectedRow();
        if (tablaVenta.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            modelo.removeRow(fila);

            total.setText(String.valueOf(this.CalcularTotalVenta(tablaVenta)));

        }

    }

}
