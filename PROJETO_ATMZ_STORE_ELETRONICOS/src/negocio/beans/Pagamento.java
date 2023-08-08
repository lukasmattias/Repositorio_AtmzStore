package negocio.beans;

public abstract class Pagamento {
    private int id;
    private double valor;
    protected Status status;

    public Pagamento(int id, double valor) {
        this.id = id;
        this.valor = valor;
        this.status = Status.PENDENTE; // Status inicial pendente
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }
}
