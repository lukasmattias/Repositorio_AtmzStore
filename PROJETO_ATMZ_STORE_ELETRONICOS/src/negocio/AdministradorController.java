package negocio;

import java.util.List;
import dados.IRepositorioAdministrador;
import dados.RepositorioAdministrador;
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
