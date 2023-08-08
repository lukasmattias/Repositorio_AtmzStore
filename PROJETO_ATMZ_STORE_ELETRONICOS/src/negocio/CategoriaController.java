package negocio;

import java.util.List;

import dados.IRepositorioCategorias;
import dados.RepositorioCategorias;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import negocio.beans.Categoria;
import negocio.beans.Produto;

public class CategoriaController {
    private static CategoriaController instancia;
    private IRepositorioCategorias repositorioCategorias = RepositorioCategorias.getInstancia();

    private CategoriaController() {
        repositorioCategorias = RepositorioCategorias.getInstancia();
    }

    public static CategoriaController getInstancia() {
        if (instancia == null) {
            instancia = new CategoriaController();
        }
        return instancia;
    }

    public void adicionarCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new ClasseNulaException();
        }
        else if (categoria.getNome() != null && categoria.getId() > 0) {
        repositorioCategorias.adicionarCategoria(categoria);
        }
        else {
        	throw new AtributosNulosException("A Categoria possui um ou mais atributos nulos.");
        }
    }

    public Categoria buscarCategoriaPorId(int id) {
        return repositorioCategorias.buscarCategoriaPorId(id);
    }

    public List<Categoria> listarCategorias() {
        return repositorioCategorias.listarCategorias();
    }

    public void atualizarCategoria(Categoria categoriaAtualizada) {
        if (categoriaAtualizada == null) {
            throw new ClasseNulaException("A categoria não pod ser nula.");
        }
        repositorioCategorias.atualizarCategoria(categoriaAtualizada);
    }

    public void removerCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new ClasseNulaException("A categoria não pod ser nula.");
        }
        repositorioCategorias.removerCategoria(categoria);
    }

    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
        
    }

    public void removerProdutoDaCategoria(Categoria categoria, Produto produto) {
        if (categoria == null || produto == null){
        	throw new ClasseNulaException("As classes não podem ser nulas.");
        }
              repositorioCategorias.removerProdutoDeUmaCategoria(categoria, produto);                           
        }

    public List<Produto> listarProdutosDaCategoria(Categoria categoria) {
        return repositorioCategorias.listarProdutosDeUmaCategoria(categoria);
    }

    public Produto procurarProdutoNaCategoria(String nomeProduto, Categoria categoria) {
        for (Produto produto : categoria.getItens()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }
    
}
