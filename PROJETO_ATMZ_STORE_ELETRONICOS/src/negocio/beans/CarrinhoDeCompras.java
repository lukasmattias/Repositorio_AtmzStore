package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<ItemDoCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemDoCarrinho item = new ItemDoCarrinho(produto, quantidade);
        itens.add(item);
    }

    public void removerItem(Produto produto) {
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtosNoCarrinho = new ArrayList<>();
        for (ItemDoCarrinho item : itens) {
            produtosNoCarrinho.add(item.getProduto());
        }
        return produtosNoCarrinho;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemDoCarrinho item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public Pedido finalizarCompra(Cliente cliente) {
        List<ItemPedido> itensPedido = new ArrayList<>();
        for (ItemDoCarrinho item : itens) {
            itensPedido.add(new ItemPedido(item.getProduto(), item.getQuantidade()));
        }
        Pedido novoPedido = new Pedido(cliente, itensPedido);
        cliente.adicionarPedido(novoPedido);
        itens.clear();
        return novoPedido;
    }

    public void limparCarrinho() {
        itens.clear();
    }
}
