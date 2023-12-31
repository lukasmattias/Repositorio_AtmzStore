package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.OperacaoInvalidaException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import negocio.CarrinhoDeComprasController;
import negocio.CategoriaController;
import negocio.ProdutoController;
import negocio.UsuarioController;
import negocio.beans.Categoria;
import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.Produto;
import javafx.util.converter.IntegerStringConverter;
import javafx.beans.property.SimpleIntegerProperty;

public class ProdutosController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	 @FXML
	    private Button btnAbrirCarrinho;
	 @FXML
	    private Button btnSmartphones;
	 @FXML
	    private Button btnEletrDomesticos;
	 @FXML
	    private Button btnGadgets;
	 @FXML
	    private Button btnFotoeVideo;
	 @FXML
	    private Button btnComputadores;
	 @FXML
	    private Button btnVoltarParaLogin;
	 
	 @FXML
	   private TableView<Produto> tableView;
	 	@FXML
	 	private TableColumn<Produto, Void> colCarrinho;
	    @FXML
	    private TableColumn<Produto, Integer> colId;
	    @FXML
	    private TableColumn<Produto, Integer> colEstoque;
	    @FXML
	    private TableColumn<Produto, String> colNome, colCategoria, colDescricao;
	    @FXML
	    private TableColumn<Produto, Double> colPreco;

	    
	 @FXML
	    public void VoltarParaLogin(ActionEvent event) throws IOException{
		 	SessionController.getInstance().encerrarSessao();
	    	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	 	scene = new Scene(root);
	   	 	stage.setTitle("ATMZ STORE ");
	   	 	stage.setScene(scene);
	   	 	stage.show();
	   	 	SessionController.getInstance().encerrarSessao();
	    }

	 @FXML
	    public void abrirCarrinhoAcionado(ActionEvent event) throws IOException{
	    	Parent root = FXMLLoader.load(getClass().getResource("Carrinho.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	 	scene = new Scene(root);
	   	 	stage.setTitle("ATMZ STORE CARRINHO");
	   	 	stage.setScene(scene);
	   	 	stage.show();
	    }
	 
	 @FXML
	 public void initialize() {
	     colId.setCellValueFactory(new PropertyValueFactory<>("id"));
	     colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	     colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
	     colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
	     colEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
	     colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
	     colCarrinho.setCellFactory(column->new TableCell<Produto, Void>(){
	    	 Spinner<Integer> spinner = new Spinner<>(0, 500 , 0);
	    	 final Button button = new Button ("+");
	    	 {
	    	        spinner.valueProperty().addListener((observable, valorAnterior, novoValor) -> {
	    	        	if (!isEmpty()) {
	    	                Produto produto = getTableView().getItems().get(getIndex());
	    	                if (novoValor > produto.getEstoque()) {
	    	                	spinner.getValueFactory().setValue(produto.getEstoque());
	    	                } 
	    	        	}
	    	        	button.setOnAction(event -> {
	    	        			Cliente c = (Cliente) SessionController.getInstance().getUsuarioLogado();
	    	        			try {
	    	        			CarrinhoDeComprasController.getInstancia().adicionarProdutoNoCarrinho(c.getCarrinho(),getTableView().getItems().get(getIndex()), spinner.getValue());		
	    	        			}
	    	        			catch (OperacaoInvalidaException e) {
	    	        				Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	        	            alert.setTitle("Operação inválida");
	    	        	            alert.setHeaderText(e.getMessage());
	    	        	            alert.showAndWait();
	    	        			}				
	    	        			tableView.refresh();
	    	        	});
	    	        });
	    	    }
	    	 
	    	 @Override
	    	 protected void updateItem(Void item, boolean vazio) {
	    		 super.updateItem(item, vazio);
	    		 if (vazio) {
	    			 setGraphic(null);
	    		 } else {
	    	            HBox spcombotao = new HBox(spinner, button);
	    	            spcombotao.setSpacing(5);
	    	            setGraphic(spcombotao);
	    	        }
	    	    }
	    	}); 
	     tableView.getItems().addAll(ProdutoController.getInstancia().listarProdutos());
	 }

	 	@FXML
	    public void selecionadoSmartphones(ActionEvent event) {
	    	filtrarPorCategoria("Smartphones");
	    }

	    @FXML
	    public void selecionadoEletrDomesticos(ActionEvent event) {
	    	filtrarPorCategoria("Eletrodomesticos");
	    }

	    @FXML
	    public void selecionadoGadgets(ActionEvent event) {
	    	filtrarPorCategoria("Gadgets");
	    }

	    @FXML
	    public void selecionadoFotoeVideo(ActionEvent event) {
	    	filtrarPorCategoria("Foto e Vídeo");
	    }

	    @FXML
	    public void selecionadoComputadores(ActionEvent event) {
	    	filtrarPorCategoria("Computadores");
	    }
	    
	    @FXML
	    public void mostrarTodosOsProdutos(ActionEvent event) {
	    	tableView.getItems().clear();
    	    tableView.getItems().addAll(ProdutoController.getInstancia().listarProdutos());	
	    }
	    
	    public void filtrarPorCategoria(String categoria) {
	    	if (tableView.getItems().size() < ProdutoController.getInstancia().listarProdutos().size()) {
	    		tableView.getItems().clear();
	    	    tableView.getItems().addAll(ProdutoController.getInstancia().listarProdutos());	
	    	}	
	    	List<Produto> produtosFiltrados = new ArrayList<>();
	    	for (Produto p : tableView.getItems()) {
			Categoria categoriaDoProduto = p.getCategoria();
			if (categoriaDoProduto != null && categoriaDoProduto.getNome().equals(categoria)) {
				produtosFiltrados.add(p);
			}
		}
	       tableView.getItems().setAll(produtosFiltrados);
	    }
	
}