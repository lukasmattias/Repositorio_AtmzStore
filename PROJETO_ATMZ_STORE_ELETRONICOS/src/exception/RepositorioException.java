package exception;

public class RepositorioException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RepositorioException(String mensagem) {
        super(mensagem);
    }
}

