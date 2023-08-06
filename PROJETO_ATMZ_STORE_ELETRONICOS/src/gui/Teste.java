package gui;

import negocio.beans.Cliente;
import negocio.beans.Endereco;

public class Teste {

	public static void main(String[] args) {
	Cliente n = new Cliente (0, "fd", "ddfs", "fa", new Endereco(null, null, null, null, null));
	System.out.println(n.getNome());
	}

}
