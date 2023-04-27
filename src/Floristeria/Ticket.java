package Floristeria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {
    private List<Producto> productos;
    private double total;
    private Date fecha;

    public Ticket(List<Producto> productos, double total) {
        this.productos = productos;
        this.total = total;
        fecha = new Date();
    }


	public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public Date getFecha() {
        return fecha;
    }
    @Override
    public String toString() {
        return "Ticket [productos=" + productos + ", total=" + total + ", fecha=" + fecha + "]";
    }
}
