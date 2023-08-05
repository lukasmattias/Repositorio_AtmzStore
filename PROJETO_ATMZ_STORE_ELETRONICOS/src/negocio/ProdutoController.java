package negocio;

import java.util.List;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import exception.ProdutoNuloException;
import negocio.beans.Produto;

public class ProdutoController {
    private static ProdutoController instancia;
    private IRepositorioProdutos repositorioProdutos;

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
            throw new ProdutoNuloException();
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
            throw new ProdutoNuloException();
        }
        repositorioProdutos.atualizarProduto(produtoAtualizado);
    }

    public void removerProduto(Produto produto) {
        if (produto == null) {
            throw new ProdutoNuloException();
        }
        repositorioProdutos.removerProduto(produto);
    }
    
}

