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
	
			// Criando 6 endereços válidos
		Endereco endereco1 = new Endereco("Rua das Flores", "123", "São Paulo", "SP", "01010-000");
		Endereco endereco2 = new Endereco("Avenida dos Bandeirantes", "456", "Rio de Janeiro", "RJ", "20000-000");
		Endereco endereco3 = new Endereco("Rua das Palmeiras", "789", "Belo Horizonte", "MG", "30000-000");
		Endereco endereco4 = new Endereco("Rua das Palmas", "1011", "Curitiba", "PR", "80000-000");
		Endereco endereco5 = new Endereco("Avenida das Mangueiras", "3124", "Salvador", "BA", "40000-000");
		Endereco endereco6 = new Endereco("Avenida do Marco", "1444", "Limoeiro", "PE", "242552-00");
		
		// Criando 3 Usuarios válidos
		Cliente cliente1 = new Cliente("João Silva", "joao.silva@gmail.com", "senha123", endereco1);
		Cliente cliente2 = new Cliente("Maria Santos", "maria.santos@gmail.com", "senha456", endereco2);
		Cliente cliente3 = new Cliente("Pedro Almeida", "pedro.almeida@gmail.com", "senha789", endereco3);
		Cliente cliente4 = new Cliente("Pedro Campos", "ana.oliveira@gmail.com", "senha1011", endereco1);
		Cliente cliente5 = new Cliente("Lucas Souza", "lucas.souza@gmail.com", "senha000", endereco5);	
		Cliente cliente6 = new Cliente("Bruno Menezes", "lucadfs.souza245@gmail.com", "senha1213", endereco6);	

		// criando 6 adms válidos
		Administrador admin1 = new Administrador("Ana Silva", "ana.silva@hotmail.com", "senha123", endereco1);
		Administrador admin2 = new Administrador("Carlos Santos", "carlos.santos@hotmail.com", "senha456", endereco2);
		Administrador admin3 = new Administrador("Mariana Oliveira", "mariana.oliveira@hotmail.com", "senha789", endereco3);
		Administrador admin4 = new Administrador("Maria Eduarda", "rafael.souza@hotmail.com", "senha1011", endereco4);
		Administrador admin5 = new Administrador("Lúcia Costa", "fasffs@gmail.com", "senha1213", endereco1);
		Administrador admin6 = new Administrador("Fernando Almeida", "fernando.almeida@hotmail.com", "senha555", endereco6);
		
		
		
		// Cadastrando cliente com dados corretos
		usuarioController.cadastrarUsuario(cliente1);
		usuarioController.cadastrarUsuario(cliente2);
		usuarioController.cadastrarUsuario(cliente3);
		usuarioController.cadastrarUsuario(cliente4);
		usuarioController.cadastrarUsuario(cliente5);
		usuarioController.cadastrarUsuario(cliente6);
		// Cadastrando adms com dados corretos
		usuarioController.cadastrarUsuario(admin1);
		usuarioController.cadastrarUsuario(admin2);
		usuarioController.cadastrarUsuario(admin3);
		usuarioController.cadastrarUsuario(admin4);
		usuarioController.cadastrarUsuario(admin5);
		usuarioController.cadastrarUsuario(admin6);
		
		//Instanciando 3 produtos válidos
        Produto laptop1 = new Produto("Laptop Ideapad", "Laptop de alto desempenho", 2499.99, 20);
		Produto eletrodomestico1 = new Produto("Geladeira Frost Free", "Geladeira espaçosa", 1799.99, 30);
		Produto smartphone1 = new Produto("Smartphone Modelo X", "Descrição do Smartphone", 999.99, 50);
		

		// Cadastrar produto válidos
    	produtoController.cadastrarProduto(laptop1);
		produtoController.cadastrarProduto(eletrodomestico1);
		produtoController.cadastrarProduto(smartphone1);
		
	    
	    Produto gadget1 = new Produto("Fones de Ouvido Bluetooth", "Fones sem fio de alta qualidade", 149.99, 100);
	    Produto tv1 = new Produto("Smart TV 4K", "TV de alta definição", 1999.99, 40);
	    Produto computador1 = new Produto("PC Gamer", "Computador para jogos", 3499.99, 15);
	    Produto eletrodomestico2 = new Produto("Liquidificador", "Liquidificador potente", 89.99, 80);
	    Produto smartphone2 = new Produto("Smartphone Modelo Y", "Outro modelo de smartphone", 799.99, 70);
	    
	    Produto gadget2 = new Produto("Relógio Inteligente", "Relógio com funções smart", 199.99, 60);
	    Produto tv2 = new Produto("Soundbar", "Barra de som para TVs", 299.99, 25);
	    Produto computador2 = new Produto("Notebook UltraSlim", "Notebook leve e portátil", 1599.99, 35);
	    Produto eletrodomestico3 = new Produto("Aspirador de Pó", "Aspirador com alto poder de sucção", 129.99, 50);
	    Produto smartphone3 = new Produto("Smartphone Modelo Z", "Mais um modelo de smartphone", 1099.99, 60);
	    
	    Produto gadget3 = new Produto("Câmera de Ação", "Câmera para esportes e aventuras", 179.99, 45);
	    Produto tv3 = new Produto("Projetor Full HD", "Projetor para home theater", 899.99, 20);
	    Produto computador3 = new Produto("PC de Uso Geral", "Computador para tarefas cotidianas", 999.99, 30);
	    Produto eletrodomestico4 = new Produto("Micro-ondas", "Micro-ondas com várias funções", 149.99, 70);
	    Produto smartphone4 = new Produto("Smartphone Modelo A", "Um modelo mais antigo", 499.99, 90);

	    // Cadastrar produtos válidos
	    produtoController.cadastrarProduto(laptop1);
	    produtoController.cadastrarProduto(eletrodomestico1);
	    produtoController.cadastrarProduto(smartphone1);
	    produtoController.cadastrarProduto(gadget1);
	    produtoController.cadastrarProduto(tv1);
	    produtoController.cadastrarProduto(computador1);
	    produtoController.cadastrarProduto(eletrodomestico2);
	    produtoController.cadastrarProduto(smartphone2);
	    produtoController.cadastrarProduto(gadget2);
	    produtoController.cadastrarProduto(tv2);
	    produtoController.cadastrarProduto(computador2);
	    produtoController.cadastrarProduto(eletrodomestico3);
	    produtoController.cadastrarProduto(smartphone3);
	    produtoController.cadastrarProduto(gadget3);
	    produtoController.cadastrarProduto(tv3);
	    produtoController.cadastrarProduto(computador3);
	    produtoController.cadastrarProduto(eletrodomestico4);
	    produtoController.cadastrarProduto(smartphone4);
	    
	    categoriaController.adicionarProdutoACategoria(gadget1, "Gadgets");
	    categoriaController.adicionarProdutoACategoria(tv1, "Foto e Vídeo");
	    categoriaController.adicionarProdutoACategoria(computador1, "Computadores");
	    categoriaController.adicionarProdutoACategoria(eletrodomestico2, "Eletrodomesticos");
	    categoriaController.adicionarProdutoACategoria(smartphone2, "Smartphones");
	    categoriaController.adicionarProdutoACategoria(gadget2, "Gadgets");
	    categoriaController.adicionarProdutoACategoria(tv2, "Foto e Vídeo");
	    categoriaController.adicionarProdutoACategoria(computador2, "Computadores");
	    categoriaController.adicionarProdutoACategoria(eletrodomestico3, "Eletrodomesticos");
	    categoriaController.adicionarProdutoACategoria(smartphone3, "Smartphones");
	    categoriaController.adicionarProdutoACategoria(gadget3, "Gadgets");
	    categoriaController.adicionarProdutoACategoria(tv3, "Foto e Vídeo");
	    categoriaController.adicionarProdutoACategoria(computador3, "Computadores");
	    categoriaController.adicionarProdutoACategoria(eletrodomestico4, "Eletrodomesticos");
	    categoriaController.adicionarProdutoACategoria(smartphone4, "Smartphones");
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


}
}
