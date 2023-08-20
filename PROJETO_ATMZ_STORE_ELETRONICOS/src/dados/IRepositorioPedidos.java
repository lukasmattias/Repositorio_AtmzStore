package dados;

import java.util.List;

import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.Pedido;

public interface IRepositorioPedidos {

	void adicionarPedido(Pedido pedido);

	Pedido buscarPedidoPorId(int id);

	List<Pedido> listarPedidos();

	void removerPedido(Pedido pedido);

	List<Pedido> listarPedidosPorCliente(Cliente cliente);

	String obterDetalhesPedido(Pedido pedido);

	public boolean verificarPedidoExistente(Pedido pedido);
	
	public List<Item> listarItensDoPedido(Pedido pedido);

	void salvarArquivo();

}