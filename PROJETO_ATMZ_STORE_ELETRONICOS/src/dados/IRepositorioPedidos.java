package dados;

import java.util.List;

import negocio.beans.Pedido;

public interface IRepositorioPedidos {

	void adicionarPedido(Pedido pedido);

	Pedido buscarPedidoPorId(int id);

	List<Pedido> listarPedidos();

	void atualizarPedido(Pedido pedido);

	void removerPedido(Pedido pedido);

}