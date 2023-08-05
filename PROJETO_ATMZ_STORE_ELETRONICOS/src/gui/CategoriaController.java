package gui;

import java.util.List;

import dados.RepositorioCategorias;
import exception.CategoriaNulaException;
import negocio.beans.Categoria;


public class CategoriaController {
    private RepositorioCategorias repositorioCategorias;

    public CategoriaController() {
        repositorioCategorias = RepositorioCategorias.getInstancia();
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
    
    // Outros métodos específicos do CategoriaController
    // ...
}
