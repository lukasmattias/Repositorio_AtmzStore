package dados;

import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Categoria;
import negocio.beans.Produto;

public class RepositorioCategorias implements IRepositorioCategorias {
    private static IRepositorioCategorias instancia;
    private ArrayList<Categoria> categorias;
		int idProxDisponivel = 1;

    private RepositorioCategorias() {
        categorias = new ArrayList<>();
		categorias.add(new Categoria(1, "Smartphones"));
		categorias.add(new Categoria(2, "Gadgets"));
		categorias.add(new Categoria(3, "Computadores"));
		categorias.add(new Categoria(4, "Eletrodomésticos"));
		categorias.add(new Categoria(5, "TVs e Entretenimento"));
    }

    public static IRepositorioCategorias getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCategorias();
        }
        return instancia;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#buscarCategoriaPorId(int)
	 */
    @Override
	public Categoria buscarCategoriaPorId(int id) {
		Categoria ctgAux = null;
		for(Categoria ctg : this.categorias) {
			if(ctg.getId() == id) {
				ctgAux = ctg;
			}
		}
			return ctgAux;
	}

	    @Override
	public Categoria buscarCategoriaPorNome(String nomeDaCategoria) {
		Categoria ctgAux = null;
		for(Categoria ctg : this.categorias) {
			if(ctg.getNome().equalsIgnoreCase(nomeDaCategoria)) {
				ctgAux = ctg;
			}
		}
			return ctgAux;
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
                break;
            }
        }
    }
	
    @Override
    public void adicionarProdutoACategoria(Produto produto, String nomeDaCategoria) throws OperacaoInvalidaException{
		Categoria categoria = buscarCategoriaPorNome(nomeDaCategoria);
		if (categoria == null){
			throw new OperacaoInvalidaException("Categoria não encontrada.");
		}
			if (!categoria.getItens().contains(produto)){
				categoria.getItens().add(produto);
				produto.setCategoria(categoria);
			}
            
       }

    @Override
	public void removerProdutoDeUmaCategoria(String nomeDaCategoria, Produto produtoARemover) throws OperacaoInvalidaException {
		Categoria categoria = buscarCategoriaPorNome(nomeDaCategoria);	
		if (categoria == null){
			throw new OperacaoInvalidaException("Categoria não encontrada.");
		}
		if (categoria.getItens().contains(produtoARemover)){
			categoria.getItens().remove(produtoARemover);
			produtoARemover.setCategoria(null);	
		}
		else
			throw new OperacaoInvalidaException("Produto não cadastrado na categoria.");
	}
    
    @Override
    public List<Produto> listarProdutosDeUmaCategoria(String nomeDaCategoria) {
	Categoria categoria = buscarCategoriaPorNome(nomeDaCategoria);
	if (categoria == null){
		throw new OperacaoInvalidaException("Categoria não encontrada.");
	}
        return categoria.getItens();
    }

    @Override
    
	public Produto procurarProdutoNaCategoriaPorNome(String nomeProduto, String nomeDaCategoria) throws OperacaoInvalidaException {
	Categoria categoria = buscarCategoriaPorNome(nomeDaCategoria);
	if (categoria == null){
		throw new OperacaoInvalidaException("Categoria não encontrada.");
	}
		Produto pdAux = null;
		for(Produto pd: categoria.getItens()) {
			if(pd.getNome().equalsIgnoreCase(nomeProduto)){
				pdAux = pd;
			}
		}
		if (pdAux == null){
			throw new OperacaoInvalidaException("Produto não encontrado.");
		}
		return pdAux;
	}
    
    @Override
	public Produto procurarProdutoNaCategoriaPorID(int id, String nomeDaCategoria) throws OperacaoInvalidaException{
	Categoria categoria = buscarCategoriaPorNome(nomeDaCategoria);
	if (categoria == null){
		throw new OperacaoInvalidaException("Categoria não encontrada.");
	}
		Produto pdAux = null;
		for(Produto pd: categoria.getItens()) {
			if(pd.getId() == id) {
				pdAux = pd;
			}
		}
		if (pdAux == null){
			throw new OperacaoInvalidaException("Produto não encontrado.");
		}
		return pdAux;
	}
}

