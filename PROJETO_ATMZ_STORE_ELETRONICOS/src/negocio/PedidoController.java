package negocio;

import java.util.List;

import dados.IRepositorioPedidos;
import dados.RepositorioPedidos;
import exception.PagamentoNaoDefinidoException;
import exception.PedidoInvalidoException;
import exception.PedidoNaoEncontradoException;
import negocio.beans.Cliente;
import negocio.beans.ItemDoCarrinho;
import negocio.beans.ItemPedido;
import negocio.beans.Pagamento;
import negocio.beans.Pedido;

public class PedidoController {
    private static PedidoController instancia;
    private IRepositorioPedidos repositorioPedidos;

    private PedidoController() {
        repositorioPedidos = RepositorioPedidos.getInstancia();
    }

    public static PedidoController getInstancia() {
        if (instancia == null) {
            instancia = new PedidoController();
        }
        return instancia;
    }

    public void criarPedido(Cliente cliente, List<ItemPedido> itens, Pagamento pagamento) {
        if (cliente == null || itens == null || pagamento == null) {
            throw new PedidoInvalidoException();
        }

        Pedido novoPedido = new Pedido(123 /* ID do pedido??? */, cliente, itens);
        novoPedido.setPagamento(pagamento);

        repositorioPedidos.adicionarPedido(novoPedido);
    }



    public void finalizarPedido(int idPedido) {
        Pedido pedido = repositorioPedidos.buscarPedidoPorId(idPedido);
        if (pedido == null) {
            throw new PedidoNaoEncontradoException();
        }

        Pagamento pagamento = pedido.getPagamento();
        if (pagamento == null) {
            throw new PagamentoNaoDefinidoException();
        }

        pagamento.realizarPagamento();
        pedido.setStatus(StatusPedido.FINALIZADO);


        repositorioPedidos.atualizarPedido(pedido);
    }
}
