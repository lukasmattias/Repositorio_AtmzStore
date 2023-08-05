package negocio.beans;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private Categoria categoria;

    public Produto(int id, String nome, String descricao, double preco, int estoque, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public void atualizarEstoque(int quantidade) {
        this.estoque += quantidade;
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
}
