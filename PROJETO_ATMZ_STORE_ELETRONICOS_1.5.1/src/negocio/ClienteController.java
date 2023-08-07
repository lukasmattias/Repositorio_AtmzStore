package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.IRepositorioClientes;
import dados.RepositorioClientes;
import exception.AtributosNulosException;
import exception.ClienteNuloException;
import exception.EnderecoInvalidoException;
import negocio.beans.Cliente;
public class ClienteController {
    private static ClienteController instancia;
    private List<Cliente> listCli = new ArrayList<>();
    private IRepositorioClientes repositorioClientes = new IRepositorioClientes() {
		
		@Override
		public void removerCliente(Cliente cliente) {
			if(listCli.contains(cliente)) {
				listCli.remove(cliente);
			}
		}
		
		@Override
		public List<Cliente> listarClientes() {
			return listCli;
		}
		
		@Override
		public Cliente buscarClientePorId(int id) {
			Cliente clAux = null;
			for(Cliente cl: listCli) {
				clAux = cl;
			}
			return clAux;
		}
		
		@Override
		public void atualizarCliente(Cliente clienteAtualizado) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void adicionarCliente(Cliente cliente) {
			if(cliente.getEmail() != null && cliente.getEndereco() != null && cliente.getSenha() != null && cliente.getNome() != null ) {
				listCli.add(cliente);
			}
		}
	};

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
        else if (cliente.getCarrinho() == null || cliente.getEmail() == null || cliente.getEndereco() == null 
        		|| cliente.getNome() == null || cliente.getPedidos() == null || cliente.getSenha() == null) {
        	throw new AtributosNulosException("Dados nulos não são permitidos.");
        }
        else if (cliente.getEndereco().getCEP() == null || cliente.getEndereco().getCEP().isEmpty() || cliente.getEndereco().getRua().isEmpty() ||
        		cliente.getEndereco().getRua() == null  || cliente.getEndereco().getCidade() == null ||
        		cliente.getEndereco().getCidade().isEmpty() || cliente.getEndereco().getEstado() == null || 
        		cliente.getEndereco().getEstado().isEmpty() || cliente.getEndereco().getNumero() == null || 
        		cliente.getEndereco().getNumero().isEmpty()) {
                throw new EnderecoInvalidoException("O endereço não está completo.");
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

