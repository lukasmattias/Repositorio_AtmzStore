package negocio.beans;

public class Administrador extends Usuario {
	
	private static final long serialVersionUID = 3881495756201902811L;

	public Administrador(String nome, String email, String senha, Endereco endereco) {
        super(0, nome, email, senha, endereco);
    }

	@Override
	public String toString() {
		return "Administrador [Id()=" + getId() + ", Nome()=" + getNome() + ", Email()=" + getEmail()
				+ ", Senha()=" + getSenha() + ", Endereco()=" + getEndereco() + "]";
	}
    
    
    
    
}
