package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<ItemDoCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

	public List<ItemDoCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoCarrinho> itens) {
		this.itens = itens;
	}
    
    
}
