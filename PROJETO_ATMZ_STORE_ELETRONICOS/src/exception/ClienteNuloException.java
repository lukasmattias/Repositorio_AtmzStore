package exception;

public class ClienteNuloException extends RepositorioException {
    public ClienteNuloException() {
        super("Cliente n�o pode ser nulo.");
    }
}
