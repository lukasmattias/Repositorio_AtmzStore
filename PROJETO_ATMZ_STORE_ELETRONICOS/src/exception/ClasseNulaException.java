package exception;

public class ClasseNulaException extends RuntimeException {

    public ClasseNulaException() {
        super("Classe nula não é permitida.");
    }

    public ClasseNulaException(String mensagem) {
        super(mensagem);
    }
}

