package negocio;

import java.util.List;

import dados.IRepositorioCategorias;
import dados.RepositorioCategorias;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import negocio.beans.Categoria;
import negocio.beans.Produto;

public class CategoriaController {
    private static CategoriaController instancia;
    private IRepositorioCategorias repositorioCategorias = RepositorioCategorias.getInstancia();

    private CategoriaController() {
        repositorioCategorias = RepositorioCategorias.getInstancia();
    }

    public static CategoriaController getInstancia() {
        if (instancia == null) {
            instancia = new CategoriaController();
        }
        return instancia;
    }

    public Categoria buscarCategoriaPorId(int id) {
        return repositorioCategorias.buscarCategoriaPorId(id);
    }

    public List<Categoria> listarCategorias() {
        return repositorioCategorias.listarCategorias();
    }

    public void atualizarCategoria(Categoria categoriaAtualizada) throws ClasseNulaException{
        if (categoriaAtualizada == null) {
            throw new ClasseNulaException("A categoria não pode ser nula.");
        }
        
        repositorioCategorias.atualizarCategoria(categoriaAtualizada);
    }

    public void adicionarProdutoACategoria(Produto produto, String categoria) throws ClasseNulaException{
        if (produto == null || categoria == null || categoria.isEmpty() || produto.getNome() == null || produto.getNome().isEmpty() ||
        produto.getDescricao() == null || produto.getDescricao().isEmpty() || produto.getCategoria() != null||produto.getId() == 0){
            throw new ClasseNulaException ("O produto tem dados incompletos ou já foi cadastrado em uma categoria.");
        }
        try{
		repositorioCategorias.adicionarProdutoACategoria(produto, categoria);
		}
		catch (OperacaoInvalidaException e){
			e.getStackTrace();
		}
        catch(ClasseNulaException a){
            a.getMessage();
        }
    }

    public void removerProdutoDaCategoria(String categoria, Produto produto)throws ClasseNulaException{
        if (categoria == null || produto == null){
        	throw new ClasseNulaException("Produto ou categoria não pode ser nula.");
        }
              repositorioCategorias.removerProdutoDeUmaCategoria(categoria, produto);
        }

    public List<Produto> listarProdutosDaCategoria(String nomeDaCategoria) throws OperacaoInvalidaException{
        if (nomeDaCategoria.equals(null) || nomeDaCategoria.isEmpty()){
            throw new OperacaoInvalidaException("Os dados não podem ser nulos ou vazios.");
        }
        return repositorioCategorias.listarProdutosDeUmaCategoria(nomeDaCategoria);
    }

    public Produto procurarProdutoNaCategoriaPorNome(String nomeProduto, String nomeDaCategoria) throws OperacaoInvalidaException{
        if (nomeDaCategoria == null || nomeDaCategoria.isEmpty() || nomeProduto.equals(null) || nomeProduto.isEmpty()){
             throw new OperacaoInvalidaException("Os dados não podem ser nulos ou vazios.");
        }
        return repositorioCategorias.procurarProdutoNaCategoriaPorNome(nomeProduto, nomeDaCategoria);
    }

    public Produto procurarProdutoNaCategoriaPorID(int iDDoProduto, String nomeDaCategoria) throws OperacaoInvalidaException{
        if (nomeDaCategoria == null || nomeDaCategoria.isEmpty()){
             throw new OperacaoInvalidaException("Os dados não podem ser nulos ou vazios.");
        }
        return repositorioCategorias.procurarProdutoNaCategoriaPorID(iDDoProduto, nomeDaCategoria);
    }
}
