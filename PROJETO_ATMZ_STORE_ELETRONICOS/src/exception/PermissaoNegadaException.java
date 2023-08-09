package exception;

public class PermissaoNegadaException extends RuntimeException {

    public PermissaoNegadaException() {
        super("Permissão negada.");
    }

    public PermissaoNegadaException(String message) {
        super(message);
    }

}
