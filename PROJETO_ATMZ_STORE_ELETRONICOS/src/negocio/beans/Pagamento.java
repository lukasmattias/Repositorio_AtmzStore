package negocio.beans;

public abstract class Pagamento {
    private double valorPago;
    protected Status status;

    public Pagamento(double valorPago) {
        this.valorPago = valorPago;
        this.status = Status.AGUARDANDO_PROCESSAMENTO; // Status inicial
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
}
