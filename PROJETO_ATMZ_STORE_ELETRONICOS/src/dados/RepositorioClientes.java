package dados;

import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import negocio.beans.Cliente;

public class RepositorioClientes implements IRepositorioClientes {
    private static IRepositorioClientes instancia;
    private List<Cliente> clientes;
    private int idProxDisponivel = 1;

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
        boolean existe = false;
        for (Cliente c : this.clientes){
            if (c.getEmail() == cliente.getEmail()){
                existe = true;
            }
        }
        if (existe){
            throw new OperacaoInvalidaException("Email ou ID do cliente já foi cadastrado.");
        }   
        cliente.setId(idProxDisponivel);
        idProxDisponivel++;
        this.clientes.add(cliente);
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
		if(this.clientes.contains(cliente)) {
			this.clientes.remove(cliente);
		}
	}
}
