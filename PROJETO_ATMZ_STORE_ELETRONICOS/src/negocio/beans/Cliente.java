package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Pedido> pedidos;
    private CarrinhoDeCompras carrinho;

    public Cliente(int id, String nome, String email, String senha, Endereco endereco) {
        super(id, nome, email, senha, endereco);
        this.pedidos = new ArrayList<>();
        this.carrinho = new CarrinhoDeCompras();
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public void adicionarNoCarrinho(Produto produto, int quantidade) {
        carrinho.adicionarItem(produto, quantidade);
    }

    public void removerDoCarrinho(Produto produto) {
        carrinho.removerItem(produto);
    }

    public void esvaziarCarrinho() {
        carrinho.limparCarrinho();
    }

    public Pedido comprarProdutos() {
        Pedido novoPedido = carrinho.finalizarCompra(this);
        pedidos.add(novoPedido);
        return novoPedido;
    }

    public List<Produto> visualizarCarrinho() {
        return carrinho.listarProdutos();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}

