package gui;

import negocio.AdministradorController;
import negocio.CarrinhoDeComprasController;
import negocio.CategoriaController;
import negocio.ClienteController;
import negocio.Fachada;
import negocio.PagamentoController;
import negocio.PedidoController;
import negocio.ProdutoController;
import negocio.beans.Categoria;
import negocio.beans.Cliente;
import negocio.beans.Endereco;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.Produto;

public class Teste {

	public static void main(String[] args) {
	ClienteController clienteController = ClienteController.getInstancia();
	AdministradorController administradorController = AdministradorController.getInstancia();
	CategoriaController categoriaController = CategoriaController.getInstancia();	
	PagamentoController pagamentoController = PagamentoController.getInstancia();
	PedidoController pedidoController = PedidoController.getInstancia();
	ProdutoController produtoController = ProdutoController.getInstancia();
	CarrinhoDeComprasController carrinhoController = CarrinhoDeComprasController.getInstancia();
	Fachada fachada = Fachada.getInstance();
	
	// instanciando clientes
	fachada.cadastrarCliente(null, null, null, null);
	}
}
