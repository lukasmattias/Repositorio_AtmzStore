package negocio.beans;

import java.time.LocalDate;

public class Boleto extends Pagamento {
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private String codigoBarras;

    public Boleto(double valor, LocalDate dataVencimento, String codigoBarras) {
        super(0, valor);
        this.dataVencimento = dataVencimento;
        this.codigoBarras = codigoBarras;
    }

    @Override
    public String toString() {
        return "Boleto - Codigo de Barras: " + codigoBarras;
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
	public String getCodigoBarras() {
		return codigoBarras;
	}

}
