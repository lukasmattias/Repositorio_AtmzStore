package negocio;

import negocio.beans.Pedido;
import negocio.beans.Status;

public class ServicoAtualizacaoStatus {
    public void atualizarStatus(Pedido pedido, Status novoStatus) {
        pedido.setStatus(novoStatus);
    }
}


