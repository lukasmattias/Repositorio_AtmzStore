package exception;

public class CategoriaNaoEncontradaException extends RepositorioException {
    public CategoriaNaoEncontradaException(int id) {
        super("Categoria com ID " + id + " n�o encontrada.");
    }
}






