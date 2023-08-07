package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.IRepositorioCategorias;
import dados.RepositorioCategorias;
import exception.CategoriaNulaException;
import negocio.beans.Categoria;
import negocio.beans.Produto;

public class CategoriaController {
    private static CategoriaController instancia;
    private List<Categoria> listcatg = new ArrayList<>();
    private IRepositorioCategorias repositorioCategorias = new IRepositorioCategorias() {

		@Override
		public boolean verificarExistenciaDeProdutoNaCategoria(Produto produto, Categoria categoria) {
			boolean verificar = false;
			if(categoria.getItens().contains(produto)) {
				verificar = true;
			}
			return verificar;
		}
		
		@Override
		public void removerProdutoDeUmaCategoria(Categoria categoria, Produto produto) {
			if(categoria.getItens().contains(produto)){
				categoria.getItens().remove(produto);
			}
			
		}
		
		@Override
		public void removerCategoria(Categoria categoria) {
			if(listcatg.contains(categoria)) {
				listcatg.remove(categoria);
			}
			
		}
		
		@Override
		public Produto procurarProdutoNaCategoriaPorNome(String nomeProduto, Categoria categoria) {
			Produto pdAux = null;
			for(Produto pd: categoria.getItens()) {
				if(pd.getNome() == nomeProduto) {
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
		
		@Override
		public List<Produto> listarProdutosDeUmaCategoria(Categoria categoria) {
			return categoria.getItens();
		}
		
		@Override
		public List<Categoria> listarCategorias() {
			return listcatg;
		}
		
		@Override
		public Categoria buscarCategoriaPorId(int id) {
			Categoria ctgAux = null;
			for(Categoria ctg : listcatg ) {
				if(ctg.getId() == id) {
					ctgAux = ctg;
				}
			}
			return ctgAux;
		}
		
		@Override
		public void atualizarCategoria(Categoria categoriaAtualizada) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
			if(produto.getCategoria().equals(categoria) ) {
				categoria.getItens().add(produto);
			}
			
		}
		
		@Override
		public void adicionarCategoria(Categoria categoria) {
			if(categoria.getNome() != null && categoria.getDescricao() != null && categoria.getId() > 0) {
				listcatg.add(categoria);
			}
		}
	};

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

    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) {
        
    }

    public void removerProdutoDaCategoria(Categoria categoria, Produto produto) {
        if (categoria != null && produto != null){
                if (repositorioCategorias.verificarExistenciaDeProdutoNaCategoria(produto, categoria)){
                repositorioCategorias.removerProdutoDeUmaCategoria(categoria, produto);                       
                }
        }
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
