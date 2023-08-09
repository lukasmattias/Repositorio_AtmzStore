package gui;

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

		// Criando endereços
	Endereco enderecoCliente1 = new Endereco("Rua das Flores", "123", "São Paulo", "SP", "01010-000");
	Endereco enderecoCliente2 = new Endereco("Avenida dos Bandeirantes", "456", "Rio de Janeiro", "RJ", "20000-000");
	Endereco enderecoCliente3 = new Endereco("Rua das Palmeiras", "789", "Belo Horizonte", "MG", "30000-000");
	Endereco enderecoCliente4 = new Endereco("Rua das Acácias", "1011", "Curitiba", "PR", "80000-000");
	Endereco enderecoCliente5 = new Endereco("Avenida das Mangueiras", "1213", "Salvador", "BA", "40000-000");

		// Criando clientes
	Cliente cliente1 = new Cliente("João Silva", "joao.silva@gmail.com", "senha123", enderecoCliente1);
	Cliente cliente2 = new Cliente("Maria Santos", "maria.santos@gmail.com", "senha456", enderecoCliente2);
	Cliente cliente3 = new Cliente("Pedro Almeida", "pedro.almeida@gmail.com", "senha789", enderecoCliente3);
	Cliente cliente4 = new Cliente("Ana Oliveira", "ana.oliveira@gmail.com", "senha1011", enderecoCliente4);
	Cliente cliente5 = new Cliente("Lucas Souza", "lucas.souza@gmail.com", "senha1213", enderecoCliente5);

		// Cadastrando clientes
	try {
		fachada.cadastrarCliente(cliente1, enderecoCliente1);
		fachada.cadastrarCliente(cliente2, enderecoCliente2);
		fachada.cadastrarCliente(cliente3, enderecoCliente3);
		fachada.cadastrarCliente(cliente4, enderecoCliente4);
		fachada.cadastrarCliente(cliente5, enderecoCliente5);
		System.out.println("Clientes cadastrados com sucesso!");
	} catch (AtributosNulosException e) {
		System.out.println("Erro ao cadastrar clientes: " + e.getMessage());
	}
		catch (ClasseNulaException d) {
		System.out.println("Erro ao cadastrar clientes: " + d.getMessage());
		}

		// instanciando categorias
            Categoria eletronicos = new Categoria("Eletrônicos");
            Categoria smartphones = new Categoria("Smartphones");
            Categoria laptops = new Categoria("Laptops");
            Categoria acessorios = new Categoria("Acessórios");
            Categoria eletrodomesticos = new Categoria("Eletrodomésticos");
		try {
            // Cadastro das categorias usando a fachada
            fachada.cadastrarCategoria(eletronicos);
            fachada.cadastrarCategoria(smartphones);
            fachada.cadastrarCategoria(laptops);
            fachada.cadastrarCategoria(acessorios);
            fachada.cadastrarCategoria(eletrodomesticos);

            System.out.println("Categorias cadastradas com sucesso!");
        } catch (AtributosNulosException e) {
            System.out.println("Erro ao cadastrar categoria: " + e.getMessage());
        }

		// cadastrando produtos 

	 // Produtos
        Produto smartphone1 = new Produto("Smartphone Modelo X", "Descrição do Smartphone", 999.99, 50);
        Produto smartphone2 = new Produto("Smartphone Modelo Y", "Descrição do Smartphone", 1199.99, 40);
        Produto smartphone3 = new Produto("Smartphone Modelo Z", "Descrição do Smartphone", 899.99, 30);

        Produto laptop1 = new Produto("Laptop Ideapad", "Laptop de alto desempenho", 2499.99, 20);
        Produto laptop2 = new Produto("Laptop MacBook", "Laptop elegante da Apple", 2999.99, 15);
        Produto laptop3 = new Produto("Laptop Dell", "Laptop para produtividade", 2199.99, 25);

        Produto acessorio1 = new Produto("Fone de Ouvido Sem Fio", "Fone de alta qualidade", 149.99, 100);
        Produto acessorio2 = new Produto("Capa Protetora para Smartphone", "Capa resistente para proteção", 29.99, 150);
        Produto acessorio3 = new Produto("Carregador Portátil", "Carregador compacto", 39.99, 120);

        Produto eletrodomestico1 = new Produto("Geladeira Frost Free", "Geladeira espaçosa", 1799.99, 30);
        Produto eletrodomestico2 = new Produto("Máquina de Lavar Roupas", "Máquina eficiente", 1299.99, 40);
        Produto eletrodomestico3 = new Produto("Liquidificador 5 Velocidades", "Liquidificador potente", 99.99, 60);
		try {
		// Adicionar produtos às categorias
        fachada.cadastrarProduto(smartphone1);
        fachada.cadastrarProduto(smartphone2);
        fachada.cadastrarProduto(smartphone3);

    	fachada.cadastrarProduto(laptop1);
        fachada.cadastrarProduto(laptop2);
        fachada.cadastrarProduto(laptop3);

        fachada.cadastrarProduto(acessorio1);
        fachada.cadastrarProduto(acessorio2);
        fachada.cadastrarProduto(acessorio3);

        fachada.cadastrarProduto(eletrodomestico1);
       	fachada.cadastrarProduto(eletrodomestico2);
        fachada.cadastrarProduto(eletrodomestico3);

        System.out.println("Produtos cadastrados com sucesso!");
		}
		catch (ClasseNulaException e){
			System.out.println("Erro ao cadastrar os produtos:" + e.getMessage());
		}
		catch (OperacaoInvalidaException d){
			System.out.println("Erro ao cadastrar os produtos:" + d.getMessage());
		}
		// adicionando-os a categorias
		try {
		// Adicionar produtos às categorias
        fachada.adicionarProdutoACategoria(smartphone1, smartphones);
        fachada.adicionarProdutoACategoria(smartphone2, smartphones);
        fachada.adicionarProdutoACategoria(smartphone3, smartphones);

        fachada.adicionarProdutoACategoria(laptop1, laptops);
        fachada.adicionarProdutoACategoria(laptop2, laptops);
        fachada.adicionarProdutoACategoria(laptop3, laptops);

        fachada.adicionarProdutoACategoria(acessorio1, acessorios);
        fachada.adicionarProdutoACategoria(acessorio2, acessorios);
        fachada.adicionarProdutoACategoria(acessorio3, acessorios);

        fachada.adicionarProdutoACategoria(eletrodomestico1, eletrodomesticos);
        fachada.adicionarProdutoACategoria(eletrodomestico2, eletrodomesticos);
        fachada.adicionarProdutoACategoria(eletrodomestico3, eletrodomesticos);

        System.out.println("Produtos cadastrados com sucesso!");
		}
		catch (ClasseNulaException e){
			System.out.println("Erro ao cadastrar o produto na categoria" + e.getMessage());
		}
		catch (OperacaoInvalidaException d){
			System.out.println("Erro ao cadastrar o produto na categoria" + d.getMessage());
		}
    }
}

