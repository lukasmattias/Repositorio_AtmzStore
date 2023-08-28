package exception;

public class ClasseNulaException extends RuntimeException {

    public ClasseNulaException() {
        super("Classe nula nao sao permitidas.");
    }

    public ClasseNulaException(String mensagem) {
        super(mensagem);
    }
}

