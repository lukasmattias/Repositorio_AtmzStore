package negocio.beans;

public class Administrador extends Usuario {
	
    public Administrador(String nome, String email, String senha, Endereco endereco) {
        super(0, nome, email, senha, endereco);
    }

	@Override
	public String toString() {
		return "Administrador [Id()=" + getId() + ", Nome()=" + getNome() + ", Email()=" + getEmail()
				+ ", Senha()=" + getSenha() + ", Endereco()=" + getEndereco() + "]";
	}
    
    
    
    
}
