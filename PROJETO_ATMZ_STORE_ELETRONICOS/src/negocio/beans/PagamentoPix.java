package negocio.beans;

public class PagamentoPix extends Pagamento {
  private String chavePixUsada;

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

  
}

