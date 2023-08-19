package dados;

import java.util.List;

import negocio.beans.Categoria;
import negocio.beans.Produto;

public interface IRepositorioCategorias {

    Categoria buscarCategoriaPorId(int id);

    List<Categoria> listarCategorias();

    void atualizarCategoria(Categoria categoriaAtualizada);

    void adicionarProdutoACategoria(Produto produto, String nomeDaCategoria);

    void removerProdutoDeUmaCategoria(String categoria, Produto produto);

    List<Produto> listarProdutosDeUmaCategoria(String nomeDaCategoria);

    Produto procurarProdutoNaCategoriaPorNome(String nomeProduto, String nomeDaCategoria);
    
    Produto procurarProdutoNaCategoriaPorID(int idDoProduto, String nomeDaCategoria);

    Categoria buscarCategoriaPorNome(String nomeDaCategoria);
}