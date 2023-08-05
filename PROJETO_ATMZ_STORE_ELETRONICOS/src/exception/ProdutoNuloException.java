package exception;

public class ProdutoNuloException extends RepositorioException {
    public ProdutoNuloException() {
        super("Produto não pode ser nulo.");
    }
}

