package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import negocio.beans.CarrinhoDeCompras;
import negocio.beans.Item;
import negocio.beans.Produto;

public class CarrinhoDeComprasController {
	private static CarrinhoDeComprasController instancia;
	IRepositorioProdutos repositorioProdutos = RepositorioProdutos.getInstancia();

	private	CarrinhoDeComprasController() {
		
	}
	
	public static CarrinhoDeComprasController getInstancia() {
		if (instancia == null) {
			instancia = new CarrinhoDeComprasController();
		}
		return instancia;
	}
	
	 public void adicionarProdutoNoCarrinho (CarrinhoDeCompras carrinho, Produto produto, int quantidade) throws OperacaoInvalidaException{
		if (quantidade <= 0 || !repositorioProdutos.temEstoqueSuficiente(produto, quantidade)){
			throw new OperacaoInvalidaException("Estoque insuficiente.");
		}
		// verificando se o produto já possui um ItemProduto adicionado
	    	for (Item item: carrinho.getItens()) {
	    		if (item.getProduto().equals(produto)) {
	    			item.setQuantidade(item.getQuantidade()+ quantidade);
					repositorioProdutos.diminuirEstoque(produto, quantidade);
					return;
	    		}
	    	}
	        Item item = new Item(produto, quantidade);
	        carrinho.getItens().add(item);
			repositorioProdutos.diminuirEstoque(produto, quantidade);
	    }

	    public void removerProdutoDoCarrinho(CarrinhoDeCompras carrinho, Produto produto, int quantidade) throws OperacaoInvalidaException{
			Item item = null;
			
			for (Item i : carrinho.getItens()){
				if(i.getProduto().equals(produto)){
					item = i;
				}
			}

			if(item == null){
				throw new OperacaoInvalidaException("O produto não foi encontrado no carrinho.");
			}
			else if (item.getQuantidade() == quantidade){
				carrinho.getItens().remove(item);
			}
			else {
				item.setQuantidade(item.getQuantidade() - quantidade);
			}
			
			repositorioProdutos.aumentarEstoque(produto, quantidade);

	    }
	
	    public List<Produto> listarProdutosNoCarrinho(CarrinhoDeCompras carrinho) {
			if (carrinho == null || carrinho.getItens() == null){
				throw new ClasseNulaException("O carrinho não pode ser nulo ou vazio.");
			}
	        List<Produto> produtosNoCarrinho = new ArrayList<>();
	        for (Item item : carrinho.getItens()) {
	            produtosNoCarrinho.add(item.getProduto());
	        }
	        return produtosNoCarrinho;
	    }

	    public List<Item> listarItens(CarrinhoDeCompras carrinho) throws ClasseNulaException{
			if (carrinho == null || carrinho.getItens() == null){
				throw new ClasseNulaException("O carrinho não pode ser nulo ou vazio.");
			}
	        return carrinho.getItens();
	    }

	    public double calcularTotal(CarrinhoDeCompras carrinho) throws ClasseNulaException{
			if (carrinho == null || carrinho.getItens() == null){
				throw new ClasseNulaException("O carrinho não pode ser nulo ou vazio.");
			}
	        double total = 0;
	        for (Item item : carrinho.getItens()) {
	            total += item.getSubtotal();
	        }
	        return total;
	    }
	 
	    public void limparCarrinho(CarrinhoDeCompras carrinho) throws ClasseNulaException{
			if (carrinho == null || carrinho.getItens() == null){
				throw new ClasseNulaException("O carrinho não pode ser nulo ou vazio.");
			}
			for (Item i : carrinho.getItens()){
				repositorioProdutos.aumentarEstoque(i.getProduto(), i.getQuantidade());
			}
	        carrinho.getItens().clear();
	    }
}
