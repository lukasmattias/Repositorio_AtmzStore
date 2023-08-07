package exception;

public class CategoriaNulaException extends RepositorioException {
    public CategoriaNulaException() {
        super("Categoria não pode ser nula.");
    }
}