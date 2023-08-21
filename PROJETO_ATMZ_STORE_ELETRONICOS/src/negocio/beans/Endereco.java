package negocio.beans;

import java.io.Serializable;

public class Endereco implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7495534587376073399L;
	private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String CEP;

    public Endereco(String rua, String numero, String cidade, String estado, String CEP) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.CEP = CEP;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCEP() {
        return CEP;
    }

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", cidade=" + cidade + ", estado=" + estado + ", CEP="
				+ CEP + "]";
	}
    
    
}
