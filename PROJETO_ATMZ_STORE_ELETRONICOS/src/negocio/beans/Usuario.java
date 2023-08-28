package negocio.beans;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3061732016114721495L;
	private int id;
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;

    public Usuario(int id, String nome, String email, String senha, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

    @Override
    public String toString() {
        return 
               "    Id: " + id + ",\n" +
               "    Nome: '" + nome + "',\n" +
               "    Email: '" + email + "',\n" +
               "    Endereco: '" + endereco.toString() + "'\n";
    }


    

}
