package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Produto;

public class RepositorioProdutos implements IRepositorioProdutos {
    private static IRepositorioProdutos instancia;
    private List<Produto> produtos;

    private RepositorioProdutos() {
        produtos = new ArrayList<>();
    }

    public static IRepositorioProdutos getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioProdutos();
        }
        return instancia;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioProdutos#adicionarProduto(negocio.beans.Produto)
	 */
    @Override
	public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioProdutos#buscarProdutoPorId(int)
	 */
    @Override
	public Produto buscarProdutoPorId(int id) {
        return produtos.stream()
            .filter(produto -> produto.getId() == id)
            .findFirst()
            .orElse(null);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioProdutos#listarProdutos()
	 */
    @Override
	public List<Produto> listarProdutos() {
        return produtos;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioProdutos#atualizarProduto(negocio.beans.Produto)
	 */
    @Override
	public void atualizarProduto(Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produtoAtualizado.getId()) {
                produtos.set(i, produtoAtualizado);
                break;
            }
        }
    }

    @Override
	public void atualizarPrecoProduto(Produto produto, double novoPreco) {
        produto.setPreco(novoPreco);
    }
    
    /* (non-Javadoc)
	 * @see dados.IRepositorioProdutos#removerProduto(negocio.beans.Produto)
	 */
    @Override
	public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }
}
