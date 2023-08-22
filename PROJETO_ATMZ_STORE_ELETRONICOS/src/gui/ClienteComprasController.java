package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class ClienteComprasController {

    private Stage stage;
    private Scene scene;
    
    @FXML
    private Button btnVoltarCarrinho;
    
    @FXML
    private TableColumn ClienteNome;
    @FXML
    private TableColumn ClientePedidoID;
    @FXML
    private TableColumn ClientePedidoDataHora;
    @FXML
    private TableColumn ClientePedidoItem;
    @FXML
    private TableColumn ClientePedidoItemID;
    @FXML
    private TableColumn ClientePedidoDescricao;


    @FXML
    void VoltarCarrinho(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Carrinho.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE");
        stage.setScene(scene);
        stage.show();
    }
}
