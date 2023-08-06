 package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Cliente;
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
    public String obterDetalhesPedido(Pedido pedido) {
        return pedido.toString();
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
    public List<Pedido> listarPedidosPorCliente(Cliente cliente) {
        return cliente.getPedidos();
    }

    @Override
    public void atualizarPedido(Pedido pedido) {
        // Aqui voc� pode implementar a l�gica para atualizar um pedido no reposit�rio
    }

    @Override
    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    // ... outros m�todos do reposit�rio ...
}
