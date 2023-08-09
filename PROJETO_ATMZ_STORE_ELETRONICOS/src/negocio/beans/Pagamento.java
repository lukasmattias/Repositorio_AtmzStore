package negocio.beans;

public abstract class Pagamento {
    private double valorASerPago;
    protected Status status;

    public Pagamento(Pedido pedido) {
        this.valorASerPago = pedido.getValorTotal();
        this.status = Status.PENDENTE; // Status inicial pendente
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

    public double getValorASerPago() {
        return valorASerPago;
    }
}
