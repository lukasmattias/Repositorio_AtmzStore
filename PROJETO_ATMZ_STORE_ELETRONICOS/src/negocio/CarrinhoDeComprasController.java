package negocio;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.CarrinhoDeCompras;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.Produto;

public class CarrinhoDeComprasController {
	private static CarrinhoDeComprasController instancia;
	
	private	CarrinhoDeComprasController() {
		
	}
	
	public static CarrinhoDeComprasController getInstancia() {
		if (instancia == null) {
			instancia = new CarrinhoDeComprasController();
		}
		return instancia;
	}
	
	 public void adicionarItem(CarrinhoDeCompras carrinho, Produto produto, int quantidade) {
	    	for (ItemDoCarrinho item: carrinho.getItens()) {
	    		if (item.getProduto() == produto) {
	    			item.setQuantidade(item.getQuantidade()+ quantidade);
	    			return;
	    		}
	    	}
	        ItemDoCarrinho item = new ItemDoCarrinho(produto, quantidade);
	        carrinho.getItens().add(item);
	    }

	    public void removerItem(CarrinhoDeCompras carrinho, Produto produto) {
	        carrinho.getItens().removeIf(item -> item.getProduto().equals(produto));
	    }

	    public List<Produto> listarProdutosNoCarrinho(CarrinhoDeCompras carrinho) {
	        List<Produto> produtosNoCarrinho = new ArrayList<>();
	        for (ItemDoCarrinho item : carrinho.getItens()) {
	            produtosNoCarrinho.add(item.getProduto());
	        }
	        return produtosNoCarrinho;
	    }
	    
	    public List<ItemDoCarrinho> listarItens(CarrinhoDeCompras carrinho) {
	        return carrinho.getItens();
	    }

	    public double calcularTotal(CarrinhoDeCompras carrinho) {
	        double total = 0;
	        for (ItemDoCarrinho item : carrinho.getItens()) {
	            total += item.getSubtotal();
	        }
	        return total;
	    }
	 
	    public void limparCarrinho(CarrinhoDeCompras carrinho) {
	        carrinho.getItens().clear();
	    }
}
