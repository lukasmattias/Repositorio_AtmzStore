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

		// Criando clientes
	Cliente cliente1 = new Cliente("João Silva", "joao.silva@gmail.com", "senha123", enderecoCliente1);
	Cliente cliente2 = new Cliente("Maria Santos", null, "senha456", enderecoCliente2);

		// Cadastrando cliente com dados corretos
	try {
		fachada.cadastrarCliente(cliente1, enderecoCliente1);
		System.out.println("Clientes cadastrados com sucesso!");
	} catch (AtributosNulosException e) {
		System.out.println("Erro ao cadastrar clientes: " + e.getMessage());
	}
		catch (ClasseNulaException d) {
		System.out.println("Erro ao cadastrar clientes: " + d.getMessage());
		}
		// Tentando cadastrar cliente com dados invpalidos

			try {
		fachada.cadastrarCliente(cliente2, enderecoCliente2);
		System.out.println("Cliente cadastradoo com sucesso!");
	} catch (AtributosNulosException e) {
		System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
	}
		catch (ClasseNulaException d) {
		System.out.println("Erro ao cadastrar cliente: " + d.getMessage());
		}

		// instanciando categorias
            Categoria laptops = new Categoria("Laptops");
            Categoria smartphones = new Categoria(null);
	
		// Tentando cadastrar categoria com dados válidos
		try {
            fachada.cadastrarCategoria(laptops);
            System.out.println("Categorias cadastradas com sucesso!");
        } catch (AtributosNulosException e) {
            System.out.println("Erro ao cadastrar categoria: " + e.getMessage());
        }

		// Tentando cadastrar categoria com dados inválidos
		try {
            fachada.cadastrarCategoria(smartphones);
            System.out.println("Categorias cadastradas com sucesso!");

        } catch (AtributosNulosException e) {
            System.out.println("Erro ao cadastrar categoria: " + e.getMessage());
        }
		// cadastrando produtos 

	 // Produtos
 
        Produto laptop1 = new Produto("Laptop Ideapad", "Laptop de alto desempenho", 2499.99, 20);
        Produto laptop2 = new Produto(null, "Laptop elegante da Apple", 2999.99, 15);
        
		try {
		// tentando cadastrar produto válido
    	fachada.cadastrarProduto(laptop1);

        System.out.println("Produto cadastrado com sucesso!");
		}
		catch (ClasseNulaException e){
			System.out.println("Erro ao cadastrar os produtos:" + e.getMessage());
		}
		catch (OperacaoInvalidaException d){
			System.out.println("Erro ao cadastrar os produtos:" + d.getMessage());
		}

		// tentando cadastrar produto inválido
		try {
    	fachada.cadastrarProduto(laptop2);
        System.out.println("Produto cadastrado com sucesso!");
		}
		catch (ClasseNulaException e){
			System.out.println("Erro ao cadastrar o produto:" + e.getMessage());
		}
		catch (OperacaoInvalidaException d){
			System.out.println("Erro ao cadastrar o produto:" + d.getMessage());
		}
		
		// tentando adicionar produtos válido a categoria
		try {
        fachada.adicionarProdutoACategoria(laptop1, laptops);
        System.out.println("Produtos cadastrados com sucesso!");
		}
		catch (ClasseNulaException e){
			System.out.println("Erro ao cadastrar o produto na categoria" + e.getMessage());
		}
		catch (OperacaoInvalidaException d){
			System.out.println("Erro ao cadastrar o produto na categoria" + d.getMessage());
		}
		// tentando adicionar produtos inválido a categoria
		try {
        fachada.adicionarProdutoACategoria(laptop2, laptops);
        System.out.println("Produtos cadastrados com sucesso!");
		}
		catch (ClasseNulaException e){
			System.out.println("Erro ao cadastrar o produto na categoria" + e.getMessage());
		}
		catch (OperacaoInvalidaException d){
			System.out.println("Erro ao cadastrar o produto na categoria" + d.getMessage());
		}
		catch (AtributosNulosException c){
			System.out.println("Erro ao cadastrar o produto na categoria" + c.getMessage());

		}
    }
}

