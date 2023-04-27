package Floristeria;

public class Flor extends Producto {
    private String color;

    public Flor(String descripcion, double precio, String color) {
        super(descripcion, precio);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
