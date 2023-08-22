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
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarrinhoController {
    private Stage stage;
    private Scene scene;


    @FXML
    private Label CarrinhoSubTotal;

    @FXML
    private Button btnCarrinhoVolta;

    @FXML
    private Button btnRealizarPedido;

    @FXML
    private Button btnHistoricoCompras;


    @FXML
    void IrParaTelaPagamento(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Pagamento.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE PAGAMENTO");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void VoltarProdutos(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Produtos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE PRODUTOS");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void IrHistoricoCompras (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ClienteHistoricoCompras.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE COMPRAS");
        stage.setScene(scene);
        stage.show();
    }
}
