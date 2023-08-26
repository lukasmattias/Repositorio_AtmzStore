package negocio.beans;

import java.io.Serializable;

public enum Status implements Serializable{
    AGUARDANDO_PAGAMENTO ("Aguardando Pagamento"),
    PAGO ("Pago"),
    CANCELADO ("Cancelado");

	private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}