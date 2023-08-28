package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ProdutoClienteController {

    @FXML
    private GridPane AdmProdutoTabela;

    @FXML
    private Label Estoque;

    @FXML
    private Label ProdutoClienteCategoria;

    @FXML
    private Label ProdutoClienteDescricao;

    @FXML
    private Label ProdutoClienteID;

    @FXML
    private Label ProdutoClienteNome;

    @FXML
    private Label ProdutoClientePreco;

    @FXML
    private AnchorPane TelaAdicionarProduto;

    @FXML
    private Button btnAdicionarCarrinho;

    @FXML
    private Label lblAdmProdutoEstoque;

    @FXML
    private Spinner<?> spinProdutoCliente;

    @FXML
    void AdicionarCarrinho(ActionEvent event) {

    }

}
