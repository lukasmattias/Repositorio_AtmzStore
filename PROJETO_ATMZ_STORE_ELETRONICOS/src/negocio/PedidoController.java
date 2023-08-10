package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.IRepositorioPedidos;
import dados.RepositorioPedidos;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import exception.PedidoInvalidoException;
import negocio.beans.CarrinhoDeCompras;
import negocio.beans.Cliente;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.ItemPedido;
import negocio.beans.Pedido;
import negocio.beans.Status;

public class PedidoController {
    private static PedidoController instancia;
    private IRepositorioPedidos repositorioPedidos;
    private EstoqueController estoqueController = new EstoqueController();

    private PedidoController() {
        repositorioPedidos = RepositorioPedidos.getInstancia();
    }

    public static PedidoController getInstancia() {
        if (instancia == null) {
            instancia = new PedidoController();
        }
        return instancia;
    }

     public Pedido criarPedido(Cliente cliente) {
    	// verificando se o cliente é nulo ou se o seu carrinho está vazio
    	
        if (cliente == null || cliente.getCarrinho().getItens().isEmpty() || cliente.getId() == 0) {
            return null;
        } 
    	List<ItemPedido> itens = new ArrayList<>();
    	
    	// Transformando os ItemDoCarrinho em ItemPedido
    	
    	for (ItemDoCarrinho ic : cliente.getCarrinho().getItens()) {
    		ItemPedido ip = new ItemPedido(ic.getProduto(), ic.getQuantidade());
    		itens.add(ip);
    	}
    	// criando um novo pedido com base nos ítens transferidos
    	
        Pedido novoPedido = new Pedido(cliente, itens);
        cliente.getCarrinho().getItens().clear();
        repositorioPedidos.adicionarPedido(novoPedido);
        return novoPedido;
    }
 
    // Calcular o total de um pedido com base nos sub-totais dos ItemPedido
    public double calcularTotalDoPedido(Pedido pedido) {
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
    
    public List<ItemPedido> listarItensDoPedido(Pedido pedido){
        return repositorioPedidos.listarItensDoPedido(pedido);
    }

    public void cancelarPedido(Pedido pedido) {
    	if (pedido == null || pedido.getPagamento() != null || pedido.getCliente() == null || pedido.getData() == null || pedido.getItens().isEmpty()){
            return;
        }

        boolean existe = repositorioPedidos.verificarPedidoExistente(pedido);
        
        if (existe){    
            for (ItemPedido p : pedido.getItens()){
                estoqueController.aumentarEstoque(p.getProduto(), p.getQuantidade());
            } 
            pedido.setStatusDePagamento(Status.CANCELADO);  
        }

    }    
}

