package exception;

public class PedidoInvalidoException extends RuntimeException {
    public PedidoInvalidoException() {
        super("Pedido inválido.");
    }
}

