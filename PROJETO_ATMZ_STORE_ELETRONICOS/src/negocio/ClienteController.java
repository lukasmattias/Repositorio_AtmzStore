package negocio;

import java.util.List;

import dados.IRepositorioClientes;
import dados.RepositorioClientes;
import exception.ClienteNuloException;
import negocio.beans.Cliente;

public class ClienteController {
    private static ClienteController instancia;
    private IRepositorioClientes repositorioClientes;

    private ClienteController() {
        repositorioClientes = RepositorioClientes.getInstancia();
    }

    public static ClienteController getInstancia() {
        if (instancia == null) {
            instancia = new ClienteController();
        }
        return instancia;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new ClienteNuloException();
        }
        repositorioClientes.adicionarCliente(cliente);
    }

    public Cliente buscarClientePorId(int id) {
        return repositorioClientes.buscarClientePorId(id);
    }

    public List<Cliente> listarClientes() {
        return repositorioClientes.listarClientes();
    }

    public void atualizarCliente(Cliente clienteAtualizado) {
        if (clienteAtualizado == null) {
            throw new ClienteNuloException();
        }
        repositorioClientes.atualizarCliente(clienteAtualizado);
    }

    public void removerCliente(Cliente cliente) {
        if (cliente == null) {
            throw new ClienteNuloException();
        }
        repositorioClientes.removerCliente(cliente);
    }
    
}

