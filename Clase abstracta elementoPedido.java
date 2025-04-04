package restaurante.modelo;

public abstract class ElementoPedido implements Item {
    private String id;
    private String nombre;
    private double precio;

    public ElementoPedido(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public String getId() {
        return id;
    }

    public abstract String getInformacion();
}
