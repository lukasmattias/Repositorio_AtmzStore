package dados;

import java.util.List;

import negocio.beans.Administrador;

public interface IRepositorioAdministrador {

	void adicionarAdministrador(Administrador administrador);

	Administrador buscarAdministradorPorId(int id);

	List<Administrador> listarAdministradores();

	void atualizarAdministrador(Administrador administradorAtualizado);

	void removerAdministrador(Administrador administrador);

}