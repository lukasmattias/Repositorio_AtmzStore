package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Categoria;
import negocio.beans.Produto;

public class RepositorioCategorias implements IRepositorioCategorias, Serializable  {
   
	private static final long serialVersionUID = 7374649121269570571L;
	private static IRepositorioCategorias instancia;
    private List<Categoria> categorias;
    int idProxDisponivel = 1;

    private RepositorioCategorias() {
    	categorias = new ArrayList<>();
 		categorias.addAll(inicializarCategorias());
    }

    public static IRepositorioCategorias getInstancia() {
    	if (instancia == null) {
            instancia = lerDoArquivo();
        }
        return instancia;
    }
    
    private static RepositorioCategorias lerDoArquivo() {
    	RepositorioCategorias instanciaLocal = null;

        File in = new File("categorias.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
          fis = new FileInputStream(in);
          ois = new ObjectInputStream(fis);
          Object o = ois.readObject();
          instanciaLocal = (RepositorioCategorias) o;
        } catch (Exception e) {
          instanciaLocal = new RepositorioCategorias();
        } finally {
          if (ois != null) {
            try {
              ois.close();
            } catch (IOException e) {
            }
          }
        }

        return instanciaLocal;
      }

    	@Override
      public void salvarArquivo() {
        if (instancia == null) {
          return;
        }
        File out = new File("categorias.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
          fos = new FileOutputStream(out);
          oos = new ObjectOutputStream(fos);
          oos.writeObject(instancia);
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if (oos != null) {
            try {
              oos.close();
            } catch (IOException e) {
              /* Silent */}
          }
        }
      }

    /* (non-Javadoc)
	 * @see dados.IRepositorioCategorias#buscarCategoriaPorId(int)
	 */
        	
     private List<Categoria> inicializarCategorias() {
    	List<Categoria> categoriasI = new ArrayList<>();
 		categorias.add(new Categoria(1, "Smartphones"));
 		categorias.add(new Categoria(2, "Gadgets"));
 		categorias.add(new Categoria(3, "Computadores"));
 		categorias.add(new Categoria(4, "Eletrodomesticos"));
 		categorias.add(new Categoria(5, "TVs e Entretenimento"));
		return categoriasI;
     }
     
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
                this.salvarArquivo();
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
				this.salvarArquivo();
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
			this.salvarArquivo();
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

