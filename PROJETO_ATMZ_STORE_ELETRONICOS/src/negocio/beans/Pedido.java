package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDateTime data;
    private Status statusDePagamento;
    private double valorTotal;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Pagamento pagamento;

    public Pedido(Cliente cliente, List<ItemPedido> itens) {
    	this.id = 0;
        this.cliente = cliente;
        this.itens = itens;
        this.data = LocalDateTime.now(); // Data atual
        this.statusDePagamento = Status.AGUARDANDO_PROCESSAMENTO; // Pedido inicialmente ativo
        this.pagamento = null;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
	public void setStatusDePagamento(Status status) {
		this.statusDePagamento = status;
	}

	public int getId() {
        return id;
    }

    public String getData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
        String dataFormatada = this.data.format(formatter);
        return dataFormatada;
    }

    public Status getStatus() {
        return statusDePagamento;
    }

    public double getValorTotal() {
        double valorTotal = 0.0; 
        for (ItemPedido item : itens) {
            valorTotal += item.getProduto().getPreco() * item.getQuantidade();
        }  
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
	               ", status=" + statusDePagamento +
	               ", valorTotal=" + valorTotal +
	               ", cliente=" + cliente +
	               ", itens=" + itens +
	               ", pagamento=" + pagamento.toString() +
	               '}';
	    }

    public void setId(int idProxDisponivel) {
        this.id = idProxDisponivel;
    }
    
}
