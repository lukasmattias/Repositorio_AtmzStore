package negocio;

import dados.IRepositorioPedidos;
import dados.RepositorioPedidos;
import exception.FalhaPagamentoException;
import exception.OperacaoInvalidaException;
import negocio.beans.Boleto;
import negocio.beans.CartaoDeCredito;
import negocio.beans.Pedido;
import negocio.beans.Status;

public class PagamentoController {
    private static PagamentoController instancia;
    IRepositorioPedidos repositorioPedidos = RepositorioPedidos.getInstancia();

    private PagamentoController() {

    }

    public static PagamentoController getInstancia() {
        if (instancia == null) {
            instancia = new PagamentoController();
        }
        return instancia;
    }

    public void realizarPagamentoCartaoDeCredito(CartaoDeCredito c, Pedido pedido) 
    throws FalhaPagamentoException, OperacaoInvalidaException {
        boolean pagamentoRealizado = false;
        /* verificação dos atributos essenciais do cartão. 
        A tentativa de pagamento apenas é efetuada com todos os atributos válidos.
        */
        if (c.getCVV().length() == 3 &&  c.getDataValidade() != null && c.getNomeTitular() != null
        && !c.getNomeTitular().isEmpty() && c.getNumeroCartao().length() == 16
        && c.getStatus().equals(Status.PENDENTE) && c.getValorASerPago() > 0){
        pagamentoRealizado = processarPagamento();  
        }
        else {
          throw new OperacaoInvalidaException("Os dados do cartão estão incompletos.");  
        }

        if (pagamentoRealizado){
            pedido.setStatusDePagamento(Status.PAGO);   
        }
        else {
            throw new FalhaPagamentoException("Falha no pagamento do pedido de");
        }
         
    }
    
    public void realizarPagamentoBoleto(Pedido pedido) throws FalhaPagamentoException, OperacaoInvalidaException {
        if (pedido == null){
            throw new OperacaoInvalidaException("O pedido não pode ser nulo.");
        }
        gerarBoleto(pedido);
        boolean pagamentoRealizado = processarPagamento();
        if (pagamentoRealizado){
         atualizarStatusDePagamento(pedido, Status.PAGO);   
        }
    }

    private void atualizarStatusDePagamento(Pedido pedido, Status novoStatus) {
        pedido.setStatusDePagamento(novoStatus);
    }

    private int gerarCodigoDeBarras() {
        boolean existe = false;
        int codigoDeBarras;
        do{
        codigoDeBarras = (int) (Math.random() * 1000000000);
         for (Pedido pedido : repositorioPedidos.listarPedidos()){
            if (pedido.getPagamento() instanceof Boleto){
                Boleto b = (Boleto) pedido.getPagamento();
                if (b.getCodigoBarras() == codigoDeBarras){
                    existe = true;
                    break;
                }
                }
            }
        } while (existe);
         return codigoDeBarras;
    } 
    
    private void gerarBoleto(Pedido pedido) {
        int codigoDeBarras = gerarCodigoDeBarras();
        Boleto boleto = new Boleto(pedido, codigoDeBarras);
        pedido.setPagamento(boleto);
    }

    private boolean processarPagamento() {
        boolean sucesso = false;
        /* 
         Simula o sucesso e a falha do pagamento tendo 50% de probabilidade cada.
         1 significa sucesso do pagamento e 0 significa falha. */
        int resultado = (int) (Math.random() * 2);
        
        if (resultado == 1){
            sucesso = true;
        }
        return sucesso;
    }
}

