package exception;

public class EnderecoInvalidoException extends RuntimeException {
	
    public EnderecoInvalidoException() {
        super("O endereço é inválido.");
    }

    public EnderecoInvalidoException(String message) {
        super(message);
    }
}
