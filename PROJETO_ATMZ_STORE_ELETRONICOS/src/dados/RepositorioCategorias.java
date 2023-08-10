package dados;

import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Categoria;
import negocio.beans.Produto;

public class RepositorioCategorias implements IRepositorioCategorias {
    private static IRepositorioCategorias instancia;
    private List<Categoria> categorias;
		int idProxDisponivel = 1;

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
    	boolean existe = false;
    	for (Categoria c : this.categorias) {
    		if (c.getNome() == categoria.getNome()) {
    			existe = true;
    		}
    	}
		if (existe){
			return;
			} 
			// associando a categoria a um ID único e a adiconando ao ArrayList de categorias
				categoria.setId(idProxDisponivel);
				this.categorias.add(categoria);
				idProxDisponivel++;
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
		if (ctgAux != null) {
			return ctgAux;
		}
		return null;
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
        return;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#removerCategoria(negocio.beans.Categoria)
	 */
    @Override
	public void removerCategoria(Categoria categoria) {
        if (this.categorias.contains(categoria)) {
            this.categorias.remove(categoria);
        }
    }
	
    @Override
    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
			if (!categoria.getItens().contains(produto) && this.categorias.contains(categoria)){
				categoria.getItens().add(produto);
			}
            
       }

    @Override
	public void removerProdutoDeUmaCategoria(Categoria categoria, Produto produto) {
        if(this.categorias.contains(categoria) && categoria.getItens().contains(produto)){
			categoria.getItens().remove(produto);
			produto.setCategoria(null);
		}
	}
    
    @Override
    public List<Produto> listarProdutosDeUmaCategoria(Categoria categoria) {
        return categoria.getItens();
    }

    @Override
    
	public Produto procurarProdutoNaCategoriaPorNome(String nomeProduto, Categoria categoria) {
		Produto pdAux = null;
		for(Produto pd: categoria.getItens()) {
			if(pd.getNome().equalsIgnoreCase(nomeProduto)){
				pdAux = pd;
			}
		}
		return pdAux;
	}
    
    @Override
	public Produto procurarProdutoNaCategoriaPorID(int id, Categoria categoria) {
		Produto pdAux = null;
		for(Produto pd: categoria.getItens()) {
			if(pd.getId() == id) {
				pdAux = pd;
			}
		}
		return pdAux;
	}
}

