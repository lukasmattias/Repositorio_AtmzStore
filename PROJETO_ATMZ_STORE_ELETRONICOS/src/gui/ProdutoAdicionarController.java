package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProdutoAdicionarController {

	@FXML
    private AnchorPane TelaAdicionarProduto;

    @FXML
    private TextField ProdutoAdicionarCategoria;

    @FXML
    private TextField ProdutoAdicionarDescricao;

    @FXML
    private TextField ProdutoAdicionarEstoque;

    @FXML
    private TextField ProdutoAdicionarID;

    @FXML
    private TextField ProdutoAdicionarNome;

    @FXML
    private TextField ProdutoAdicionarPreco;

    @FXML
    private Button btnProdutoAdicionar;

    @FXML
    private Button btnProdutoAdicionarCancelar;



    @FXML
    void AdicionarProduto(ActionEvent event) {

    }

    @FXML
    void FecharTelaProdutoAdicionar(ActionEvent event) {
    	
    }
}
