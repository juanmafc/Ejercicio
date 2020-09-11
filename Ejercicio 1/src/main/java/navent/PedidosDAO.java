package navent;

public class PedidosDAO {

    static void insertOrUpdate(Pedido pedido) {
        System.out.println("insertOrUpdate pedido");
    }

    static void delete(Pedido pedido) {
        System.out.println("delete pedido");
    }

    static Pedido select(Integer idPedido) {
        System.out.println("select pedido");
        return new Pedido("nombre", 10, 5);
    }

}
