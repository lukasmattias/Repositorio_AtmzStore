package negocio.beans;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate data;
    private Status status;
    private double valorTotal;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Pagamento pagamento;

    public Pedido(Cliente cliente, List<ItemPedido> itens) {
    	this.id = -1;
        this.cliente = cliente;
        this.itens = itens;
        this.data = LocalDate.now(); // Data atual
        this.status = Status.PENDENTE; // Pedido inicialmente ativo
        this.pagamento = null;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

	public List<ItemPedido> getItens() {
		return itens;
	}
	
	   @Override
	    public String toString() {
	        return "Pedido{" +
	               "id=" + id +
	               ", data=" + data +
	               ", status=" + status +
	               ", valorTotal=" + valorTotal +
	               ", cliente=" + cliente +
	               ", itens=" + itens +
	               ", pagamento=" + pagamento.toString() +
	               '}';
	    }
    
}
