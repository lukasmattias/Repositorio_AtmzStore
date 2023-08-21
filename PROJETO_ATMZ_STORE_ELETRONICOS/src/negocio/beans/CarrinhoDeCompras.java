package negocio.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4770675330499498050L;
	private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
    
    
}
