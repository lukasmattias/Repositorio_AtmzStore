package negocio.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pedido implements Serializable{
    private int id;
    private LocalDateTime data;
    private Status statusDePagamento;
    private double valorTotal;
    private Cliente cliente;
    private List<Item> itens;
    private Pagamento pagamento;

    public Pedido(Cliente cliente, List<Item> itens) {
    	this.id = 0;
        this.cliente = cliente;
        this.itens = itens;
        this.data = LocalDateTime.now(); // Data atual
        this.statusDePagamento = Status.AGUARDANDO_PAGAMENTO; // Pedido inicialmente ativo
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
    
    public void setValorTotal(double novoValor) {
    	this.valorTotal = novoValor;
    }

    public double getValorItens() {
        double valorItens = 0.0; 
        for (Item item : itens) {
        	valorItens += item.getProduto().getPreco() * item.getQuantidade();
        }  
        return valorItens;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }
    
    

    public Cliente getCliente() {
        return cliente;
    }

	public List<Item> getItens() {
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
	               '}';
	    }

    public void setId(int idProxDisponivel) {
        this.id = idProxDisponivel;
    }
    
}
