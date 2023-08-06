package exception;

public class ClienteNuloException extends RepositorioException {
    public ClienteNuloException() {
        super("Cliente nao pode ser nulo.");
    }

    public ClienteNuloException(String message) {
        super(message);
    }
}
