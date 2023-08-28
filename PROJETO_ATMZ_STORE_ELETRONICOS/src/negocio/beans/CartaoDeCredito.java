package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CartaoDeCredito extends Pagamento {
    private int parcelas;
    private double valorDasParcelas;
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
        this.valorDasParcelas = valorASerPago/parcelas;
    }

    @Override
    public String toString() {
        String ultimosDigitos = numeroCartao.substring(numeroCartao.length() - 4);
        String digitosOcultados = "**** **** **** " + ultimosDigitos;
        String s;
        if (parcelas == 5 || parcelas == 6) {
        	s = "Valor pago (com juros): ";
        }
        else {
        	s = "Valor pago (sem juros): ";
        }
        	
        return 
                "    Numero do Cartao: '" + digitosOcultados + "'\n" +
                "    Nome do Titular: '" + nomeTitular + "'\n" +
                "    Parcelas: " + parcelas + "\n" +
                "    " + s + valorPago + "\n" +
                "    Status: " + status.getDescricao()+ "\n" + 
                "    Valor das parcelas: " + this.valorDasParcelas + "\n" + 
                "    Data do pagamento: " + getDataHoraPagamento();
    }
    
    public double getValorDasParcelas() {
    	return this.valorDasParcelas;
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
