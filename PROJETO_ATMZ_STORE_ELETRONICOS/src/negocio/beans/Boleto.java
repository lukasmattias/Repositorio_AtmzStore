package negocio.beans;

import java.time.LocalDate;

public class Boleto extends Pagamento {
    private String nomeBeneficiario = "ATMZ Store";
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private int codigoBarras;

    public Boleto(Pedido pedido, int codigoBarras) {
        super(pedido);
        this.dataVencimento = LocalDate.now().plusDays(3);
        this.codigoBarras = codigoBarras;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "nomeBeneficiario='" + nomeBeneficiario + '\'' +
                ", dataVencimento=" + dataVencimento +
                ", dataPagamento=" + dataPagamento +
                ", codigoBarras=" + codigoBarras +
                '}';
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

	/**
	 * @return the codigoBarras
	 */
	public int getCodigoBarras() {
		return codigoBarras;
	}

}
