package negocio;

import java.util.List;

import exception.FalhaPagamentoException;
import exception.OperacaoInvalidaException;
import negocio.beans.Administrador;
import negocio.beans.CarrinhoDeCompras;
import negocio.beans.CartaoDeCredito;
import negocio.beans.Categoria;
import negocio.beans.Cliente;
import negocio.beans.Endereco;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.Pedido;
import negocio.beans.Produto;


public class Fachada {
  private static Fachada instance;
  AdministradorController administradorController;
  CarrinhoDeComprasController carrinhoDeComprasController;
  CategoriaController categoriaController;
  ClienteController clienteController;
  PagamentoController pagamentoController;
  PedidoController pedidoController;
  ProdutoController produtoController;
  
  private Fachada() {
    // construtor privado para implementar padrão Singleton
  this.administradorController = AdministradorController.getInstancia();
  this.carrinhoDeComprasController = CarrinhoDeComprasController.getInstancia();
  this.categoriaController = CategoriaController.getInstancia();
  this.clienteController = ClienteController.getInstancia();
  this.pagamentoController = PagamentoController.getInstancia();
  this.pedidoController = PedidoController.getInstancia();
  this.produtoController = ProdutoController.getInstancia();
}

public static Fachada getInstance() {
    if (instance == null) {
        instance = new Fachada();
    }
    return instance;
}
    // acesso ao controlador de administrador
    public void adicionarAdministrador(Administrador administrador) {
        administradorController.adicionarAdministrador(administrador);
    }

    public Administrador buscarAdministradorPorId(int id) {
        return administradorController.buscarAdministradorPorId(id);
    }

    public List<Administrador> listarAdministradores() {
        return administradorController.listarAdministradores();
    }

    public void atualizarAdministrador(Administrador administradorAtualizado) {
        administradorController.atualizarAdministrador(administradorAtualizado);
    }

    public void removerAdministrador(Administrador administrador) {
        administradorController.removerAdministrador(administrador);
    }

    // acesso ao controlador de carrinho de compras

    public void adicionarItemAoCarrinho(CarrinhoDeCompras carrinho, Produto produto, int quantidade) {
       carrinhoDeComprasController.adicionarProdutoNoCarrinho(carrinho, produto, quantidade);
    }

    public void removerProdutoDoCarrinho(CarrinhoDeCompras carrinho, Produto produto, int quantidade) {
        carrinhoDeComprasController.removerProdutoDoCarrinho(carrinho, produto, quantidade);
    }

    public List<Produto> listarProdutosNoCarrinho(CarrinhoDeCompras carrinho) {
        return carrinhoDeComprasController.listarProdutosNoCarrinho(carrinho);
    }

    public List<ItemDoCarrinho> listarItensDoCarrinho(CarrinhoDeCompras carrinho) {
        return carrinhoDeComprasController.listarItens(carrinho);
    }

    public double calcularTotalDoCarrinho(CarrinhoDeCompras carrinho) {
        return carrinhoDeComprasController.calcularTotal(carrinho);
    }

    public void limparCarrinho(CarrinhoDeCompras carrinho) {
        carrinhoDeComprasController.limparCarrinho(carrinho);
    }

    // acesso ao controlador de categorias

    public void cadastrarCategoria(Categoria categoria) {
        categoriaController.cadastrarCategoria(categoria);
    }

    public Categoria buscarCategoriaPorId(int id) {
        return categoriaController.buscarCategoriaPorId(id);
    }

    public List<Categoria> listarCategorias() {
        return categoriaController.listarCategorias();
    }

    public void atualizarCategoria(Categoria categoriaAtualizada) {
        categoriaController.atualizarCategoria(categoriaAtualizada);
    }

    public void removerCategoria(Categoria categoria) {
        categoriaController.removerCategoria(categoria);
    }

    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
        categoriaController.adicionarProdutoACategoria(produto, categoria);
    }

    public void removerProdutoDaCategoria(Categoria categoria, Produto produto) {
        categoriaController.removerProdutoDaCategoria(categoria, produto);
    }

    public List<Produto> listarProdutosDaCategoria(Categoria categoria) {
        return categoriaController.listarProdutosDaCategoria(categoria);
    }

    public Produto procurarProdutoNaCategoria(String nomeProduto, Categoria categoria) {
        return categoriaController.procurarProdutoNaCategoria(nomeProduto, categoria);
    }

    // acesso ao controlador de cliente 

    public void cadastrarCliente(Cliente cliente, Endereco endereco) {
        clienteController.cadastrarCliente(cliente, endereco);
    }

    public Cliente buscarClientePorId(int id) {
        return clienteController.buscarClientePorId(id);
    }

    public List<Cliente> listarClientes() {
        return clienteController.listarClientes();
    }

    public void atualizarCliente(Cliente clienteAtualizado) {
        clienteController.atualizarCliente(clienteAtualizado);
    }

    public void removerCliente(Cliente cliente) {
        clienteController.removerCliente(cliente);
    }
  
    // acesso ao controlador de pagamento

    public void realizarPagamentoCartaoDeCredito(CartaoDeCredito c, Pedido pedido) throws OperacaoInvalidaException, FalhaPagamentoException {
        pagamentoController.realizarPagamentoCartaoDeCredito(c, pedido);
    }
    
    public void realizarPagamentoBoleto(Pedido pedido) throws OperacaoInvalidaException, FalhaPagamentoException {
        pagamentoController.realizarPagamentoBoleto(pedido);
    }

    // acesso ao controlador de pedido

    public void criarPedido(Cliente cliente) {
      pedidoController.criarPedido(cliente);
  }

  public double calcularTotalDoPedido(Pedido pedido) {
      return pedidoController.calcularTotalDoPedido(pedido);
  }

  public List<Pedido> listarPedidosPorCliente(Cliente cliente) {
      return pedidoController.listarPedidosPorCliente(cliente);
  }

  public List<Pedido> listarPedidos() {
      return pedidoController.listarPedidos();
  }

  public void cancelarPedido(Pedido pedido) {
      pedidoController.cancelarPedido(pedido);
  }

  // acesso ao controlador de produtos

  public void cadastrarProduto(Produto produto) {
    produtoController.cadastrarProduto(produto);
}

public Produto buscarProdutoPorId(int id) {
    return produtoController.buscarProdutoPorId(id);
}

public List<Produto> listarProdutos() {
    return produtoController.listarProdutos();
}

public void atualizarProduto(Produto produtoAtualizado) {
    produtoController.atualizarProduto(produtoAtualizado);
}

public void removerProduto(Produto produto) {
    produtoController.removerProduto(produto);
}

public void atualizarPrecoDoProduto(Produto produto, double novoPreco) {
    produtoController.atualizarPrecoDoProduto(produto, novoPreco);
}

public boolean temEstoqueSuficiente(Produto produto, int quantidadeRequerida) {
    return produtoController.temEstoqueSuficiente(produto, quantidadeRequerida);
}

public boolean aumentarEstoque(Produto produto, int quantidade) {
    return produtoController.aumentarEstoque(produto, quantidade);
}

public void diminuirEstoque(Produto produto, int quantidade) {
    produtoController.diminuirEstoque(produto, quantidade);
}

  }
