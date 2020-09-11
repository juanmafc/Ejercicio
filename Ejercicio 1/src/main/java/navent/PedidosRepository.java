package navent;

import java.util.*;

public class PedidosRepository {

    private PedidosCache cache = new PedidosCache();

    public void create(Pedido pedido) {
        resetCacheIfNeeded();
        insertPedido(pedido);
    }

    private void resetCacheIfNeeded() {
        if( cache.needsResetting() ) {
            saveUpdatedPedidos();
            cache.reset();
        }
    }

    private void saveUpdatedPedidos() {
        cache.getDirtyPedidos().forEach(pedido -> {
            PedidosDAO.insertOrUpdate(pedido);
        });
    }

    private void insertPedido(Pedido pedido) {
        PedidosDAO.insertOrUpdate(pedido);
        cache.add(pedido);
    }

    public void delete(Pedido pedido) {
        PedidosDAO.delete(pedido);
        cache.delete(pedido);
    }

    public Optional<Pedido> get(Integer id) {
        if (cache.containsId(id)){
            return cache.get(id);
        }
        Pedido pedido = PedidosDAO.select(id);
        resetCacheIfNeeded();
        cache.add(pedido);
        return Optional.ofNullable(pedido);
    }

    public void update(Pedido pedido) {
        if (cache.containsId(pedido.getId())) {
            cache.update(pedido);
        }
    }
}
