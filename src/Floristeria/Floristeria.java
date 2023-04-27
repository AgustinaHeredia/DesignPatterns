package Floristeria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Floristeria {
    private String nombre;
    private double valorTotal;
    private List<Producto> stock;
    private List<Ticket> tickets;

    public Floristeria(String nombre) {
        this.nombre = nombre;
        this.valorTotal = 0;
        this.stock = new ArrayList<>();
        this.tickets = new ArrayList<>();
        cargarStock(); // Cargamos el stock al iniciar la floristería
    }

    public void addProducto(Producto producto) {
        stock.add(producto);
        actualizarStock(); // Actualizamos el archivo TXT con el nuevo stock
        valorTotal += producto.getPrecio();
    }

    public void removeProducto(Producto producto) {
        stock.remove(producto);
        actualizarStock(); // Actualizamos el archivo TXT con el nuevo stock
        valorTotal -= producto.getPrecio();
    }

    public void showStock() {
        System.out.println("Stock de la floristería " + nombre + ":");
        for (Producto producto : stock) {
            System.out.println(producto.toString());
        }
    }

    public void showTotalValue() {
        System.out.println("Valor total del stock de la floristería " + nombre + ": " + valorTotal);
    }

    public Ticket crearTicket(List<Producto> productosComprados) {
        Ticket ticket = new TicketBuilder()
            .agregarProducto(productosComprados.get(0))
            .agregarProducto(productosComprados.get(1))
            .agregarProducto(productosComprados.get(2))
            .build();

        tickets.add(ticket);
        return ticket;
    }

    public void showPurchaseHistory() {
    	if (tickets.isEmpty()) {
            System.out.println("Aún no se han registrado compras anteriores.");
        } else {
            System.out.println("Historial de compras de la floristería " + nombre + ":");
            for (Ticket ticket : tickets) {
                System.out.println(ticket.toString());
            }
        }
    }

    public void showTotalRevenue() {
    	double totalRevenue = 0;
        for (Ticket ticket : tickets) {
            totalRevenue += ticket.getTotal();
        }
        System.out.println("Total de dinero ganado: " + totalRevenue);
    }

    private void cargarStock() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombre + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                String tipo = partes[0];
                String descripcion = partes[1];
                double precio = Double.parseDouble(partes[2]);

                switch (tipo) {
                    case "arbol":
                        int altura = Integer.parseInt(partes[3]);
                        Arbol arbol = new Arbol(descripcion, precio, altura);
                        stock.add(arbol);
                        valorTotal += precio;
                        break;
                    case "flor":
                        String color = partes[3];
                        Flor flor = new Flor(descripcion, precio, color);
                        stock.add(flor);
                        valorTotal += precio;
                        break;
                    case "decoracion":
                        String material = partes[3];
                        Decoracion decoracion = new Decoracion(descripcion, precio, material);
                        stock.add(decoracion);
                        valorTotal += precio;
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el stock: " + e.getMessage());
        }
    }

    private void actualizarStock() {
        try (FileWriter fw = new FileWriter(nombre + ".txt")) {
            for (Producto producto : stock) {
                String tipo = "";
                String atributoExtra = "";
                if (producto instanceof Arbol) {
                    tipo = "arbol";
                    atributoExtra = "," + ((Arbol) producto).getAltura();
                } else if (producto instanceof Flor) {
                    tipo = "flor";
                    atributoExtra = "," + ((Flor) producto).getColor();
                } else if (producto instanceof Decoracion) {
                    tipo = "decoracion";
                    atributoExtra = "," + ((Decoracion) producto).getMaterial();
                }
                fw.write(tipo + "," + producto.getDescripcion() + "," + producto.getPrecio() + atributoExtra + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el stock: " + e.getMessage());
        }
    }

	public String getNombre() {
		
		return null;
	}
	
	public void retirarArbol(String nombre) {
	    for (Producto producto : stock) {
	        if (producto instanceof Arbol && producto.getDescripcion().equalsIgnoreCase(nombre)) {
	            stock.remove(producto);
	            actualizarStock();
	            valorTotal -= producto.getPrecio();
	            System.out.println("Se retiró el árbol con nombre: " + nombre);
	            return;
	        }
	    }
	    System.out.println("No se encontró ningún árbol con el nombre: " + nombre);
	}

	public void retirarFlor(String nombre) {
	    for (Producto producto : stock) {
	        if (producto instanceof Flor && producto.getDescripcion().equalsIgnoreCase(nombre)) {
	            stock.remove(producto);
	            actualizarStock();
	            valorTotal -= producto.getPrecio();
	            System.out.println("Se retiró la Flor con nombre: " + nombre);
	            return;
	        }
	    }
	    System.out.println("No se encontró ninguna Flor con el nombre: " + nombre);
	}
	public void retirarDecoracion(String nombre) {
	    for (Producto producto : stock) {
	        if (producto instanceof Decoracion && producto.getDescripcion().equalsIgnoreCase(nombre)) {
	            stock.remove(producto);
	            actualizarStock();
	            valorTotal -= producto.getPrecio();
	            System.out.println("Se retiró la Decoración con nombre: " + nombre);
	            return;
	        }
	    }
	    System.out.println("No se encontró ninguna Decoración con el nombre: " + nombre);
	}
}
