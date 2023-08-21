 package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.ClasseNulaException;
import exception.OperacaoInvalidaException;
import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.Pedido;
import negocio.beans.Produto;
import negocio.beans.Status;

public class RepositorioPedidos implements IRepositorioPedidos, Serializable  {
    private List<Pedido> pedidos;
    private static IRepositorioPedidos instancia;
    int idProxDisponivel = 1;

    private RepositorioPedidos() {
        pedidos = new ArrayList<>();
    }

    public static IRepositorioPedidos getInstancia() {
        if (instancia == null) {
            instancia = lerDoArquivo();
        }
        return instancia;
    }
    
    private static RepositorioPedidos lerDoArquivo() {
    	RepositorioPedidos instanciaLocal = null;

        File in = new File("pedidos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
          fis = new FileInputStream(in);
          ois = new ObjectInputStream(fis);
          Object o = ois.readObject();
          instanciaLocal = (RepositorioPedidos) o;
        } catch (Exception e) {
          instanciaLocal = new RepositorioPedidos();
        } finally {
          if (ois != null) {
            try {
              ois.close();
            } catch (IOException e) {/* Silent exception */
            }
          }
        }

        return instanciaLocal;
      }

    	@Override
      public void salvarArquivo() {
        if (instancia == null) {
          return;
        }
        File out = new File("pedidos.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
          fos = new FileOutputStream(out);
          oos = new ObjectOutputStream(fos);
          oos.writeObject(instancia);
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if (oos != null) {
            try {
              oos.close();
            } catch (IOException e) {
              /* Silent */}
          }
        }
      }
    	
    @Override
    public void adicionarPedido(Pedido pedido) throws OperacaoInvalidaException{
        boolean existe = false;
        for (Pedido p : this.pedidos){
            if (p.getId() == pedido.getId()){
                existe = true;
            }
        }
        if (existe){
            throw new OperacaoInvalidaException("O ID do pedido já foi cadastrado.");
        }
        pedido.setId(idProxDisponivel);
        pedidos.add(pedido);
        idProxDisponivel++;
        pedido.getCliente().getPedidos().add(pedido);
        pedido.getCliente().getCarrinho().getItens().clear();
        this.salvarArquivo();
    }
    
    @Override
    public String obterDetalhesPedido(Pedido pedido) throws OperacaoInvalidaException{
        if (!this.pedidos.contains(pedido)){
            throw new OperacaoInvalidaException("Pedido não foi cadastrado no sistema.");
        }
        return pedido.toString();
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    @Override
       public List<Item> listarItensDoPedido(Pedido pedido) {
        if(this.pedidos.contains(pedido)){
            return pedido.getItens();
        }
        return null;
    }

    @Override
    public List<Pedido> listarPedidosPorCliente(Cliente cliente) {
        return cliente.getPedidos();
    }

    @Override
    public boolean verificarPedidoExistente(Pedido pedido) {
        for (Pedido p : this.pedidos) {
            if (p.getId() == pedido.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerPedido(Pedido pedido) throws OperacaoInvalidaException {
        if (!this.pedidos.contains(pedido)){
            throw new OperacaoInvalidaException("O pedido não foi cadastrado no sistema.");
        }
            pedidos.remove(pedido);
            pedido.getCliente().getPedidos().remove(pedido);
            pedido.setStatusDePagamento(Status.CANCELADO);
            this.salvarArquivo();
    }

}
