package dados;

import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuarios {
    private static IRepositorioUsuarios instancia;
    private List<Usuario> usuarios;
    private int idProxDisponivel = 1;

    private RepositorioUsuarios() {
        usuarios = new ArrayList<>();
    }

    public static IRepositorioUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioUsuarios();
        }
        return instancia;
    }

    /* verifica se o usuario passado como 
	 * 
	 */
    @Override
	public void adicionarUsuario(Usuario usuario) {
        boolean existe = false;
        for (Usuario c : this.usuarios){
            if (c.getEmail() == usuario.getEmail()){
                existe = true;
            }
        }
        if (existe){
            return;
        }   
        usuario.setId(idProxDisponivel);
        idProxDisponivel++;
        this.usuarios.add(usuario);
        }
    


    /* (non-Javadoc)
	 * @see dados.IRepositoriousuarios#buscarusuarioPorId(int)
	 */
    @Override
	public Usuario buscarUsuarioPorId(int id) {
        for (Usuario p : this.usuarios) {
        	if (p.getId() == id) {
        		return p;
        	}
        }
        return null;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositoriousuarios#listarusuarios()
	 */
    @Override
	public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositoriousuarios#atualizarusuario(negocio.beans.usuario)
	 */
    @Override
	public void atualizarUsuario(Usuario usuarioAtualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioAtualizado.getId()) {
                usuarios.set(i, usuarioAtualizado);
                break;
            }
        }
    }

    /* (non-Javadoc)
	 * @see dados.IRepositoriousuarios#removerusuario(negocio.beans.usuario)
	 */
    @Override

	public void removerUsuario(Usuario usuario) {
		if(this.usuarios.contains(usuario)) {
			this.usuarios.remove(usuario);
		}
	}
}
