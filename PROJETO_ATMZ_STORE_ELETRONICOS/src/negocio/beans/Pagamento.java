package negocio.beans;

public abstract class Pagamento {
    private int id;
    private double valor;
    protected String status; // Alteração aqui

    public Pagamento(int id, double valor) {
        this.id = id;
        this.valor = valor;
        this.status = "Pendente"; // Status inicial é pendente
    }

    public void realizarPagamento() {
        this.status = "Pago";
    }

    public void cancelarPagamento() {
        this.status = "Cancelado";
    }

    public String verificarStatus() {
        return status;
    }

    public abstract String obterDetalhesPagamento();

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }
}
