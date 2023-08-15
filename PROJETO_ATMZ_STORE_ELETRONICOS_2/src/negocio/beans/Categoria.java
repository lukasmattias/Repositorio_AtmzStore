package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
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
		return "Categoria [id=" + id + ", nome=" + nome + ", itens=" + itens + "]";
	}

  public void setId(int iDproxDisponivel) {
    this.id = iDproxDisponivel;
  }
    
    
}

