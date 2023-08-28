package negocio.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable {
 
	private static final long serialVersionUID = 3618843055113743326L;
	private int id;
    private String nome;
    private List<Produto> itens;

    public Categoria(int i, String nome) {
        this.id = i;
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public List<Produto> getItens(){
        return this.itens;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

	@Override
	public String toString() {
		return nome;
	}

  public void setId(int iDproxDisponivel) {
    this.id = iDproxDisponivel;
  }
    
    
}

