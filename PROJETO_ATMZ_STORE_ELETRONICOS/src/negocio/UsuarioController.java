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

    public void cadastrarUsuario(Usuario usuario) throws OperacaoInvalidaException{
        if (usuario == null || usuario.getEmail() == null || usuario.getEmail().isEmpty() || usuario.getEmail().isBlank() ||
                usuario.getEndereco() == null || usuario.getNome() == null || usuario.getNome().isEmpty() || usuario.getNome().isBlank() ||
                usuario.getSenha() == null || usuario.getSenha().isEmpty() || usuario.getSenha().isBlank() || 
                usuario.getEndereco().getCEP() == null || usuario.getEndereco().getCEP().isEmpty() || usuario.getEndereco().getCEP().isBlank() ||
                usuario.getEndereco().getRua() == null || usuario.getEndereco().getRua().isEmpty() || usuario.getEndereco().getRua().isBlank() ||
                usuario.getEndereco().getCidade() == null || usuario.getEndereco().getCidade().isEmpty() || usuario.getEndereco().getCidade().isBlank() ||
                usuario.getEndereco().getEstado() == null || usuario.getEndereco().getEstado().isEmpty() || usuario.getEndereco().getEstado().isBlank() ||
                usuario.getEndereco().getNumero() == null || usuario.getEndereco().getNumero().isEmpty() || usuario.getEndereco().getNumero().isBlank()) {
        	throw new OperacaoInvalidaException("Dados nulos ou vazios.");
        }
        
        if(this.buscarUsuarioPorEmail(usuario.getEmail()) == null) {
        	repositorioUsuarios.adicionarUsuario(usuario);
            repositorioUsuarios.salvarArquivo();
        }
        else {
        	throw new OperacaoInvalidaException("Usuario já cadastrado.");
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        return repositorioUsuarios.buscarUsuarioPorId(id);
    }
    
    public Usuario buscarUsuarioPorEmail(String email) {
        return repositorioUsuarios.buscarUsuarioPorEmail(email);
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
        repositorioUsuarios.salvarArquivo();
    }

    public void removerUsuario(Usuario usuario) throws ClasseNulaException{
        if (usuario == null) {
            throw new ClasseNulaException("O Usuario não pode ser nulo.");
        }
        repositorioUsuarios.removerUsuario(usuario);
        repositorioUsuarios.salvarArquivo();
    }
    
    public boolean validarCredenciais(String username, String senha) {
    	if (username == null || senha == null) {
    		return false;
    	}
    	return repositorioUsuarios.validarCredenciais(username, senha);
    }

    
}