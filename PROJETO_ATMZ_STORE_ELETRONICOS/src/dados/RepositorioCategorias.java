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
    		if (c.getNome() == categoria.getNome() ||c.getId() == categoria.getId()) {
    			existe = true;
    		}
    	}
			if (existe){
				throw new OperacaoInvalidaException("Nome ou ID da categoria já foi cadastrado.");
			} 
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
		else {
			throw new OperacaoInvalidaException("A categoria não foi encontrada.");
		}
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
        throw new OperacaoInvalidaException("A atualização da categoria falhou.");
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#removerCategoria(negocio.beans.Categoria)
	 */
    @Override
	public void removerCategoria(Categoria categoria) {
        if (this.categorias.contains(categoria)) {
            this.categorias.remove(categoria);
        }
        else {
        throw new OperacaoInvalidaException("A categoria não foi cadastrada no sistema.");
        }
    }
	
    @Override
    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
		boolean verificar = false;
		if(categoria.getItens().contains(produto)) {
			verificar = true;
		}
        if (verificar == false){
            categoria.getItens().add(produto);
        }
    }

    @Override
	public void removerProdutoDeUmaCategoria(Categoria categoria, Produto produto) {
        if(this.categorias.contains(categoria) && categoria.getItens().contains(produto)){
			categoria.getItens().remove(produto);
		}
        else {
        	throw new OperacaoInvalidaException("Produto ou categoria não cadastrada no sistema.");
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

