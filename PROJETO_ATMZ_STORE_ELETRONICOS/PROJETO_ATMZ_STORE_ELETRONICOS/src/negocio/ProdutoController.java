package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.IRepositorioProdutos;
import dados.RepositorioProdutos;
import exception.ProdutoNuloException;
import negocio.beans.Pedido;
import negocio.beans.Produto;

public class ProdutoController {
    private static ProdutoController instancia;
    private List<Produto> listProd = new ArrayList<>();
    private IRepositorioProdutos repositorioProdutos = new IRepositorioProdutos() {
		
		@Override
		public void removerProduto(Produto produto) {
			if(listProd.contains(produto)) {
				listProd.remove(produto);
			}
			
		}
		
		@Override
		public List<Produto> listarProdutos() {
			return listProd;
		}
		
		@Override
		public Produto buscarProdutoPorId(int id) {
			Produto pdAux = null;
			for(Produto pd: listProd ) {
				if(pd.getId() == id) {
					pdAux = pd;
				}
			}
			return pdAux;
		}
		
		@Override
		public void atualizarProduto(Produto produtoAtualizado) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void atualizarPrecoProduto(Produto produto, double novoPreco) {
			if(listProd.contains(produto)) {
				produto.setPreco(novoPreco);
			}
			
		}
		
		@Override
		public void adicionarProduto(Produto produto) {
			if(produto.getCategoria() != null && produto.getDescricao() != null && produto.getEstoque()>=0 && produto.getNome() != null && produto.getPreco() >0) {
				listProd.add(produto);
			}
			
		}
	};

    private ProdutoController() {
        repositorioProdutos = RepositorioProdutos.getInstancia();
    }

    public static ProdutoController getInstancia() {
        if (instancia == null) {
            instancia = new ProdutoController();
        }
        return instancia;
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new ProdutoNuloException();
        }
        repositorioProdutos.adicionarProduto(produto);
    }

    public Produto buscarProdutoPorId(int id) {
        return repositorioProdutos.buscarProdutoPorId(id);
    }

    public List<Produto> listarProdutos() {
        return repositorioProdutos.listarProdutos();
    }

    public void atualizarProduto(Produto produtoAtualizado) {
        if (produtoAtualizado == null) {
            throw new ProdutoNuloException();
        }
        repositorioProdutos.atualizarProduto(produtoAtualizado);
    }

    public void removerProduto(Produto produto) {
        if (produto == null) {
            throw new ProdutoNuloException();
        }
        repositorioProdutos.removerProduto(produto);
    }
    /* definir se o produto vai ter seu estoque dminuido quando é adicionado a um 
     * um carrinho ou apenas quando tem seu pedido gerado.
	 */
    public void diminuirEstoque (Pedido pedido) {
   
}
    
    public void aumentarEstoque (Produto produto, int quantidade) {
    	
    }
    
    public void atualizarPreco(Produto produto, double novoPreco) {
        if (produto == null) {
            throw new ProdutoNuloException();
        }
        repositorioProdutos.atualizarPrecoProduto(produto, novoPreco);
    }

    
}

