package negocio.beans;

public class Administrador extends Usuario {
	
    public Administrador(int id, String nome, String email, String senha, Endereco endereco) {
        super(id, nome, email, senha, endereco);
    }

	@Override
	public String toString() {
		return "Administrador [Id()=" + getId() + ", Nome()=" + getNome() + ", Email()=" + getEmail()
				+ ", Senha()=" + getSenha() + ", Endereco()=" + getEndereco() + "]";
	}
    
    
    
    
}
