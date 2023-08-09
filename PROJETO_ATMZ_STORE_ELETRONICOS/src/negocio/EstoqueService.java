package negocio;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import negocio.beans.Produto;

public class EstoqueService {
    private IRepositorioProdutos repositorioProdutos;

    public EstoqueService() {
        if (repositorioProdutos == null){
        this.repositorioProdutos  = RepositorioProdutos.getInstancia(); 
        }
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

    public boolean diminuirEstoque(Produto produto, int quantidade) {
        Produto produtoExistente = repositorioProdutos.buscarProdutoPorId(produto.getId());

        if (produtoExistente != null && produtoExistente.getEstoque() >= quantidade) {
            int novoEstoque = produtoExistente.getEstoque() - quantidade;
            produtoExistente.setEstoque(novoEstoque);
            return true;
        }

        return false;
    }
}
