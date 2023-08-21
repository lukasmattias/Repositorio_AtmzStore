package dados;

import java.util.List;

import negocio.beans.Produto;

public interface IRepositorioProdutos {

	void adicionarProduto(Produto produto);

	Produto buscarProdutoPorId(int id);

	List<Produto> listarProdutos();

	void atualizarProduto(Produto produtoAtualizado);

	void removerProduto(Produto produto);

	void atualizarPrecoProduto(Produto produto, double novoPreco);
	
	boolean temEstoqueSuficiente(Produto produto, int quantidadeRequerida);

	void aumentarEstoque(Produto produto, int quantidade);

	void diminuirEstoque(Produto produto, int quantidade);

	void salvarArquivo();

}