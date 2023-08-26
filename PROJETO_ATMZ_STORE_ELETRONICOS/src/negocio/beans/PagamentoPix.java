package negocio.beans;

public class PagamentoPix extends Pagamento {

/**
	 * 
	 */
	private static final long serialVersionUID = -2600928926625512819L;
private String chavePixUsada = "12.345.678/0001-23";

    public PagamentoPix(double valorPago, String chavePix) {
    super(valorPago);
    this.chavePixUsada = chavePix;
  }

    public String getChavePixUsada() {
      return chavePixUsada;
    }

    public void setChavePixUsada(String chavePixUsada) {
      this.chavePixUsada = chavePixUsada;
    }

    @Override
    public String toString() {
      
        return 
            "    Chave PIX: '" + chavePixUsada + "'\n" +
            "    Valor Pago: " + valorPago + "\n" +
            "    Status: " + status.getDescricao();
    }
}

