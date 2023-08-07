package dados;

import java.util.List;

import negocio.beans.Cliente;

public interface IRepositorioClientes {

	void adicionarCliente(Cliente cliente);

	Cliente buscarClientePorId(int id);

	List<Cliente> listarClientes();

	void atualizarCliente(Cliente clienteAtualizado);

	void removerCliente(Cliente cliente);

}