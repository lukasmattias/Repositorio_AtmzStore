package gui;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.FalhaPagamentoException;
import exception.OperacaoInvalidaException;
import negocio.UsuarioController;
import negocio.CarrinhoDeComprasController;
import negocio.CategoriaController;
import negocio.PagamentoController;
import negocio.PedidoController;
import negocio.ProdutoController;
import negocio.beans.Administrador;
import negocio.beans.CartaoDeCredito;
import negocio.beans.Categoria;
import negocio.beans.Cliente;
import negocio.beans.Endereco;
import negocio.beans.Item;
import negocio.beans.Pagamento;
import negocio.beans.PagamentoPix;
import negocio.beans.Pedido;
import negocio.beans.Produto;
import negocio.beans.Status;
import negocio.beans.Usuario;

public class Teste {

	public static void main(String[] args) {
		UsuarioController usuarioController = UsuarioController.getInstancia();
		CategoriaController categoriaController = CategoriaController.getInstancia();	
		PagamentoController pagamentoController = PagamentoController.getInstancia();
		PedidoController pedidoController = PedidoController.getInstancia();
		ProdutoController produtoController = ProdutoController.getInstancia();
		CarrinhoDeComprasController carrinhoController = CarrinhoDeComprasController.getInstancia();

		
		// instanciando Usuarios
	
			// Criando 3 endereços válidos
		Endereco endereco1 = new Endereco("Rua das Flores", "123", "São Paulo", "SP", "01010-000");
		Endereco endereco2 = new Endereco("Avenida dos Bandeirantes", "456", "Rio de Janeiro", "RJ", "20000-000");
		Endereco endereco3 = new Endereco("Rua das Palmeiras", "789", "Belo Horizonte", "MG", "30000-000");
		
		// Criando 3 endereços inválidos
		Endereco endereco4 = new Endereco(null, "1011", "Curitiba", "PR", "80000-000");
		Endereco endereco5 = new Endereco("Avenida das Mangueiras", null, "Salvador", "BA", "40000-000");
		Endereco endereco6 = new Endereco("Avenida do Marco", "1444", "Limoeiro", "PE", "");
		
		// Criando 3 Usuarios válidos
		Cliente cliente1 = new Cliente("João Silva", "joao.silva@gmail.com", "senha123", endereco1);
		Cliente cliente2 = new Cliente("Maria Santos", "maria.santos@gmail.com", "senha456", endereco2);
		Cliente cliente3 = new Cliente("Pedro Almeida", "pedro.almeida@gmail.com", "senha789", endereco3);
		
		// criando 3 Usuarios inválidos
		Cliente cliente4 = new Cliente(null, "ana.oliveira@gmail.com", "senha1011", endereco1);
		Cliente cliente5 = new Cliente("Lucas Souza", "lucas.souza@gmail.com", " ", null);	
		Cliente cliente6 = new Cliente("Bruno Menezes", "lucas.souza@gmail.com", "senha1213", endereco6);	

		// criando 3 UsuarioslistarUsuarios válidos
		Administrador admin1 = new Administrador("Ana Silva", "ana.silva@example.com", "senha123", endereco1);
		Administrador admin2 = new Administrador("Carlos Santos", "carlos.santos@example.com", "senha456", endereco2);
		Administrador admin3 = new Administrador("Mariana Oliveira", "mariana.oliveira@example.com", "senha789", endereco3);
		
		// criando 3 UsuarioslistarUsuarios inválidos
		Administrador admin4 = new Administrador(" ", "rafael.souza@example.com", "senha1011", endereco4);
		Administrador admin5 = new Administrador("Lúcia Costa", null, "senha1213", endereco1);
		Administrador admin6 = new Administrador("Fernando Almeida", "fernando.almeida@example.com", "", endereco6);
		
		// Cadastrando cliente com dados corretos
		usuarioController.cadastrarUsuario(cliente1);
		usuarioController.cadastrarUsuario(cliente2);
		usuarioController.cadastrarUsuario(cliente3);

		// Tentando cadastrar cliente com dados invalidos
		usuarioController.cadastrarUsuario(cliente4);
		usuarioController.cadastrarUsuario(cliente5);
		usuarioController.cadastrarUsuario(cliente6);

		// LISTANDO OS Usuarios CADASTRADOS
		System.out.println("Usuarios CADASTRADOS:");
		for (Usuario c : usuarioController.listarClientes()){
			System.out.println(c.getNome() + ", ID: " + c.getId());
		}

		// Cadastrando administrador com dados corretos
		usuarioController.cadastrarUsuario(admin1);
		usuarioController.cadastrarUsuario(admin2);
		usuarioController.cadastrarUsuario(admin3);

		// Tentando cadastrar administrador com dados incorretos
		usuarioController.cadastrarUsuario(admin4);
		usuarioController.cadastrarUsuario(admin5);
		usuarioController.cadastrarUsuario(admin6);
		
		// LISTANDO OS UsuarioslistarUsuarios CADASTRADOS
		System.out.println("-----------------------------------------");
		System.out.println("ADM's CADASTRADOS:");
		for (Usuario a : usuarioController.listarAdministradores()){
			System.out.println(a.getNome() + ", ID: " + a.getId());
		}
		
		System.out.println("-----------------------------------------");
 
		// LISTANDO CATEGORIAS CADASTRADAS
		System.out.println("CATEGORIAS CADASTRADAS:");
		for (Categoria c : categoriaController.listarCategorias()){
			System.out.println(c.getNome() + ", ID: " + c.getId());
		}

		System.out.println("-----------------------------------------");
		
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

		// LISTANDO PRODUTOS CADASTRADAS
		System.out.println("PRODUTOS CADASTRADOS:");
		for (Produto p : produtoController.listarProdutos()){
			System.out.println(p.getNome() + ", ID: " + p.getId());
		}
		
		System.out.println("-----------------------------------------");

		// Cadastrando 3 produtos válidos a categoria
		try{
		categoriaController.adicionarProdutoACategoria(laptop1, "eletrodomesticos");
		System.out.println("SUCESSO");
		}
		catch (OperacaoInvalidaException e){
			e.getStackTrace();
		}

		try{
		categoriaController.adicionarProdutoACategoria(eletrodomestico1, "eletrodomesticos");
		System.out.println("SUCESSO");
		}
		catch (OperacaoInvalidaException e){
			e.getStackTrace();
		}
		catch(ClasseNulaException a){
            a.getMessage();
        }

		try{
		categoriaController.adicionarProdutoACategoria(smartphone1, "smartphones");
			System.out.println("SUCESSO");
		}
		catch (OperacaoInvalidaException e){
			e.getStackTrace();
		}
		catch(ClasseNulaException a){
            a.getMessage();
        }

		// tentando adicionar 2 produtos inválido a categoria
		try{
			categoriaController.adicionarProdutoACategoria(laptop2, "laptops");
		}
		catch (OperacaoInvalidaException e){
			e.getMessage();
		}
		catch(ClasseNulaException a){
            a.getMessage();
        }
		try{
			categoriaController.adicionarProdutoACategoria(smartphone2, "laptops");
		}
		catch (OperacaoInvalidaException e){
			e.getMessage();
		}
		catch(ClasseNulaException a){
            a.getMessage();
        }

		System.out.println("LISTANDO PRODUTOS NAS CATEGORIAS:");	
				for (Categoria c : categoriaController.listarCategorias()){
					System.out.println("CATEGORIA " + c.getNome() + ":");
					for (Produto p : categoriaController.listarProdutosDaCategoria(c.getNome())){
						System.out.println(p.getNome() + ", ID: " + p.getId());
					}
					System.out.println();
		}	
		System.out.println("-------------------------------------------------");
		System.out.println("ESTOQUE DOS PRODUTOS ANTES DE ADIÇÃO AO CARRINHO:");
		System.out.println();
		for (Produto p : produtoController.listarProdutos()){
			System.out.println(p.getNome() + ", estoque: " + p.getEstoque() + " unidades.");
		}

		// adicionando produtos ao carrinho de 3 Usuarios
		//primeiro
		carrinhoController.adicionarProdutoNoCarrinho(cliente1.getCarrinho(), laptop1, 10);
		carrinhoController.adicionarProdutoNoCarrinho(cliente1.getCarrinho(), eletrodomestico1, 1);
		//segundo
		carrinhoController.adicionarProdutoNoCarrinho(cliente2.getCarrinho(), smartphone1, 16);
		carrinhoController.adicionarProdutoNoCarrinho(cliente2.getCarrinho(), eletrodomestico1, 7);
		// terceiro com uma adição inválida
		carrinhoController.adicionarProdutoNoCarrinho(cliente3.getCarrinho(), eletrodomestico1, 6);
		carrinhoController.adicionarProdutoNoCarrinho(cliente3.getCarrinho(), laptop1, 3);
		
		System.out.println("-------------------------------------------------");
		System.out.println("ESTOQUE DOS PRODUTOS DEPOIS DE ADIÇÃO AO CARRINHO:");
		System.out.println();
			for (Produto p : produtoController.listarProdutos()){
			System.out.println(p.getNome() + ", estoque: " + p.getEstoque() + " unidades.");
		}

		System.out.println("-----------------------------------------");
		System.out.println("LISTANDO ÍTENS NO CARRINHO POR CLIENTE:");
		// LISTANDO ÍTENS NO CARRINHO
		for (Usuario c : usuarioController.listarUsuarios()){
				if (c instanceof Cliente){
					Cliente cliente = (Cliente) c;
					System.out.println("=> Carrinho de " + c.getNome() + ":");
					for (Item i : carrinhoController.listarItens(cliente.getCarrinho())){
						System.out.println(i.getProduto().getNome() + ", quantidade: " + i.getQuantidade());
						System.out.println();
				}
			}
									
		}
		
		
		System.out.println("-----------------------------------------");
		// LISTANDO PEDIDOS POR CLIENTE
		

		// Criando 2 pedidos a partir do carrinho dos Usuarios
		// cliente 1
		Pedido pedidoCliente1 = pedidoController.criarPedido(cliente1);
		// cliente 2
		Pedido pedidoCliente2 = pedidoController.criarPedido(cliente2);
	
		Pedido pedidoCliente3 = pedidoController.criarPedido(cliente3);
		
		System.out.println("LISTANDO PEDIDOS POR CLIENTE:");
	
		for (Cliente c: usuarioController.listarClientes()){	
			for (Pedido p: pedidoController.listarPedidosPorCliente(c)){
				System.out.println("ID do pedido: " + p.getId() + ", ID do cliente associado: " + c.getId());
				System.out.println("Ítens: ");
				
				for (Item i : pedidoController.listarItensDoPedido(c.getPedidos().get(c.getPedidos().size()-1))){
				System.out.println(i.getProduto().getNome()+ ", quantidade: " + i.getQuantidade());
				}
				System.out.println();
			}
	 }
		// Simulando o pagamento do pedido 1 com cartão de crédito => SUCESSO (Dados e valor compatível com o pedido)
		if (pedidoCliente1 != null){
			CartaoDeCredito pagClient1 = new CartaoDeCredito(2,"424214215", "234", cliente1.getNome(), LocalDate.of(2023, 12, 10), pedidoCliente1.getValorTotal());
			try {
				pagamentoController.realizarPagamento(pedidoCliente1, pagClient1);
			} catch (FalhaPagamentoException e) {
				e.getMessage();
			}
		}
		
		// Simulando o pagamento do pedido 2 com pix => SUCESSO (Dados e valor compatível com o pedido)
		if (pedidoCliente2 != null){
			// CHAVE PIX ESPERADA: 12.345.678/0001-23 => CNPJ da ATMZ Store
			PagamentoPix pagClient2 = new PagamentoPix(pedidoCliente2.getValorTotal(), "12.345.678/0001-23");
			try {
				pagamentoController.realizarPagamento(pedidoCliente2, pagClient2);
			} catch (FalhaPagamentoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Simulando o pagamento do pedido 3 com pix => FALHA (Dados incompatíveis com a chaPix esperada> 12.345.678/0001-23)
		if (pedidoCliente2 != null){
			// CHAVE PIX ESPERADA: 12.345.678/0001-23 => CNPJ da ATMZ Store
			PagamentoPix pagClient2 = new PagamentoPix(pedidoCliente2.getValorTotal(), "5553263624");
			try {
				pagamentoController.realizarPagamento(pedidoCliente3, pagClient2);
			} catch (FalhaPagamentoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("VERIFICANDO O STATUS DO PEDIDO APÓS TENTATIVAS DE PAGAMENTO:");
		for (Pedido p : pedidoController.listarPedidos()){
			System.out.println("Pedido de ID " + p.getId() + ": " + p.getStatus());
		}

		System.out.println("-----------------------------------------");
		System.out.println("CANCELANDO OS PEDIDOS QUE NÃO FORAM PAGOS... ");
		List<Pedido> pedidosParaCancelar = new ArrayList<>(pedidoController.listarPedidos());
		for (Pedido p : pedidosParaCancelar) {
    	if (!p.getStatus().equals(Status.PAGO)) {
        pedidoController.cancelarPedido(p);
    	}
		}

		System.out.println("-----------------------------------------");
		System.out.println("VERIFICANDO STATUS DOS PEDIDOS:");
		for (Pedido p : pedidoController.listarPedidos()){
			System.out.println("Pedido de ID " + p.getId() + ": " + p.getStatus());
		}
}
}
