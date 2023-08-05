package negocio.beans;

import java.util.List;

public class Administrador extends Usuario {
    public Administrador(int id, String nome, String email, String senha, Endereco endereco) {
        super(id, nome, email, senha, endereco);
    }

    public void adicionarCategoria(Categoria categoria) {
        // Implemente a lógica para adicionar uma categoria
    }

    public void editarCategoria(int id, String nome, String descricao) {
        // Implemente a lógica para editar uma categoria
    }

    public void removerCategoria(int id) {
        // Implemente a lógica para remover uma categoria
    }

    public List<Categoria> listarCategorias() {
        // Implemente a lógica para listar categorias
        return null;
    }

    public Categoria buscarCategoriaPorId(int id) {
        // Implemente a lógica para buscar categoria por ID
        return null;
    }

    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
        // Implemente a lógica para adicionar um produto a uma categoria
    }

    public void removerProdutoDeCategoria(Produto produto, Categoria categoria) {
        // Implemente a lógica para remover um produto de uma categoria
    }
}
