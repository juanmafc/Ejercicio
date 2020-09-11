package navent;

import java.util.*;

public class PedidosCache {

    private Map<Integer, Boolean> cachedIdsDirtyFlag = new HashMap<>();
    private final int LIMIT = 3;

    public void add(Pedido pedido) {
        cachedIdsDirtyFlag.put(pedido.getId(), false);
        BumexMemcached.INSTANCE.set(pedido.getId().toString(), pedido);
    }

    public boolean needsResetting() {
        return cachedIdsDirtyFlag.size() >= LIMIT;
    }

    public List<Pedido> getDirtyPedidos() {
        List<Pedido> dirtyPedidos = new LinkedList<>();
        cachedIdsDirtyFlag.forEach( (id, isDirty) -> {
            if (isDirty) {
                Pedido pedido = (Pedido) BumexMemcached.INSTANCE.get(id.toString());
                dirtyPedidos.add(pedido);
            }
        });
        return dirtyPedidos;
    }

    public void reset() {
        cachedIdsDirtyFlag.keySet().forEach(id -> {
            BumexMemcached.INSTANCE.delete(id.toString());
        });
        cachedIdsDirtyFlag = new HashMap<>();
    }

    public void delete(Pedido pedido) {
        if (containsId(pedido.getId())) {
            BumexMemcached.INSTANCE.delete(pedido.getId().toString());
        }
        cachedIdsDirtyFlag.remove(pedido.getId());
    }

    public boolean containsId(Integer id) {
        return cachedIdsDirtyFlag.containsKey(id);
    }

    public Optional<Pedido> get(Integer id) {
        Pedido pedido = (Pedido) BumexMemcached.INSTANCE.get(id.toString());
        return Optional.ofNullable(pedido);
    }

    public void update(Pedido pedido) {
        Integer id = pedido.getId();
        BumexMemcached.INSTANCE.set(id.toString(), pedido);
        cachedIdsDirtyFlag.put(id, true);
    }
}
