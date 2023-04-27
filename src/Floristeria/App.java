package Floristeria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	static Scanner input = new Scanner(System.in);
    static Floristeria floristeria = null;

    public static void main(String[] args) {
        

    	int seleccion=0;
		do {
			seleccion=pedirInt("Escribe el número de lo que desea realizar: "
					+ "\n1.- Crear Floristeria."
					+ "\n2.- Añadir Árbol."
					+ "\n3.- Añadir Flor."
					+ "\n4.- Añadir Decoración."
					+ "\n5.- Ver Stock."
					+ "\n6.- Retirar Árbol."
					+ "\n7.- Retirar Flor."
					+ "\n8.- Retirar Decoración."
					+ "\n9.- Ver Valor Total de la Floristeria."
					+ "\n10.- Crear Ticket de Compra."
					+ "\n11.- Mostrar Compras Anteriores."
					+ "\n12.- Ver Dinero Total Ganado."
					+ "\n 0-salir del programa.");
			
			switch (seleccion){ 
			case 1:
                String nombreFloristeria = pedirString("Ingresa el nombre de la Floristeria:");
                floristeria = new Floristeria(nombreFloristeria);
                System.out.println("Floristeria creada con éxito");
				break;
			case 2:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				String nombreArbol = pedirString("Inggresa el nombre del álbor.");
                double altura = pedirDouble("Ingresa la altura del árbol:");
                double precioArbol = pedirDouble("Ingresa el precio del árbol:");
                anadirArbol(nombreArbol, altura, precioArbol);
				break;
			case 3:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
				}
                    String nombreFlor = pedirString("Ingresa el nombre de la flor.");
                    double precioFlor = pedirDouble("Ingresa el precio de la Flor:");
                    String color = pedirString("Ingresa el color de la flor");
                    anadirFlor(nombreFlor, precioFlor, color);
				break;
			case 4:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				String nombreDecoracion = pedirString("Ingresa el nombre de la decoración.");
                double precioDeco = pedirDouble("Ingresa el precio de la Decoración:");
                String material = pedirString("Ingresa el material");
                anadirFlor(nombreDecoracion, precioDeco, material);
				break;
			case 5:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				floristeria.showStock();
				break;
			case 6:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				String nomArbol = pedirString("Ingresa el nombre del árbol que quieres retirar.");
				floristeria.retirarArbol(nomArbol);
				break;
			case 7:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				String nomFlor = pedirString("Ingresa el nombre de la Flor que quieres retirar.");
				floristeria.retirarFlor(nomFlor);
				break;
			case 8:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				String nomDeco = pedirString("Ingresa el nombre de la Decoración que quieres retirar.");
				floristeria.retirarDecoracion(nomDeco);
				break;
			case 9:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				floristeria.showTotalValue();
				break;
			case 10:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				List<Producto> productosComprados = new ArrayList<>();
				String nomProducto = pedirString("Ingresa el nombre del producto que quieres comprar");
				Producto producto = floristeria.buscarProducto(nomProducto);

				if (producto != null) {
				    productosComprados.add(producto);
				    floristeria.crearTicket(productosComprados);
				} else {
				    System.out.println("El producto no existe en la floristería.");
				}

				break;
			case 11:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				floristeria.showPurchaseHistory();
				break;
			case 12:
				if (floristeria == null) {
                    System.out.println("Primero crea una floristeria");
                    break;
                }
				floristeria.showTotalRevenue();
				break;
			case 0:
				System.out.println("Has elegido salir del programa. Hasta pronto.");
				break;
			default:
				System.out.println("El número ingresado no es correcto");
			}
			
		}while (seleccion !=0);
		
    }
    public static void anadirArbol(String nombre, double altura, double precio)
    {
    	Arbol arbol = new Arbol(nombre, altura, precio);
    	floristeria.addProducto(arbol);
    	System.out.println("Árbol añadido con éxito");
    }
    public static void anadirFlor(String nombre, double precio, String color)
    {
    	Flor flor = new Flor (nombre, precio, color);
    	floristeria.addProducto(flor);
    	System.out.println("Flor añadida con éxito");
    }
    public static void anadirDercoracion(String nombre, double precio, String material)
    {
    	Decoracion decoracion = new Decoracion (nombre, precio, material);
    	floristeria.addProducto(decoracion);
    	System.out.println("Decoración añadida con éxito");
    }
    
    //herramientas pedir
	static int pedirInt(String texto) {
		System.out.println(texto);
		int n1 = input.nextInt();
		return n1;
	}
	static String pedirString(String texto) {
		System.out.println(texto);
		String nom = input.next();
		return nom;
	}
	static Double pedirDouble(String texto) {
		System.out.println(texto);
		double dou = input.nextDouble();
		return dou;
	}
}
