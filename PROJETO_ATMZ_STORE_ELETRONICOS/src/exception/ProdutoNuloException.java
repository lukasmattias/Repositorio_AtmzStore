package exception;

public class ProdutoNuloException extends RepositorioException {
    public ProdutoNuloException() {
        super("Produto n�o pode ser nulo.");
    }
}

