 package dados;

import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Cliente;
import negocio.beans.Pedido;

public class RepositorioPedidos implements IRepositorioPedidos {
    private List<Pedido> pedidos;
    private static IRepositorioPedidos instancia;
    int idProxDisponivel = 1;

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
        boolean existe = false;
        for (Pedido p : this.pedidos){
            if (p.getId() == pedido.getId()){
                existe = true;
            }
        }
        if (existe){
            throw new OperacaoInvalidaException("ID do pedido já foi cadastrado.");
        }
        pedido.setId(idProxDisponivel);
        pedidos.add(pedido);
        idProxDisponivel++;
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
        if (this.pedidos.contains(pedido)){
            pedidos.remove(pedido);  
        }

    }

    // ... outros m�todos do reposit�rio ...
}
