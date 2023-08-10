package dados;

import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Administrador;


public class RepositorioAdministrador implements IRepositorioAdministrador {
	
	//-.-.--.-.-.-atributos.--.-.-.-.
    private static IRepositorioAdministrador instance;
    private List<Administrador> listaAdm = new ArrayList<>();
		int idProxDisponivel = 1;

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
		boolean existe = false;
		for (Administrador adm : this.listaAdm){
			if (adm.getEmail() == administrador.getEmail() || adm.getId() == administrador.getId()){
				existe = true;
			}
		}
		if (existe){
			return;
		} 
			administrador.setId(idProxDisponivel);
			listaAdm.add(administrador);
			idProxDisponivel++;
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


