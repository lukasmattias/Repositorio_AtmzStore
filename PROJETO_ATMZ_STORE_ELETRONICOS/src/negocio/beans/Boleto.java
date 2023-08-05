package negocio.beans;

import java.util.Date;

public class Boleto extends Pagamento {
    private Date dataVencimento;
    private Date dataPagamento;
    private String codigoBarras;

    public Boleto(int id, double valor, Date dataVencimento, String codigoBarras) {
        super(id, valor);
        this.dataVencimento = dataVencimento;
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void realizarPagamento() {
        // Lógica para realizar o pagamento do boleto
        this.dataPagamento = new Date();
        this.status = "Pago"; // Atualizando o status diretamente
    }

    @Override
    public String obterDetalhesPagamento() {
        return "Boleto - Código de Barras: " + codigoBarras;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }
}
