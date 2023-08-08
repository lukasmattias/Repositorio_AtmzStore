package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import negocio.beans.Pedido;
import negocio.beans.Produto;

public class ProdutoController {
    private static ProdutoController instancia;
    private IRepositorioProdutos repositorioProdutos = RepositorioProdutos.getInstancia();

    private ProdutoController() {
        repositorioProdutos = RepositorioProdutos.getInstancia();
    }

    public static ProdutoController getInstancia() {
        if (instancia == null) {
            instancia = new ProdutoController();
        }
        return instancia;
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new ClasseNulaException("O produto não pode ser nulo.");
        }
        else if(produto.getCategoria() != null && produto.getDescricao() != null 
        		&& produto.getEstoque()>=0 && produto.getNome() != null && produto.getPreco() > 0) {
        	throw new AtributosNulosException("O produto tem atributos incompletos.");
        }
        repositorioProdutos.adicionarProduto(produto);
    }

    public Produto buscarProdutoPorId(int id) {
        return repositorioProdutos.buscarProdutoPorId(id);
    }

    public List<Produto> listarProdutos() {
        return repositorioProdutos.listarProdutos();
    }

    public void atualizarProduto(Produto produtoAtualizado) {
        if (produtoAtualizado == null) {
            throw new ClasseNulaException("O produto não pode ser nulo.");
        }
        repositorioProdutos.atualizarProduto(produtoAtualizado);
    }

    public void removerProduto(Produto produto) {
        if (produto == null) {
            throw new ClasseNulaException("O produto não pode ser nulo.");
        }
        repositorioProdutos.removerProduto(produto);
    }
    /* definir se o produto vai ter seu estoque dminuido quando é adicionado a um 
     * um carrinho ou apenas quando tem seu pedido gerado.
	 */
    public void diminuirEstoque (Pedido pedido) {
   
}
    
    public void aumentarEstoque (Produto produto, int quantidade) {
    	
    }
    
    public void atualizarPreco(Produto produto, double novoPreco) {
        if (produto == null) {
            throw new ClasseNulaException("O produto não pode ser nulo.");
        }
        repositorioProdutos.atualizarPrecoProduto(produto, novoPreco);
    }

    
}

