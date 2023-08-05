package negocio;

import java.util.List;

import dados.IRepositorioCategorias;
import dados.RepositorioCategorias;
import exception.CategoriaNulaException;
import negocio.beans.Categoria;

public class CategoriaController {
    private static CategoriaController instancia;
    private IRepositorioCategorias repositorioCategorias;

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
            throw new CategoriaNulaException();
        }
        repositorioCategorias.adicionarCategoria(categoria);
    }

    public Categoria buscarCategoriaPorId(int id) {
        return repositorioCategorias.buscarCategoriaPorId(id);
    }

    public List<Categoria> listarCategorias() {
        return repositorioCategorias.listarCategorias();
    }

    public void atualizarCategoria(Categoria categoriaAtualizada) {
        if (categoriaAtualizada == null) {
            throw new CategoriaNulaException();
        }
        repositorioCategorias.atualizarCategoria(categoriaAtualizada);
    }

    public void removerCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new CategoriaNulaException();
        }
        repositorioCategorias.removerCategoria(categoria);
    }
    
}
