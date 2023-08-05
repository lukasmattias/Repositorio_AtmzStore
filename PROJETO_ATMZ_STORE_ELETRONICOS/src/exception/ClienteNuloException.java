package exception;

public class ClienteNuloException extends RepositorioException {
    public ClienteNuloException() {
        super("Cliente não pode ser nulo.");
    }
}
