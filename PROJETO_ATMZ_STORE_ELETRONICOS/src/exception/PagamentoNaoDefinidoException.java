package exception;

public class PagamentoNaoDefinidoException extends RuntimeException {
    public PagamentoNaoDefinidoException() {
        super("Pagamento n�o est� definido para este pedido.");
    }
}

