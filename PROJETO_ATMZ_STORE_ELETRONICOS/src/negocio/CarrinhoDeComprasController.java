package negocio;

import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.CarrinhoDeCompras;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.Produto;

public class CarrinhoDeComprasController {
	private static CarrinhoDeComprasController instancia;
	EstoqueController estoqueController = new EstoqueController();

	private	CarrinhoDeComprasController() {
		
	}
	
	public static CarrinhoDeComprasController getInstancia() {
		if (instancia == null) {
			instancia = new CarrinhoDeComprasController();
		}
		return instancia;
	}
	
	 public void adicionarProdutoNoCarrinho (CarrinhoDeCompras carrinho, Produto produto, int quantidade) {
		if (!estoqueController.temEstoqueSuficiente(produto, quantidade)){
			return;
		}
		// verificando se o produto já possui um ItemProduto adicionado
	    	for (ItemDoCarrinho item: carrinho.getItens()) {
	    		if (item.getProduto().equals(produto)) {
	    			item.setQuantidade(item.getQuantidade()+ quantidade);
					estoqueController.diminuirEstoque(produto, quantidade);
					return;
	    		}
	    	}
	        ItemDoCarrinho item = new ItemDoCarrinho(produto, quantidade);
	        carrinho.getItens().add(item);
			estoqueController.diminuirEstoque(produto, quantidade);
	    }

	    public void removerProdutoDoCarrinho(CarrinhoDeCompras carrinho, Produto produto, int quantidade) {
			ItemDoCarrinho item = null;
			
			for (ItemDoCarrinho i : carrinho.getItens()){
				if(i.getProduto().equals(produto)){
					item = i;
				}
			}

			if(item == null){
				return;
			}
			else if (item.getQuantidade() == quantidade){
				carrinho.getItens().remove(item);
			}
			else {
				item.setQuantidade(item.getQuantidade() - quantidade);
			}
			
			estoqueController.aumentarEstoque(produto, quantidade);

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
			if (carrinho == null || carrinho.getItens() == null){
				return;
			}
			for (ItemDoCarrinho i : carrinho.getItens()){
				estoqueController.aumentarEstoque(i.getProduto(), i.getQuantidade());
			}
	        carrinho.getItens().clear();
	    }
}
