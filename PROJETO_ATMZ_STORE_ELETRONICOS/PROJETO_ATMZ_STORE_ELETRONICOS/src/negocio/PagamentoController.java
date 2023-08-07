package negocio;

//import dados.IRepositorioCategorias;
//import dados.RepositorioCategorias;
//import negocio.beans.CartaoDeCredito;
//import negocio.beans.Pagamento;
import negocio.beans.Pedido;
import negocio.beans.Status;

public class PagamentoController {
	ServicoAtualizacaoStatus servicoAtualizacao;
    private static PagamentoController instancia;

    private PagamentoController() {

    }

    public static PagamentoController getInstancia() {
        if (instancia == null) {
            instancia = new PagamentoController();
        }
        return instancia;
    }
	// falta a lógica do cadastro do pagamento. talvez n seja aqui
    public void realizarPagamentoCartaoDeCredito(Pedido pedido) {
    	
    }
    
    public void realizarPagamentoBoleto(Pedido pedido) {
    	
    }

    public void atualizarStatus(Pedido pedido, Status novoStatus) {
    	servicoAtualizacao.atualizarStatus(pedido, novoStatus);
    }
}
