package negocio;

import java.util.List;
import dados.IRepositorioAdministrador;
import dados.RepositorioAdministrador;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import negocio.beans.Administrador;


public class AdministradorController {
	
	//-.-.--.-.-.-atributos.--.-.-.-.
    private static AdministradorController instance;
    private static IRepositorioAdministrador repositorioAdministrador;

	//-.-.--.-.-.-construtor.--.-.-.-.

    public AdministradorController() {
    	repositorioAdministrador = RepositorioAdministrador.getInstance();
    }
    
	//-.-.--.-.-.-metodos.--.-.-.-.

    
    public static AdministradorController getInstancia() {
    	if (instance == null) {
    		instance = new AdministradorController();
    	}
    	return instance;
    }

    public void adicionarAdministrador(Administrador administrador) {
        if (administrador == null) {
            throw new ClasseNulaException("O administrador não pode ser nulo.");
        }
        else if (administrador.getEmail() == null ||
                administrador.getEndereco() == null ||
                administrador.getNome() == null ||
                administrador.getSenha() == null ||
                administrador.getEndereco().getCEP() == null || administrador.getEndereco().getCEP().isEmpty() ||
                administrador.getEndereco().getRua() == null || administrador.getEndereco().getRua().isEmpty() ||
                administrador.getEndereco().getCidade() == null || administrador.getEndereco().getCidade().isEmpty() ||
                administrador.getEndereco().getEstado() == null || administrador.getEndereco().getEstado().isEmpty() ||
                administrador.getEndereco().getNumero() == null || administrador.getEndereco().getNumero().isEmpty()) {
            throw new AtributosNulosException("Dados nulos não são permitidos.");
        }
        repositorioAdministrador.adicionarAdministrador(administrador);
    }

    public Administrador buscarAdministradorPorId(int id) {
        return repositorioAdministrador.buscarAdministradorPorId(id);
    }

    public List<Administrador> listarAdministradores() {
        return repositorioAdministrador.listarAdministradores();
    }

    public void atualizarAdministrador(Administrador administradorAtualizado) {
        if (administradorAtualizado == null) {
            throw new ClasseNulaException("O administrador não pode ser nulo.");
        }
        repositorioAdministrador.atualizarAdministrador(administradorAtualizado);
    }

    public void removerAdministrador(Administrador administrador) {
        if (administrador == null) {
            throw new ClasseNulaException("O administrador não pode ser nulo.");
        }
        repositorioAdministrador.removerAdministrador(administrador);
    }
    
}
