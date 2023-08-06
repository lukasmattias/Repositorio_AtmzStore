package negocio;

import java.util.List;

import dados.IRepositorioAdministrador;
import dados.RepositorioAdministrador;
import exception.AdministradorNuloException;
import negocio.beans.Administrador;

public class AdministradorController {
	private static AdministradorController instancia;
    private IRepositorioAdministrador repositorioAdministrador;

    private void AdministradorController() {
        this.repositorioAdministrador = RepositorioAdministrador.getInstance();
    }
    
    public static AdministradorController getInstancia() {
    	if (instancia == null) {
    		instancia = new AdministradorController();
    	}
    	return instancia;
    }

    public void adicionarAdministrador(Administrador administrador) {
        if (administrador == null) {
            throw new AdministradorNuloException();
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
            throw new AdministradorNuloException();
        }
        repositorioAdministrador.atualizarAdministrador(administradorAtualizado);
    }

    public void removerAdministrador(Administrador administrador) {
        if (administrador == null) {
            throw new AdministradorNuloException();
        }
        repositorioAdministrador.removerAdministrador(administrador);
    }
    
}
