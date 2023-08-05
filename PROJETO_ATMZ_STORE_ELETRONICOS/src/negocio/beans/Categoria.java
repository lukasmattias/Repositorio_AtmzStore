package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int id;
    private String nome;
    private String descricao;
    private List<Produto> itens;

    public Categoria(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public void removerProduto(Produto produto) {
        itens.remove(produto);
    }

    public List<Produto> listarProdutos() {
        return itens;
    }

    public Produto procurarProduto(String nomeProduto) {
        for (Produto produto : itens) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
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
}

