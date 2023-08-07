package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dados.IRepositorioAdministrador;
import exception.AdministradorNuloException;
import negocio.beans.Administrador;

public class AdministradorController {
	private static AdministradorController instance = new AdministradorController();
	private List<Administrador> listaAdm = new ArrayList<>();
    private IRepositorioAdministrador repositorioAdministrador = new IRepositorioAdministrador() {
		
		@Override
		public void removerAdministrador(Administrador administrador) {
			if(listaAdm.contains(administrador)) {
				listaAdm.remove(administrador);
			}
				
		}
		
		@Override
		public List<Administrador> listarAdministradores() {
			System.out.println("LISTA DE ADMINISTRADORES");
			for(Administrador adm: listaAdm) {
				adm.toString();
				System.out.println();
			}
			return null;
		}
		
		@Override
		public Administrador buscarAdministradorPorId(int id) {
			Administrador admAux = null;
			for(Administrador adm: listaAdm) {
				if(adm.getId() == id) {
					admAux = adm;
				}
			}
				
			return admAux;
		}
		
		@Override
		public void atualizarAdministrador(Administrador administradorAtualizado) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void adicionarAdministrador(Administrador administrador) {
			if(administrador.getEmail() != null && administrador.getEndereco() != null && administrador.getEndereco() != null && administrador.getNome() != null && administrador.getSenha() != null && administrador.getId() != 0) {
				listaAdm.add(administrador);
			}
			
		}
	};


	public static AdministradorController getInstance() {
		if(Objects.isNull(instance)) {
			synchronized (AdministradorController.class) {
				if(Objects.isNull(instance)) {
				instance = new AdministradorController();
				}
			}
		}
		return instance;
	}
    
    public static AdministradorController getInstancia() {
    	if (instance == null) {
    		instance = new AdministradorController();
    	}
    	return instance;
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
