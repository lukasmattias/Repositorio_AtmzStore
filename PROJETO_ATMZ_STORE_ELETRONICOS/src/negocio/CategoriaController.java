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

    public void cadastrarCategoria(Categoria categoria) throws AtributosNulosException{
        if (categoria == null) {
            throw new ClasseNulaException("A categoria é nula.");
        }
        else if (categoria.getNome() == null || categoria.getNome().isEmpty()){
            throw new AtributosNulosException ("A categoria possui dados inválidos.");
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
            throw new ClasseNulaException("A categoria não pod ser nula.");
        }
        repositorioCategorias.atualizarCategoria(categoriaAtualizada);
    }

    public void removerCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new ClasseNulaException("A categoria não pode ser nula.");
        }
        repositorioCategorias.removerCategoria(categoria);
    }

    public void adicionarProdutoACategoria(Produto produto, Categoria categoria) throws ClasseNulaException, AtributosNulosException{
        if (produto == null || categoria == null){
            throw new ClasseNulaException("Produto ou categoria não pode ser nulo.");
        }
        else  if (produto.getNome() == null || produto.getNome().isEmpty() ||
        produto.getDescricao() == null || produto.getDescricao().isEmpty() ) {
        throw new AtributosNulosException("Dados nulos não são permitidos.");
        }
        else if (produto.getCategoria() != null){
            throw new OperacaoInvalidaException("O produto já está cadastrado em uma categoria.");
        }
        else if (produto.getId() == 0){
            throw new OperacaoInvalidaException("O produto ainda não foi cadastrado no sistema.");
    }
        repositorioCategorias.adicionarProdutoACategoria(produto, categoria);
    }

    public void removerProdutoDaCategoria(Categoria categoria, Produto produto) {
        if (categoria == null || produto == null){
        	throw new ClasseNulaException("As classes não podem ser nulas.");
        }
              repositorioCategorias.removerProdutoDeUmaCategoria(categoria, produto);                           
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
