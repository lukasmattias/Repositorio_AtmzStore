package negocio.beans;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {

	private static final long serialVersionUID = -5582047030980254359L;
	private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private Categoria categoria;

    public Produto(String nome, String descricao, double preco, int estoque, Categoria categoria2) {
        this.id = 0;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = null;
    }
    
	public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    @Override
    public String toString() {
        return 
               " ID do produto:" + id + "\n" +
               " Nome do produto:'" + nome + "\n" +
               " Descricao:'" + descricao + "\n" +
               " Preco unitário:" + preco + "\n" +
               " Categoria:" + categoria.getNome();
    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Produto produto = (Produto) obj;

        return id == produto.id &&
                Double.compare(produto.preco, preco) == 0 &&
                estoque == produto.estoque &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao) &&
                Objects.equals(categoria, produto.categoria);
    }

    public void setId(int idProxDisponivel) {
        this.id = idProxDisponivel;
    }

}
