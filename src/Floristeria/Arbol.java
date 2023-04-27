package Floristeria;

public class Arbol extends Producto {
    private double altura;

    public Arbol(String descripcion, double precio, double altura) {
        super(descripcion, precio);
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }
}
