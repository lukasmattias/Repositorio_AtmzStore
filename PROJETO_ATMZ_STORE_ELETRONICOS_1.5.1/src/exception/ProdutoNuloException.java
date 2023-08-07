package exception;

public class ProdutoNuloException extends RepositorioException {
    public ProdutoNuloException() {
        super("Produto nao pode ser nulo.");
    }
}

