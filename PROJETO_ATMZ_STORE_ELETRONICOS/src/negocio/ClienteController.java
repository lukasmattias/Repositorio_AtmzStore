package negocio;

import java.util.List;

import dados.IRepositorioClientes;
import dados.RepositorioClientes;
import exception.AtributosNulosException;
import exception.ClasseNulaException;
import negocio.beans.Cliente;
public class ClienteController {
    private static ClienteController instancia;
    private IRepositorioClientes repositorioClientes = RepositorioClientes.getInstancia();

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
            throw new ClasseNulaException("O cliente não pode ser nulo.");
        } else if (cliente.getCarrinho() == null ||
                   cliente.getEmail() == null ||
                   cliente.getEndereco() == null ||
                   cliente.getNome() == null ||
                   cliente.getPedidos() == null ||
                   cliente.getSenha() == null ||
                   cliente.getEndereco().getCEP() == null || cliente.getEndereco().getCEP().isEmpty() ||
                   cliente.getEndereco().getRua() == null || cliente.getEndereco().getRua().isEmpty() ||
                   cliente.getEndereco().getCidade() == null || cliente.getEndereco().getCidade().isEmpty() ||
                   cliente.getEndereco().getEstado() == null || cliente.getEndereco().getEstado().isEmpty() ||
                   cliente.getEndereco().getNumero() == null || cliente.getEndereco().getNumero().isEmpty()) {
            throw new AtributosNulosException("Dados nulos não são permitidos.");
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
            throw new ClasseNulaException("O cliente não pode ser nulo.");
        }
        repositorioClientes.atualizarCliente(clienteAtualizado);
    }

    public void removerCliente(Cliente cliente) {
        if (cliente == null) {
            throw new ClasseNulaException("O cliente não pode ser nulo.");
        }
        repositorioClientes.removerCliente(cliente);
    }
    
}

