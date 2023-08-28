package negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import dados.IRepositorioPedidos;
import dados.RepositorioPedidos;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.FalhaPagamentoException;
import exception.OperacaoInvalidaException;
import negocio.beans.CartaoDeCredito;
import negocio.beans.Pagamento;
import negocio.beans.PagamentoPix;
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
    
    public void realizarPagamento(Pedido pedido, Pagamento pagamento) throws FalhaPagamentoException {
        if (!validarPagamento(pedido, pagamento)) {
            throw new FalhaPagamentoException("Os dados de pagamento fornecidos estão incorretos ");
        }
            pedido.setPagamento(pagamento);
            pedido.setStatusDePagamento(Status.PAGO);
            pagamento.setStatus(Status.PAGO);
            repositorioPedidos.salvarArquivo();
    }
    
    private boolean validarPagamento(Pedido pedido, Pagamento pagamento) throws FalhaPagamentoException {
        if(pedido != null &&
               pedido.getPagamento() == null &&
               pedido.getCliente() != null &&
               pedido.getData() != null &&
               !pedido.getItens().isEmpty() &&
               pagamento.getStatus() != Status.PAGO &&
               pagamento.getValorPago() == pedido.getValorTotal() &&
               validarAtributosEspecificos(pagamento)) {
        	return true;
        }
        else if(pedido.getPagamento()!= null || pedido.getStatus() != Status.AGUARDANDO_PAGAMENTO) {
        	throw new FalhaPagamentoException("O pedido já foi finalizado");
        }
        return false;
    }

    private boolean validarAtributosEspecificos(Pagamento pagamento) throws FalhaPagamentoException {
        if (pagamento instanceof CartaoDeCredito) {
            return verificarAtributosCartao((CartaoDeCredito) pagamento);
        } else if (pagamento instanceof PagamentoPix) {
            return verificarAtributosPix((PagamentoPix) pagamento);
        }
        return false; 
    }

    public boolean verificarAtributosCartao(CartaoDeCredito pagamentoCartao) throws FalhaPagamentoException{
    	if (pagamentoCartao.getParcelas() > 0 && pagamentoCartao.getParcelas() <= 6 &&
                pagamentoCartao.getNumeroCartao() != null && !pagamentoCartao.getNumeroCartao().isEmpty() &&
                pagamentoCartao.getNumeroCartao().length() == 16 &&
                pagamentoCartao.getCVV() != null && !pagamentoCartao.getCVV().isEmpty() &&
                pagamentoCartao.getNomeTitular() != null && !pagamentoCartao.getNomeTitular().isEmpty() &&
                pagamentoCartao.getDataValidade() != null && pagamentoCartao.getDataValidade().isAfter(LocalDate.now())) {
    		return true;
    	}
    	else if (pagamentoCartao.getNumeroCartao().length() != 16) {
    		throw new FalhaPagamentoException("O número do cartão de crédito deve ter 16 dígitos.");
    	}
    	else if (pagamentoCartao.getDataValidade() == null || !pagamentoCartao.getDataValidade().isAfter(LocalDate.now())) {
    		throw new FalhaPagamentoException("A data de validade é inválida.");
    	}
		return false; 
    }

    private boolean verificarAtributosPix(PagamentoPix pagamentoPix) {
        String chavePixEsperada = "12.345.678/0001-23"; 
        String chavePixRecebida = pagamentoPix.getChavePixUsada();
        return chavePixEsperada.equals(chavePixRecebida);
    }
}

    
    



