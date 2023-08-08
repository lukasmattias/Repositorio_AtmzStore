package gui;

import negocio.AdministradorController;
import negocio.CarrinhoDeComprasController;
import negocio.CategoriaController;
import negocio.ClienteController;
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
	
	Cliente n = new Cliente ("Reginaldo Rossi", "ddfs", "fa", new Endereco("dcd", "cdd", "sfaf", "hth", "hgh"));
	clienteController.adicionarCliente(n);

	for (Cliente c : clienteController.listarClientes()) {
		System.out.println(c.getNome());
		System.out.println();
	}
	Categoria categoriaTeste = new Categoria ("SmarTV");
	Produto produtoTeste = new Produto("TV samsung", "32 polegadas etc", 3455, 3);
	carrinhoController.adicionarItem(n.getCarrinho(), produtoTeste, 2);
	for (ItemDoCarrinho i : carrinhoController.listarItens(n.getCarrinho())) {
		System.out.println("Itens no carrinho: ");
		System.out.println(i.getProduto().toString());
		System.out.println();
	}
	
	carrinhoController.removerItem(n.getCarrinho(), produtoTeste);
	
	for (ItemDoCarrinho i : carrinhoController.listarItens(n.getCarrinho())) {
		System.out.println("Itens no carrinho: ");
		System.out.println(i.getProduto().toString());
		System.out.println();
	}
	}

}
