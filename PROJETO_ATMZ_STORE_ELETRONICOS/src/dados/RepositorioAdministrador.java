package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Administrador;


public class RepositorioAdministrador implements IRepositorioAdministrador {
    private static IRepositorioAdministrador instancia;
    private List<Administrador> administradores;

    private RepositorioAdministrador() {
        administradores = new ArrayList<>();
    }

    public static IRepositorioAdministrador getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioAdministrador();
        }
        return instancia;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#adicionarAdministrador(negocio.beans.Administrador)
	 */
    @Override
	public void adicionarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#buscarAdministradorPorId(int)
	 */
    @Override
	public Administrador buscarAdministradorPorId(int id) {
        return administradores.stream()
            .filter(administrador -> administrador.getId() == id)
            .findFirst()
            .orElse(null);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#listarAdministradores()
	 */
    @Override
	public List<Administrador> listarAdministradores() {
        return administradores;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#atualizarAdministrador(negocio.beans.Administrador)
	 */
    @Override
	public void atualizarAdministrador(Administrador administradorAtualizado) {
        for (int i = 0; i < administradores.size(); i++) {
            if (administradores.get(i).getId() == administradorAtualizado.getId()) {
                administradores.set(i, administradorAtualizado);
                break;
            }
        }
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioAdministrador#removerAdministrador(negocio.beans.Administrador)
	 */
    @Override
	public void removerAdministrador(Administrador administrador) {
        administradores.remove(administrador);
    }
}


