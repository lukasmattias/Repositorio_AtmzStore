package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.IRepositorioPedidos;
import dados.RepositorioPedidos;
import exception.PedidoInvalidoException;
import negocio.beans.Cliente;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.ItemPedido;
import negocio.beans.Pedido;
import negocio.beans.Status;
public class PedidoController {
    private static PedidoController instancia;
    private ServicoAtualizacaoStatus servicoAtualizacao;
    private IRepositorioPedidos repositorioPedidos;

    private PedidoController() {
        repositorioPedidos = RepositorioPedidos.getInstancia();
    }

    public static PedidoController getInstancia() {
        if (instancia == null) {
            instancia = new PedidoController();
        }
        return instancia;
    }
    //falta definir onde será de fato a lógica do controle de estoque
    // provavelmente reformular a lógica de criação do pedido
    
    public void criarPedido(Cliente cliente) {
    	// verificando se o cliente é nulo ou se o seu carrinho está vazio
    	
        if (cliente == null || cliente.getCarrinho().getItens().isEmpty()) {
            throw new PedidoInvalidoException();
        } 
    	List<ItemPedido> itens = new ArrayList<>();
    	
    	// Transformando os ItemDoCarrinho em ItemPedido
    	
    	for (ItemDoCarrinho ic : cliente.getCarrinho().getItens()) {
    		ItemPedido ip = new ItemPedido(ic.getProduto(), ic.getQuantidade());
    		itens.add(ip);
    	}
    	// criando um novo pedido com base nos ítens transferidos
    	
        Pedido novoPedido = new Pedido(cliente, itens);
        repositorioPedidos.adicionarPedido(novoPedido);
        
        //ainda é preciso limpar o carrinho no main ou de alguma outra forma
    }
 
    // Calcular o total de um pedido com base nos sub-totais dos ItemPedido
    public double calcularTotal(Pedido pedido) {
        double total = 0;
        for (ItemPedido item : pedido.getItens()) {
            total += item.getSubtotal();
        }
        return total;
    }
    
    // Listar todos os pedidos de um cliente
    public List<Pedido> listarPedidosPorCliente(Cliente cliente) {
        return repositorioPedidos.listarPedidosPorCliente(cliente);
    }
    
    public List<Pedido> listarPedidos() {
        return repositorioPedidos.listarPedidos();
    }
    
    private void cancelarPedido(Pedido pedido) {
    	if (pedido.getPagamento().getStatus() == Status.PENDENTE) {
    		servicoAtualizacao.atualizarStatus(pedido, Status.CANCELADO);
      	}
    }

    private void finalizarPedido(Pedido pedido) {
    	if (pedido.getPagamento().getStatus() == Status.PENDENTE) {
    		servicoAtualizacao.atualizarStatus(pedido, Status.FINALIZADO);
    	}
    }
    
}

