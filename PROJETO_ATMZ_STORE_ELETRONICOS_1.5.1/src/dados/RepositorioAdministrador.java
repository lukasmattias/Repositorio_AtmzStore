package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Administrador;


public class RepositorioAdministrador implements IRepositorioAdministrador {
	
	//-.-.--.-.-.-atributos.--.-.-.-.
    private static IRepositorioAdministrador instance;
    private List<Administrador> listaAdm = new ArrayList<>();

    //-.-.--.-.-.-metodos.--.-.-.-.

    public static IRepositorioAdministrador getInstance() {
        if (instance == null) {
            instance = new RepositorioAdministrador();
        }
        return instance;
    }
    

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#adicionarAdministrador(negocio.beans.Administrador)
	 */
	@Override
	public void adicionarAdministrador(Administrador administrador) {
		if(administrador.getEmail() != null && administrador.getEndereco() != null && administrador.getEndereco() != null && administrador.getNome() != null && administrador.getSenha() != null && administrador.getId() != 0) {
			listaAdm.add(administrador);
		}
		
	}

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#buscarAdministradorPorId(int)
	 */
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

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#listarAdministradores()
	 */
    @Override
	public List<Administrador> listarAdministradores() {
		System.out.println("LISTA DE ADMINISTRADORES");
		for(Administrador adm: listaAdm) {
			adm.toString();
			System.out.println();
		}
		return null;
	}

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#atualizarAdministrador(negocio.beans.Administrador)
	 */
    @Override
	public void atualizarAdministrador(Administrador administradorAtualizado) {
        for (int i = 0; i < listaAdm.size(); i++) {
            if (listaAdm.get(i).getId() == administradorAtualizado.getId()) {
            	listaAdm.set(i, administradorAtualizado);
                break;
            }
        }
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#removerAdministrador(negocio.beans.Administrador)
	 */
	@Override
	public void removerAdministrador(Administrador administrador) {
		if(listaAdm.contains(administrador)) {
			listaAdm.remove(administrador);
		}
			
	}
}


