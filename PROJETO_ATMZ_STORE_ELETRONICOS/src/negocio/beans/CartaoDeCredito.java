package negocio.beans;

import java.util.Date;

public class CartaoDeCredito extends Pagamento {
    private int parcelas;
    private String numeroCartao;
    private int CVV;
    private String nomeTitular;
    private Date dataValidade;

    public CartaoDeCredito(int id, double valor, int parcelas, String numeroCartao, int CVV, String nomeTitular, Date dataValidade) {
        super(id, valor);
        this.parcelas = parcelas;
        this.numeroCartao = numeroCartao;
        this.CVV = CVV;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
    }

    @Override
    public void realizarPagamento() {
        // L�gica para realizar o pagamento com cart�o de cr�dito
        this.status = "Pago"; // Atualizando o status diretamente
    }

    @Override
    public String obterDetalhesPagamento() {
        return "Cart�o de Cr�dito - Parcelas: " + parcelas + " - N�mero: " + numeroCartao;
    }

    public int getParcelas() {
        return parcelas;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public int getCVV() {
        return CVV;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public Date getDataValidade() {
        return dataValidade;
    }
}
