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

    public Pedido(Cliente cliente, List<ItemPedido> itens) {
        this.cliente = cliente;
        this.itens = itens;
        this.data = new Date(); // Data atual
        this.status = true; // Pedido inicialmente ativo
        this.valorTotal = calcularValorTotal();
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
        // L�gica para finalizar o pedido
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
