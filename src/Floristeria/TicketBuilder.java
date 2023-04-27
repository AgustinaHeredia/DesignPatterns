package Floristeria;

import java.util.ArrayList;
import java.util.List;

public class TicketBuilder {
    private List<Producto> productos;
    private double total;

    public TicketBuilder() {
        productos = new ArrayList<>();
        total = 0;
    }

    public TicketBuilder agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
        return this;
    }

    public Ticket build() {
        return new Ticket(productos, total);
    }
}