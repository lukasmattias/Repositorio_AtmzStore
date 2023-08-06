package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.beans.Cliente;

public class RepositorioClientes implements IRepositorioClientes {
    private static IRepositorioClientes instancia;
    private List<Cliente> clientes;
    private int proxID = 1;

    private RepositorioClientes() {
        clientes = new ArrayList<>();
    }

    public static IRepositorioClientes getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioClientes();
        }
        return instancia;
    }

    /* verifica se o cliente passado como 
	 * 
	 */
    @Override
	public void adicionarCliente(Cliente cliente) {
    	{
        cliente.setId(proxID);
        proxID++;
        this.clientes.add(cliente);
        }
    }

    /* (non-Javadoc)
	 * @see dados.IRepositorioClientes#buscarClientePorId(int)
	 */
    @Override
	public Cliente buscarClientePorId(int id) {
        for (Cliente p : this.clientes) {
        	if (p.getId() == id) {
        		return p;
        	}
        }
        return null;
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
