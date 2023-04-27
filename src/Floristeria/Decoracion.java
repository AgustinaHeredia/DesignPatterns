package Floristeria;

public class Decoracion extends Producto {
    private String material;

    public Decoracion(String descripcion, double precio, String material) {
        super(descripcion, precio);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
