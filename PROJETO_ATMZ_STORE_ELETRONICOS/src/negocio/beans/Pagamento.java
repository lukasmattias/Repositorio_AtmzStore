package negocio.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Pagamento implements Serializable{
  
	private static final long serialVersionUID = -729203901862031403L;
	protected double valorPago;
    protected Status status;
    protected LocalDateTime dataHoraPagamento;
    
    public Pagamento(double valorPago) {
        this.valorPago = valorPago;
        this.status = Status.AGUARDANDO_PAGAMENTO; // Status inicial
        this.dataHoraPagamento = LocalDateTime.now();
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

    public double setValorPago() {
        return valorPago;
    }

    public double getValorPago(){
        return valorPago;
    }
    
    public String getDataHoraPagamento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
        String dataFormatada = dataHoraPagamento.format(formatter);
        return dataFormatada;
    }
    
}
