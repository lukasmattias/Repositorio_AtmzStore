 package dados;

import java.util.ArrayList;
import java.util.List;

import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.Pedido;
import negocio.beans.Produto;
import negocio.beans.Status;

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
    public void adicionarPedido(Pedido pedido) throws OperacaoInvalidaException{
        boolean existe = false;
        for (Pedido p : this.pedidos){
            if (p.getId() == pedido.getId()){
                existe = true;
            }
        }
        if (existe){
            throw new OperacaoInvalidaException("O ID do pedido já foi cadastrado.");
        }
        pedido.setId(idProxDisponivel);
        pedidos.add(pedido);
        idProxDisponivel++;
        pedido.getCliente().getPedidos().add(pedido);
        pedido.getCliente().getCarrinho().getItens().clear();
    }
    
    @Override
    public String obterDetalhesPedido(Pedido pedido) throws OperacaoInvalidaException{
        if (!this.pedidos.contains(pedido)){
            throw new OperacaoInvalidaException("Pedido não foi cadastrado no sistema.");
        }
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
       public List<Item> listarItensDoPedido(Pedido pedido) {
        if(this.pedidos.contains(pedido)){
            return pedido.getItens();
        }
        return null;
    }

    @Override
    public List<Pedido> listarPedidosPorCliente(Cliente cliente) {
        return cliente.getPedidos();
    }

    @Override
    public boolean verificarPedidoExistente(Pedido pedido) {
        for (Pedido p : this.pedidos) {
            if (p.getId() == pedido.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerPedido(Pedido pedido) throws OperacaoInvalidaException {
        if (!this.pedidos.contains(pedido)){
            throw new OperacaoInvalidaException("O pedido não foi cadastrado no sistema.");
        }
            pedidos.remove(pedido);
            pedido.getCliente().getPedidos().remove(pedido);
            pedido.setStatusDePagamento(Status.CANCELADO);
    }

}
