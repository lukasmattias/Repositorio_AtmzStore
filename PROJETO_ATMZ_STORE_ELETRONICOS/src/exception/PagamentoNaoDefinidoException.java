package exception;

public class PagamentoNaoDefinidoException extends RuntimeException {
    public PagamentoNaoDefinidoException() {
        super("Pagamento não está definido para este pedido.");
    }
}

