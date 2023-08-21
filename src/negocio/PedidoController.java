package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.IRepositorioPedidos;
import dados.IRepositorioProdutos;
import dados.IRepositorioUsuarios;
import dados.RepositorioPedidos;
import dados.RepositorioProdutos;
import dados.RepositorioUsuarios;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import negocio.beans.CarrinhoDeCompras;
import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.Pedido;
import negocio.beans.Status;

public class PedidoController {
    private static PedidoController instancia;
    private IRepositorioPedidos repositorioPedidos;
    private IRepositorioProdutos repositorioProdutos = RepositorioProdutos.getInstancia();
    private IRepositorioUsuarios repositorioUsuarios = RepositorioUsuarios.getInstancia();

    private PedidoController() {
        repositorioPedidos = RepositorioPedidos.getInstancia();
    }

    public static PedidoController getInstancia() {
        if (instancia == null) {
            instancia = new PedidoController();
        }
        return instancia;
    }

     public Pedido criarPedido(Cliente cliente) throws AtributosNulosException {
    	// verificando se o cliente é nulo ou se o seu carrinho está vazio
        if (cliente == null || cliente.getCarrinho().getItens().isEmpty() || cliente.getId() == 0) {
        throw new AtributosNulosException("Os dados do cliente não podem ser nulos ou vazios.");
        } 
    	ArrayList<Item> ItensPedido = new ArrayList<>();
        ItensPedido.addAll(cliente.getCarrinho().getItens());
    	// criando um novo pedido com base nos ítens do carrinho
        Pedido novoPedido = new Pedido(cliente, ItensPedido);
        cliente.getCarrinho().getItens().clear();
        repositorioPedidos.adicionarPedido(novoPedido);
        return novoPedido;
    }
 
    // Calcular o total de um pedido com base nos sub-totais dos ItemPedido
    public double calcularTotalDoPedido(Pedido pedido) {
        if (pedido == null){
            throw new ClasseNulaException("O pedido não pode ser nulo");
        }
        double total = 0;
        for (Item item : pedido.getItens()) {
            total += item.getSubtotal();
        }
        return total;
    }
    
    // Listar todos os pedidos de um cliente
    public List<Pedido> listarPedidosPorCliente(Cliente cliente) throws ClasseNulaException{
        if (cliente == null){
            throw new ClasseNulaException("O cliente não pode ser nulo.");
        }
        return repositorioPedidos.listarPedidosPorCliente(cliente);
    }
    
    public List<Pedido> listarPedidos() {
        return repositorioPedidos.listarPedidos();
    }
    
    public List<Item> listarItensDoPedido(Pedido pedido) throws ClasseNulaException{
        if (pedido == null){
            throw new ClasseNulaException("O pedido não pode ser nulo.");
        }
        return repositorioPedidos.listarItensDoPedido(pedido);
    }

    public void cancelarPedido(Pedido pedido) throws ClasseNulaException, OperacaoInvalidaException{
    	if (pedido == null || pedido.getPagamento() != null || pedido.getCliente() == null || pedido.getData() == null 
        || pedido.getItens().isEmpty()){
            throw new ClasseNulaException("O pedido já foi finalizado ou tem dados incompletos.");
        }
        else if (!repositorioPedidos.verificarPedidoExistente(pedido)){
            throw new OperacaoInvalidaException("O pedido não foi cadastrado");
        }
          
        for (Item p : pedido.getItens()){
            repositorioProdutos.aumentarEstoque(p.getProduto(), p.getQuantidade());
            } 
            pedido.setStatusDePagamento(Status.CANCELADO);  
        }

    }

