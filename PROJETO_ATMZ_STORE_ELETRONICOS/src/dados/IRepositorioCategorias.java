package dados;

import java.util.List;

import negocio.beans.Categoria;

public interface IRepositorioCategorias {

	void adicionarCategoria(Categoria categoria);

	Categoria buscarCategoriaPorId(int id);

	List<Categoria> listarCategorias();

	void atualizarCategoria(Categoria categoriaAtualizada);

	void removerCategoria(Categoria categoria);

}