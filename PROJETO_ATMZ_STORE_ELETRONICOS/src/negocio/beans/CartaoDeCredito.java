package negocio.beans;

import java.util.Date;

public class CartaoDeCredito extends Pagamento {
    private int parcelas;
    private String numeroCartao;
    private int CVV;
    private String nomeTitular;
    private Date dataValidade;

    public CartaoDeCredito(double valor, int parcelas, String numeroCartao, int CVV, String nomeTitular, Date dataValidade) {
        super(0, valor);
        this.parcelas = parcelas;
        this.numeroCartao = numeroCartao;
        this.CVV = CVV;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Cartao de Credito - Parcelas: " + parcelas + " - N�mero: " + numeroCartao;
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
