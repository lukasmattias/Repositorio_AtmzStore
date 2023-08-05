package exception;

public class AdministradorNuloException extends RepositorioException {
    public AdministradorNuloException() {
        super("Administrador não pode ser nulo.");
    }
}
