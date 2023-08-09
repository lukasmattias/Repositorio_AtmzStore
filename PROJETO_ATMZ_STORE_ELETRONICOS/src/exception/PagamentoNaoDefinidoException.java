package exception;

public class PagamentoNaoDefinidoException extends RuntimeException {
    public PagamentoNaoDefinidoException() {
        super("Pagamento nao esta definido para este pedido.");
    }
}

