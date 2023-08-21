package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Usuario;

public class RepositorioUsuarios implements IRepositorioUsuarios, Serializable {
    private static IRepositorioUsuarios instancia;
    private List<Usuario> usuarios;
    private int idProxDisponivel = 1;

    private RepositorioUsuarios() {
        usuarios = new ArrayList<>();
    }

    public static IRepositorioUsuarios getInstancia() {
        if (instancia == null) {
            instancia = lerDoArquivo();
        }
        return instancia;
    }
    
    private static RepositorioUsuarios lerDoArquivo() {
    	RepositorioUsuarios instanciaLocal = null;

        File in = new File("usuarios.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
          fis = new FileInputStream(in);
          ois = new ObjectInputStream(fis);
          Object o = ois.readObject();
          instanciaLocal = (RepositorioUsuarios) o;
        } catch (Exception e) {
          instanciaLocal = new RepositorioUsuarios();
        } finally {
          if (ois != null) {
            try {
              ois.close();
            } catch (IOException e) {/* Silent exception */
            }
          }
        }

        return instanciaLocal;
      }

    	@Override
      public void salvarArquivo() {
        if (instancia == null) {
          return;
        }
        File out = new File("usuarios.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
          fos = new FileOutputStream(out);
          oos = new ObjectOutputStream(fos);
          oos.writeObject(instancia);
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if (oos != null) {
            try {
              oos.close();
            } catch (IOException e) {
              /* Silent */}
          }
        }
      }


    @Override
	public void adicionarUsuario(Usuario usuario) { 
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
    
    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario p : this.usuarios) {
        	if (p.getEmail().equals(email)) {
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
    
    @Override
    public boolean validarCredenciais(String username, String senha) {
    	Usuario u = this.buscarUsuarioPorEmail(username);
    	if (u == null) {
    		return false;
    	}
    	else {
    		if (!u.getSenha().equals(senha)) {
    			return false;
    		}
            return true;
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
