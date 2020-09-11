package navent;

import java.util.Optional;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PedidosService {

    PedidosRepository repository = new PedidosRepository();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void create(Pedido pedido) {
        readWriteLock.writeLock().lock();
        repository.create(pedido);
        readWriteLock.writeLock().unlock();
    }

    public Optional<Pedido> get(Integer id) {
        readWriteLock.readLock().lock();
        Optional<Pedido> pedido = repository.get(id);
        readWriteLock.readLock().unlock();

        return pedido;
    }

    public void update(Pedido pedido) {
        readWriteLock.writeLock().lock();
        repository.update(pedido);
        readWriteLock.writeLock().unlock();
    }

    public void delete(Pedido pedido) {
        readWriteLock.writeLock().lock();
        repository.delete(pedido);
        readWriteLock.writeLock().unlock();
    }

}