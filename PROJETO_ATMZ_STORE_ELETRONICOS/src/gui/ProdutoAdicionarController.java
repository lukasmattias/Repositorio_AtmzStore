package gui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import exception.OperacaoInvalidaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import negocio.CategoriaController;
import negocio.ProdutoController;
import negocio.UsuarioController;
import negocio.beans.Categoria;
import negocio.beans.Cliente;
import negocio.beans.Endereco;
import negocio.beans.Produto;

public class ProdutoAdicionarController {

	@FXML
	private MenuItem ProdutoAdicionarComputadores;

	@FXML
	private TextField ProdutoAdicionarDescricao;

	@FXML
	private MenuItem ProdutoAdicionarEletrodomesticos;

	@FXML
	private Spinner<Integer>ProdutoAdicionarEstoque;

	@FXML
	private MenuItem ProdutoAdicionarFotoVideo;

	@FXML
	private MenuItem ProdutoAdicionarGadgets;

	@FXML
	private TextField ProdutoAdicionarNome;

	@FXML
	private TextField ProdutoAdicionarPreco;

	@FXML
	private MenuItem ProdutoAdicionarSmartphones;

	@FXML
	private Button btnProdutoAdicionar;

	@FXML
	private Button btnProdutoAdicionarCancelar;

	@FXML
    private MenuButton menuProdutoAdicionarCategoria;
	
	Categoria aux;
	
	
	public void initialize() {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0);
        ProdutoAdicionarEstoque.setValueFactory(valueFactory);
        
        permitirApenasNumeros(ProdutoAdicionarPreco);
        
    }

	
	@FXML
	void AdicionarProduto(ActionEvent event) throws IOException {
		String nome = ProdutoAdicionarNome.getText();
		String descricao = ProdutoAdicionarDescricao.getText();
		double preco = Float.parseFloat(ProdutoAdicionarPreco.getText());
		int estoque = ProdutoAdicionarEstoque.getValue();
		Categoria categoria = aux;
	
		 try {
             ProdutoController.getInstancia().cadastrarProduto(new Produto(nome, descricao, preco, estoque, categoria));
             Alert alert = new Alert(AlertType.CONFIRMATION);
             alert.setTitle("Cadastro Concluído");
             alert.setHeaderText("Cadastro realizado com sucesso!");
             alert.showAndWait();
             Stage stage = (Stage) ProdutoAdicionarNome.getScene().getWindow();
             stage.close();
         }
         catch (OperacaoInvalidaException e) {
             Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Erro de Cadastro");
             alert.setHeaderText("Ocorreu um erro durante o cadastro:");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
         }
		 catch (RuntimeException e) {
             Alert alert = new Alert(AlertType.ERROR);
             alert.setTitle("Erro de Cadastro");
             alert.setHeaderText("Ocorreu um erro durante o cadastro:");
             alert.setContentText(e.getMessage());
             alert.showAndWait();
         }
		 
	}

	@FXML
	void FecharTelaProdutoAdicionar(ActionEvent event) {

	}

	@FXML
	public void RetornarCategoriaComputadores(ActionEvent event) {
		menuProdutoAdicionarCategoria.setText("Computadores");
		aux  = CategoriaController.getInstancia().buscarCategoriaPorId(3);
	}

	@FXML
	public void RetornarCategoriaEletrodomesticos(ActionEvent event) {
		menuProdutoAdicionarCategoria.setText("Eletrodomesticos");
		aux = CategoriaController.getInstancia().buscarCategoriaPorId(4);
	}

	@FXML
	public void RetornarCategoriaFotoVideo(ActionEvent event) {
		menuProdutoAdicionarCategoria.setText("Foto e Vídeo");
		aux = CategoriaController.getInstancia().buscarCategoriaPorId(5);
	}

	@FXML
	public void RetornarCategoriaGadgets(ActionEvent event) {
		menuProdutoAdicionarCategoria.setText("Gadgets");
		aux = CategoriaController.getInstancia().buscarCategoriaPorId(2);
	}

	@FXML
	public void RetornarCategoriaSmartphones(ActionEvent event) {
		menuProdutoAdicionarCategoria.setText("Smartphones");
		aux = CategoriaController.getInstancia().buscarCategoriaPorId(1);
	}

	
	private void permitirApenasNumeros(TextField textField) {
	    textField.textProperty().addListener((observable, valorAntigo, valorNovo) -> {
	        if (!valorNovo.matches("\\d*([.]\\d*)?")) {
	            textField.setText(valorNovo.replaceAll("[^\\d.]", ""));
	        }
	    });
	}
	
}
