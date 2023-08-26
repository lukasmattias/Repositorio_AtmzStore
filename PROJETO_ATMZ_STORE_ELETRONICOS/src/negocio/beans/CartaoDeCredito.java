package negocio.beans;

import java.time.LocalDate;


public class CartaoDeCredito extends Pagamento {
    private int parcelas;
    private String numeroCartao;
    private String CVV;
    private String nomeTitular;
    private LocalDate dataValidade;
    

    public CartaoDeCredito(int parcelas, String numeroCartao, String CVV, String nomeTitular, LocalDate dataValidade, double valorASerPago) {
        super(valorASerPago);
        this.parcelas = parcelas;
        this.numeroCartao = numeroCartao;
        this.CVV = CVV;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        String ultimosDigitos = numeroCartao.substring(numeroCartao.length() - 4);
        String digitosOcultados = "**** **** ****" + ultimosDigitos;

        return 
                "    Numero do Cartao: '" + digitosOcultados + "'\n" +
                "    Nome do Titular: '" + nomeTitular + "'\n" +
                "    Parcelas: " + parcelas + "\n" +
                "    Valor Pago: " + valorPago + "\n" +
                "    Status: " + status.getDescricao();
    }


    public int getParcelas() {
        return parcelas;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getCVV() {
        return CVV;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}
