package exception;

public class CategoriaNulaException extends RepositorioException {
    public CategoriaNulaException() {
        super("Categoria n�o pode ser nula.");
    }
}