package exception;

public class AdministradorNuloException extends RepositorioException {
    public AdministradorNuloException() {
        super("Administrador n�o pode ser nulo.");
    }
}
