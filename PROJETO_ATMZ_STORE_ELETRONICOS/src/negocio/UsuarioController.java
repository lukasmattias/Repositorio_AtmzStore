package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.IRepositorioUsuarios;
import dados.RepositorioUsuarios;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import negocio.beans.Administrador;
import negocio.beans.Cliente;
import negocio.beans.Endereco;
import negocio.beans.Usuario;


public class UsuarioController {
	
	//-.-.--.-.-.-atributos.--.-.-.-.
    private static UsuarioController instance;
    private static IRepositorioUsuarios repositorioUsuarios;

	//-.-.--.-.-.-construtor.--.-.-.-.

    private UsuarioController() {
    	repositorioUsuarios = RepositorioUsuarios.getInstancia();
    }
    
	//-.-.--.-.-.-metodos.--.-.-.-.

    
    public static UsuarioController getInstancia() {
    	if (instance == null) {
    		instance = new UsuarioController();
    	}
    	return instance;
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getEmail() == null ||
                usuario.getEndereco() == null ||
                usuario.getNome() == null ||
                usuario.getSenha() == null ||
                usuario.getEndereco().getCEP() == null || usuario.getEndereco().getCEP().isEmpty() ||
                usuario.getEndereco().getRua() == null || usuario.getEndereco().getRua().isEmpty() ||
                usuario.getEndereco().getCidade() == null || usuario.getEndereco().getCidade().isEmpty() ||
                usuario.getEndereco().getEstado() == null || usuario.getEndereco().getEstado().isEmpty() ||
                usuario.getEndereco().getNumero() == null || usuario.getEndereco().getNumero().isEmpty()) {
            return;
        }
        repositorioUsuarios.adicionarUsuario(usuario);
    }

    public Usuario buscarUsuarioPorId(int id) {
        return repositorioUsuarios.buscarUsuarioPorId(id);
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuarios.listarUsuarios();
    }

    public List<Administrador> listarAdministradores() {
        ArrayList<Administrador> adms = new ArrayList<>();
        for (Usuario u : repositorioUsuarios.listarUsuarios()){
            if (u instanceof Administrador){
                Administrador adm = (Administrador) u;
                adms.add(adm);
            }
        }
        return adms;
    }

    public List<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Usuario u : repositorioUsuarios.listarUsuarios()){
            if (u instanceof Cliente){
                Cliente cliente = (Cliente) u;
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void atualizarUsuario(Usuario usuarioAtualizado) throws ClasseNulaException{
        if (usuarioAtualizado == null) {
            throw new ClasseNulaException("O Usuario não pode ser nulo.");
        }
        repositorioUsuarios.atualizarUsuario(usuarioAtualizado);
    }

    public void removerUsuario(Usuario usuario) throws ClasseNulaException{
        if (usuario == null) {
            throw new ClasseNulaException("O Usuario não pode ser nulo.");
        }
        repositorioUsuarios.removerUsuario(usuario);
    }

    
}
