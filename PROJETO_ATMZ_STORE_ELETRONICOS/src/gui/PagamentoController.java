package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PagamentoController {
    private Stage stage;
    private Scene scene;


    @FXML
    private AnchorPane PagamentoAnchorPane;

    @FXML
    private Label PagamentoSubTotal;

    @FXML
    private Button btnConfirmarPedido;

    @FXML
    private Button btnCredito;

    @FXML
    private Button btnPagamentoVoltar;

    @FXML
    private Button btnPix;

    @FXML
    void ConfirmarCompra(ActionEvent event) {

    }

    @FXML
    void TelaCredito(ActionEvent event) throws IOException{
        AnchorPane a = FXMLLoader.load(getClass().getResource("Credito.fxml"));
        PagamentoAnchorPane.getChildren().setAll(a);
    }

    @FXML
    void TelaPix(ActionEvent event) throws IOException{
        AnchorPane a = FXMLLoader.load(getClass().getResource("PIX.fxml"));
        PagamentoAnchorPane.getChildren().setAll(a);
    }

    @FXML
    void VoltarCarrinho(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE");
        stage.setScene(scene);
        stage.show();
    }
}
