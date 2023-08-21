package negocio.beans;

import java.io.Serializable;

public enum Status implements Serializable{
    AGUARDANDO_PROCESSAMENTO,
    PAGO,
    CANCELADO
}