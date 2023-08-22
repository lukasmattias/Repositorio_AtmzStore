package gui;

import javafx.scene.control.MenuItem;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AdmController {
	
    @FXML
    private MenuItem AdmCategoriaInfo;

    @FXML
    private MenuItem AdmClienteInfo;

    @FXML
    private MenuItem AdmProdutoInfo;

    @FXML
    private MenuItem AdmHistoricoCompras;

    @FXML
    private AnchorPane AnchorPaneADM;

    @FXML
    void IrAdmCategoria(ActionEvent event) throws IOException{
    	Pane a = FXMLLoader.load(getClass().getResource("AdmCategorias.fxml"));
    	AnchorPaneADM.getChildren().setAll(a);
    }

    @FXML
    void IrAdmCliente(ActionEvent event) throws IOException{
    	Pane a = FXMLLoader.load(getClass().getResource("AdmCliente.fxml"));
    	AnchorPaneADM.getChildren().setAll(a);
    }

    @FXML
    void IrAdmProduto(ActionEvent event) throws IOException{
    	Pane a = FXMLLoader.load(getClass().getResource("AdmProdutos.fxml"));
    	AnchorPaneADM.getChildren().setAll(a);
    }

    @FXML
    void IrAdmHistoricoCompras(ActionEvent event) throws IOException {

    }

}
