package gui;

import java.time.LocalDate;

import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import negocio.AdministradorController;
import negocio.CarrinhoDeComprasController;
import negocio.CategoriaController;
import negocio.ClienteController;
import negocio.Fachada;
import negocio.PagamentoController;
import negocio.PedidoController;
import negocio.ProdutoController;
import negocio.beans.CartaoDeCredito;
import negocio.beans.Categoria;
import negocio.beans.Cliente;
import negocio.beans.Endereco;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.Pagamento;
import negocio.beans.PagamentoPix;
import negocio.beans.Pedido;
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

		// Criando 3 endereços válidos
	Endereco enderecoCliente1 = new Endereco("Rua das Flores", "123", "São Paulo", "SP", "01010-000");
	Endereco enderecoCliente2 = new Endereco("Avenida dos Bandeirantes", "456", "Rio de Janeiro", "RJ", "20000-000");
	Endereco enderecoCliente3 = new Endereco("Rua das Palmeiras", "789", "Belo Horizonte", "MG", "30000-000");
		// Criando 3 endereços inválidos
	Endereco enderecoCliente4 = new Endereco("Rua das Acácias", "1011", "Curitiba", "PR", "80000-000");
	Endereco enderecoCliente5 = new Endereco("Avenida das Mangueiras", "1213", "Salvador", "BA", "40000-000");
	Endereco enderecoCliente6 = new Endereco("Avenida do Marco", "1444", "Limoeiro", "PE", "40202-000");
	
	// Criando 3 clientes válidos
	Cliente cliente1 = new Cliente("João Silva", "joao.silva@gmail.com", "senha123", enderecoCliente1);
	Cliente cliente2 = new Cliente("Maria Santos", null, "senha456", enderecoCliente2);
	Cliente cliente3 = new Cliente("Pedro Almeida", "pedro.almeida@gmail.com", "senha789", enderecoCliente3);
	
	// criando 3 clientes inválidos
	Cliente cliente4 = new Cliente(null, "ana.oliveira@gmail.com", "senha1011", enderecoCliente4);
	Cliente cliente5 = new Cliente("Lucas Souza", "lucas.souza@gmail.com", " ", enderecoCliente5);	
	Cliente cliente6 = new Cliente("Mano Menezes", "lucas.souza@gmail.com", "senha1213", enderecoCliente5);	

		// Cadastrando cliente com dados corretos
		clienteController.cadastrarCliente(cliente1, enderecoCliente1);
		clienteController.cadastrarCliente(cliente2, enderecoCliente2);
		clienteController.cadastrarCliente(cliente3, enderecoCliente3);

		// Tentando cadastrar cliente com dados invalidos
		clienteController.cadastrarCliente(cliente4, enderecoCliente4);
		clienteController.cadastrarCliente(cliente5, enderecoCliente5);
		clienteController.cadastrarCliente(cliente6, enderecoCliente6);

		// instanciando 3 categorias válidas
		Categoria eletrodomesticos = new Categoria("Eletrodomésticos");
		Categoria smartphones = new Categoria("Smartphones");
		Categoria laptops = new Categoria("Laptops");
		
		// instanciando 2 categorias com dados válidos
		Categoria acessorios = new Categoria(null);
		Categoria eletronicos = new Categoria("Laptops"); // nome repetido
		
 
		// Cadastrando categorias com dados válidos
	
    categoriaController.cadastrarCategoria(eletrodomesticos);
		categoriaController.cadastrarCategoria(smartphones);
		categoriaController.cadastrarCategoria(laptops);

    // Tentando cadastrar categorias com dados inválidos

		categoriaController.cadastrarCategoria(laptops);
		categoriaController.cadastrarCategoria(acessorios);
		
			//Instanciando 3 produtos válidos
        Produto laptop1 = new Produto("Laptop Ideapad", "Laptop de alto desempenho", 2499.99, 20);
				Produto eletrodomestico1 = new Produto("Geladeira Frost Free", "Geladeira espaçosa", 1799.99, 30);
				Produto smartphone1 = new Produto("Smartphone Modelo X", "Descrição do Smartphone", 999.99, 50);
				

			//Instanciando 2 produtos inválidos
				Produto laptop2 = new Produto(null, "Laptop elegante da Apple", 2999.99, 15);
				Produto smartphone2 = new Produto("Smartphone Modelo X", "", 999.99, 50);

		// Cadastrar produto válidos
    	produtoController.cadastrarProduto(laptop1);
			produtoController.cadastrarProduto(eletrodomestico1);
			produtoController.cadastrarProduto(smartphone1);
	
		// Tentando cadastrar produtos inválidos
			produtoController.cadastrarProduto(laptop2);
      produtoController.cadastrarProduto(smartphone2);
			produtoController.cadastrarProduto(smartphone2); // repetição

		// Cadastrando 3 produtos válidos a categoria
		categoriaController.adicionarProdutoACategoria(laptop1, laptops);
		categoriaController.adicionarProdutoACategoria(eletrodomestico1, eletrodomesticos);
		categoriaController.adicionarProdutoACategoria(smartphone1, smartphones);

		// tentando adicionar 2 produtos inválido a categoria
				categoriaController.adicionarProdutoACategoria(laptop2, laptops);
        categoriaController.adicionarProdutoACategoria(smartphone2, laptops);

		// adicionando produtos ao carrinho de 2 clientes
		//primeiro
		carrinhoController.adicionarProdutoNoCarrinho(cliente1.getCarrinho(), laptop1, 3);
		carrinhoController.adicionarProdutoNoCarrinho(cliente1.getCarrinho(), eletrodomestico1, 1);
		//segundo
		carrinhoController.adicionarProdutoNoCarrinho(cliente1.getCarrinho(), smartphone1, 5);
		carrinhoController.adicionarProdutoNoCarrinho(cliente1.getCarrinho(), eletrodomestico1, 7);

		// Criando 2 pedidos a partir do carrinho dos clientes
		// cliente 1
		Pedido pedidoCliente1 = pedidoController.criarPedido(cliente1);
		// cliente 2
		Pedido pedidoCliente2 = pedidoController.criarPedido(cliente2);
		
		// Simulando o pagamento do pedido 1 com cartão de crédito
		if (pedidoCliente1 != null){
			CartaoDeCredito pagClient1 = new CartaoDeCredito(2,"424214215", "234", cliente1.getNome(), LocalDate.of(2023, 12, 10), pedidoCliente1.getValorTotal());
			pagamentoController.realizarPagamento(pedidoCliente1, pagClient1);
		}
		
		// Simulando o pagamento do pedido 2 com pix
		if (pedidoCliente2 != null){
			// CHAVE PIX ESPERADA: 12.345.678/0001-23 => CNPJ da ATMZ Store
			PagamentoPix pagClient2 = new PagamentoPix(pedidoCliente2.getValorTotal(), "12.345.678/0001-23");
			pagamentoController.realizarPagamento(pedidoCliente2, pagClient2);
		}

		// IMPRIMINDO RESULTADOS
		// clientes
		for (Cliente c : clienteController.listarClientes()){
			System.out.println(c.toString());
		}
		System.out.println("-----------------------------------------");
		// categorias
		for (Categoria c : categoriaController.listarCategorias()){
				System.out.println(c.toString());
		}
		// produtos
		System.out.println("-----------------------------------------");
		for (Produto p : produtoController.listarProdutos()){
				System.out.println(p.toString());
		}
}
}
