package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Pedido> pedidos;
    private CarrinhoDeCompras carrinho;
    
	/**
	 * todos os clientes receberão INICIALMENTE 0 como id. Os ID's válidos irão
	 *  possuir 10 dígitos e começarão do 1 até 10^10
	 */
    
    public Cliente(String nome, String email, String senha, Endereco endereco) {
        super(0, nome, email, senha, endereco);
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

