package negocio.beans;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date data;
    private boolean status;
    private double valorTotal;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Pagamento pagamento;

    public Pedido(int id, Cliente cliente, List<ItemPedido> itens) {
    	this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.data = new Date(); // Data atual
        this.status = true; // Pedido inicialmente ativo
        this.valorTotal = calcularValorTotal();
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    public void cancelarPedido() {
        this.status = false;
    }

    public List<ItemPedido> listarProdutos() {
        return itens;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void finalizarPedido() {
        // Lógica para finalizar o pedido
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public boolean getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
