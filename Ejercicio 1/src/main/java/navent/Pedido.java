package navent;

public class Pedido {

    private Integer id;
    private String nombre;
    private Integer monto;
    private Integer descuento;

    public Pedido(String nombre, Integer monto, Integer descuento) {
        this.nombre = nombre;
        this.monto = monto;
        this.descuento = descuento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
