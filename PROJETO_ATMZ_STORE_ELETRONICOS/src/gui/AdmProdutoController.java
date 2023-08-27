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
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.ProdutoController;
import negocio.beans.Produto;

public class AdmProdutoController {
	private Stage stage;
	private Scene scene;
	
	 @FXML
	 private TableView<Produto> TabelaProdutos;

    @FXML
    private TableColumn<Produto, Integer> AdmProdutosID;

    @FXML
    private TableColumn<Produto, String> AdmProdutosNome;

	@FXML
    private Button btnVoltarLogin;
	
    @FXML
    private Button btnAdmProdutoAdicionar;

    @FXML
    private Button btnAdmProdutoAlterar;

    @FXML
    private Button btnAdmProdutoRemover;

    @FXML
    private Label lblAdmProdutoCategoria;

    @FXML
    private Label lblAdmProdutoDescricao;

    @FXML
    private Label lblAdmProdutoEstoque;

    @FXML
    private Label lblAdmProdutoID;

    @FXML
    private Label lblAdmProdutoNome;

    @FXML
    private Label lblAdmProdutoPreco;
    
    public void initialize() {
    	AdmProdutosID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	AdmProdutosNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	TabelaProdutos.getItems().addAll(ProdutoController.getInstancia().listarProdutos());
    }
    

    @FXML
    public void VoltarLogin(ActionEvent event) throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   	 	scene = new Scene(root);
   	 	stage.setTitle("ATMZ STORE ");
   	 	stage.setScene(scene);
   	 	stage.show();
    }
    

    @FXML
    void AbrirTelaAdicionarProduto(ActionEvent event) throws IOException{
    	 Parent root = FXMLLoader.load(getClass().getResource("AdmProdutoAdicionar.fxml"));
    	 Stage newStage = new Stage();
    	 Scene newScene = new Scene(root);
    	 newStage.setTitle("ADICIONAR PRODUTO");
    	 newStage.setScene(newScene);
    	 newStage.showAndWait();
    }
    
}
