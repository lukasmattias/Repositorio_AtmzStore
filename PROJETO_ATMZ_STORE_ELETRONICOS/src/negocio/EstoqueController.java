package negocio;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import negocio.beans.Produto;

public class EstoqueController {
  private IRepositorioProdutos repositorioProdutos;

    public EstoqueController() {
        if (repositorioProdutos == null){
        this.repositorioProdutos  = RepositorioProdutos.getInstancia(); 
        }
    }

    public boolean temEstoqueSuficiente(Produto produto, int quantidadeRequerida) {
        Produto produtoExistente = repositorioProdutos.buscarProdutoPorId(produto.getId());
        return produtoExistente != null && produtoExistente.getEstoque() >= quantidadeRequerida;
    }

    public void aumentarEstoque(Produto produto, int quantidade) {
        Produto produtoExistente = repositorioProdutos.buscarProdutoPorId(produto.getId());
        
        if (produtoExistente != null) {
            int novoEstoque = produtoExistente.getEstoque() + quantidade;
            produtoExistente.setEstoque(novoEstoque);
        }

    }

    public void diminuirEstoque(Produto produto, int quantidade) {
        Produto produtoExistente = repositorioProdutos.buscarProdutoPorId(produto.getId());
        if (produtoExistente != null && produtoExistente.getEstoque() >= quantidade) {
            produtoExistente.setEstoque(produtoExistente.getEstoque() - quantidade);
        }
  }
}
