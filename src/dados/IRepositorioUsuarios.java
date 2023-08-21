package dados;

import java.util.List;

import negocio.beans.Usuario;

public interface IRepositorioUsuarios {

	void adicionarUsuario(Usuario usuario);

	Usuario buscarUsuarioPorId(int id);

	List<Usuario> listarUsuarios();

	void atualizarUsuario(Usuario usuarioAtualizado);

	void removerUsuario(Usuario usuario);

	Usuario buscarUsuarioPorEmail(String email);

	boolean validarCredenciais(String username, String senha);

	void salvarArquivo();

}