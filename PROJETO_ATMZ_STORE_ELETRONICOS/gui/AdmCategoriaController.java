package gui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import negocio.CategoriaController;
import negocio.ProdutoController;
import negocio.beans.Categoria;
import negocio.beans.Cliente;
import negocio.beans.Produto;

public class AdmCategoriaController {
	private Stage stage;
	private Scene scene;
	

    @FXML
    private TableView<Categoria> tabelaCategoria;

    @FXML
    private TableView<Produto> tabelaCategoriaProduto;


    @FXML
    private TableColumn<Categoria, Integer> AdmCategoriaID;

    @FXML
    private TableColumn<Categoria, String> AdmCategoriaNome;

    @FXML
    private TableColumn<Produto, Integer> AdmIDCategoriaProdutos;

    @FXML
    private TableColumn<Produto, String> AdmNomeCategoriaProduto;
	
	@FXML
    private Button btnVoltarLogin;

    @FXML
    private Label lblAdmCategoriaID;

    @FXML
    private Label lblAdmCategoriaNome;
    
    public void initialize() {
    	AdmCategoriaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	AdmCategoriaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	AdmIDCategoriaProdutos.setCellValueFactory(new PropertyValueFactory<>("id"));
    	AdmNomeCategoriaProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	tabelaCategoria.getItems().addAll(CategoriaController.getInstancia().listarCategorias());
    	//tabelaCategoriaProduto.getItems().addAll(ProdutoController.getInstancia().listarProdutos());
    	
    	tabelaCategoria.setOnMouseClicked(event -> {
			if (event.getClickCount() == 1) {
				Categoria categoriaSelecionada = tabelaCategoria.getSelectionModel().getSelectedItem();
				if (categoriaSelecionada != null) {
					filtrarPorCategoria(categoriaSelecionada.getNome());
				}
			}
		});
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
    
    public void filtrarPorCategoria(String categoria) {
    	 List<Produto> produtosFiltrados = new ArrayList<>();
    	    
    	    for (Produto p : ProdutoController.getInstancia().listarProdutos()) {
    	        Categoria categoriaDoProduto = p.getCategoria();
    	        
    	        if (categoriaDoProduto != null && categoriaDoProduto.getNome().equals(categoria)) {
    	            produtosFiltrados.add(p);
    	        }
    	    }
    	    
    	    tabelaCategoriaProduto.getItems().setAll(produtosFiltrados);
    }
    
}
