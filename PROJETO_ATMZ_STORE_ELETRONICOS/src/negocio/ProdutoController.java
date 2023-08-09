package negocio;

import java.util.List;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
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
    
    public void atualizarPrecoDoProduto(Produto produto, double novoPreco) {
        if (produto == null) {
            throw new ClasseNulaException("O produto não pode ser nulo.");
        }
        repositorioProdutos.atualizarPrecoProduto(produto, novoPreco);
    }

    public boolean temEstoqueSuficiente(Produto produto, int quantidadeRequerida) {
        Produto produtoExistente = repositorioProdutos.buscarProdutoPorId(produto.getId());
        return produtoExistente != null && produtoExistente.getEstoque() >= quantidadeRequerida;
    }

    public boolean aumentarEstoque(Produto produto, int quantidade) {
        Produto produtoExistente = repositorioProdutos.buscarProdutoPorId(produto.getId());
    
        if (produtoExistente != null) {
            int novoEstoque = produtoExistente.getEstoque() + quantidade;
            produtoExistente.setEstoque(novoEstoque);
            return true;
        }

        return false;
    }

    public void diminuirEstoque(Produto produto, int quantidade) {
        if (produto == null){
            throw new OperacaoInvalidaException("O produto não pode ser nulo.");
        }
        repositorioProdutos.diminuirEstoqueProduto(produto, quantidade);
    }
}

