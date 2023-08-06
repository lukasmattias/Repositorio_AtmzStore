package dados;

import java.util.ArrayList;
import java.util.List;

import exception.CategoriaNaoEncontradaException;
import exception.CategoriaNulaException;
import negocio.beans.Categoria;
import negocio.beans.Produto;

public class RepositorioCategorias implements IRepositorioCategorias {
    private static IRepositorioCategorias instancia;
    private List<Categoria> categorias;

    private RepositorioCategorias() {
        categorias = new ArrayList<>();
    }

    public static IRepositorioCategorias getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCategorias();
        }
        return instancia;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#adicionarCategoria(negocio.beans.Categoria)
	 */
    @Override
	public void adicionarCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new CategoriaNulaException();
        }
        categorias.add(categoria);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#buscarCategoriaPorId(int)
	 */
    @Override
	public Categoria buscarCategoriaPorId(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        throw new CategoriaNaoEncontradaException(id);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#listarCategorias()
	 */
    @Override
	public List<Categoria> listarCategorias() {
        return categorias;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#atualizarCategoria(negocio.beans.Categoria)
	 */
    @Override
	public void atualizarCategoria(Categoria categoriaAtualizada) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId() == categoriaAtualizada.getId()) {
                categorias.set(i, categoriaAtualizada);
                return;
            }
        }
        throw new CategoriaNaoEncontradaException(categoriaAtualizada.getId());
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#removerCategoria(negocio.beans.Categoria)
	 */
    @Override
	public void removerCategoria(Categoria categoria) {
        if (!categorias.remove(categoria)) {
            throw new CategoriaNaoEncontradaException(categoria.getId());
        }
    }
    
    @Override
    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
        boolean existe = verificarExistenciaDeProdutoNaCategoria(produto, categoria);
        if (!existe){
            categoria.getItens().add(produto);
        }
    }

    @Override
    public void removerProdutoDeUmaCategoria(Categoria categoria, Produto produto) {
        categoria.getItens().remove(produto);
    }

    @Override
    public List<Produto> listarProdutosDeUmaCategoria(Categoria categoria) {
        return categoria.getItens();
    }

    @Override
    public Produto procurarProdutoNaCategoriaPorNome(String nomeProduto, Categoria categoria) {
        for (Produto produto : categoria.getItens()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto procurarProdutoNaCategoriaPorID(int id, Categoria categoria) {
        for (Produto produto : categoria.getItens()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public boolean verificarExistenciaDeProdutoNaCategoria (Produto produto, Categoria categoria){
        for (Produto i : categoria.getItens()){
            if (i.equals(produto)){
                return true;
            }
        }
        return false;
    }
}
