package SISTEMA_VENTAS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAYMUNDO
 */
public class Productos {

    private String descripcion;
    private int stock;
    private double precio;
    private ArrayList<Productos> ListaProducto = new ArrayList();
    Ventas venta = new Ventas();

    public Productos(String descripcion, int stock, double precio) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;

    }

    public Productos() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Productos> getListaProducto() {
        return ListaProducto;
    }

    public void setListaProducto(ArrayList<Productos> ListaProducto) {
        this.ListaProducto = ListaProducto;
    }
    DefaultTableModel modelo = new DefaultTableModel();

    public void CebeceraProductos(JTable tablaProductos) {
        String[] cabecera = new String[]{"DESCRIPCION", "STOCK", "PRECIO"};
        modelo.setColumnIdentifiers(cabecera);
        tablaProductos.setModel(modelo);
    }

    public void AgregarProducto(JTextField descripcion, JTextField stock, JTextField precio) {
        if (descripcion.getText().length() == 0 && stock.getText().length() == 0 && precio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Llene los campos del producto");
        } else {
            this.descripcion = descripcion.getText();
            this.stock = Integer.parseInt(stock.getText());
            this.precio = Double.parseDouble(precio.getText());
            modelo.addRow(new Object[]{this.descripcion, this.stock, this.precio});
            Productos producto = new Productos(this.descripcion, this.stock, this.precio);

            ListaProducto.add(producto);
            //System.out.println("PRODUCTO AGREGADO"); 

        }

    }

    public void LimpiarDatosProductos(JTextField descripcion, JTextField stock, JTextField precio) {
        descripcion.setText("");
        stock.setText("");
        precio.setText("");
    }

    public void eliminarfilaProducto(JTable tablaProductos) {
        int fila = tablaProductos.getSelectedRow();
        if (tablaProductos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            modelo.removeRow(fila);
        }

    }

}
