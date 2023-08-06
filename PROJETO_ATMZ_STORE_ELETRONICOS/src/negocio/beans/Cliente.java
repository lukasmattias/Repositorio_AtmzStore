package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Pedido> pedidos;
    private CarrinhoDeCompras carrinho;

    public Cliente(int id, String nome, String email, String senha, Endereco endereco) {
        super(id, nome, email, senha, endereco);
        this.pedidos = new ArrayList<>();
        this.carrinho = new CarrinhoDeCompras();
    }

	/**
	 * @return the pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos the pedidos to set
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	/**
	 * @return the carrinho
	 */
	public CarrinhoDeCompras getCarrinho() {
		return carrinho;
	}

	/**
	 * @param carrinho the carrinho to set
	 */
	public void setCarrinho(CarrinhoDeCompras carrinho) {
		this.carrinho = carrinho;
	}

    
}

