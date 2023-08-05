package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Cliente;

public class RepositorioClientes implements IRepositorioClientes {
    private static IRepositorioClientes instancia;
    private List<Cliente> clientes;

    private RepositorioClientes() {
        clientes = new ArrayList<>();
    }

    public static IRepositorioClientes getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioClientes();
        }
        return instancia;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioClientes#adicionarCliente(negocio.beans.Cliente)
	 */
    @Override
	public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioClientes#buscarClientePorId(int)
	 */
    @Override
	public Cliente buscarClientePorId(int id) {
        return clientes.stream()
            .filter(cliente -> cliente.getId() == id)
            .findFirst()
            .orElse(null);
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioClientes#listarClientes()
	 */
    @Override
	public List<Cliente> listarClientes() {
        return clientes;
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioClientes#atualizarCliente(negocio.beans.Cliente)
	 */
    @Override
	public void atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == clienteAtualizado.getId()) {
                clientes.set(i, clienteAtualizado);
                break;
            }
        }
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioClientes#removerCliente(negocio.beans.Cliente)
	 */
    @Override
	public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
}
