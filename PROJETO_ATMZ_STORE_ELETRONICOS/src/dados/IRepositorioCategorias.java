package dados;

import java.util.List;

import negocio.beans.Categoria;
import negocio.beans.Produto;

public interface IRepositorioCategorias {

    void adicionarCategoria(Categoria categoria);

    Categoria buscarCategoriaPorId(int id);

    List<Categoria> listarCategorias();

    void atualizarCategoria(Categoria categoriaAtualizada);

    void removerCategoria(Categoria categoria);

    void adicionarProdutoACategoria(Produto produto, Categoria categoria);

    void removerProdutoDeUmaCategoria(Categoria categoria, Produto produto);

    List<Produto> listarProdutosDeUmaCategoria(Categoria categoria) ;

    Produto procurarProdutoNaCategoriaPorNome(String nomeProduto, Categoria categoria);
    
    Produto procurarProdutoNaCategoriaPorID(int id, Categoria categoria);
}