package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<ItemDoCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(Produto produto, int quantidade) {
    	for (ItemDoCarrinho item: itens) {
    		if (item.getProduto() == produto) {
    			item.setQuantidade(item.getQuantidade()+ quantidade);
    			return;
    		}
    	}
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
    
    public List<ItemDoCarrinho> listarItens() {
        return this.listarItens();
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemDoCarrinho item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
 
    public void limparCarrinho() {
        itens.clear();
    }
}
