package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Pedido;

public class RepositorioPedidos implements IRepositorioPedidos {
    private List<Pedido> pedidos;
    private static IRepositorioPedidos instancia;

    private RepositorioPedidos() {
        pedidos = new ArrayList<>();
    }

    public static IRepositorioPedidos getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioPedidos();
        }
        return instancia;
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    @Override
    public void atualizarPedido(Pedido pedido) {
        // Aqui você pode implementar a lógica para atualizar um pedido no repositório
    }

    @Override
    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    // ... outros métodos do repositório ...
}
