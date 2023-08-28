package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import negocio.CategoriaController;
import negocio.beans.Categoria;

public class ProdutoAlterarController {

    @FXML
    private GridPane AdmProdutoTabela;

    @FXML
    private MenuItem ProdutoAdicionarComputadores;

    @FXML
    private MenuItem ProdutoAdicionarEletrodomesticos;

    @FXML
    private MenuItem ProdutoAdicionarFotoVideo;

    @FXML
    private MenuItem ProdutoAdicionarGadgets;

    @FXML
    private MenuItem ProdutoAdicionarSmartphones;

    @FXML
    private MenuButton ProdutoAlterarCategoria;

    @FXML
    private TextField ProdutoAlterarDescricao;

    @FXML
    private Spinner<Integer> ProdutoAlterarEstoque;

    @FXML
    private TextField ProdutoAlterarNome;

    @FXML
    private TextField ProdutoAlterarPreco;

    @FXML
    private AnchorPane TelaAdicionarProduto;

    @FXML
    private Button btnProdutoAdicionar;
    
    Categoria aux;
    
    public void initialize() {
    	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0);
    	ProdutoAlterarEstoque.setValueFactory(valueFactory);
        
        permitirApenasNumeros(ProdutoAlterarPreco);
        
    }

    @FXML
    void alterarProduto(ActionEvent event) {
    
    }

    
	@FXML
	public void RetornarCategoriaComputadores(ActionEvent event) {
		ProdutoAlterarCategoria.setText("Computadores");
		aux  = CategoriaController.getInstancia().buscarCategoriaPorId(3);
	}

	@FXML
	public void RetornarCategoriaEletrodomesticos(ActionEvent event) {
		ProdutoAlterarCategoria.setText("Eletrodomesticos");
		aux = CategoriaController.getInstancia().buscarCategoriaPorId(4);
	}

	@FXML
	public void RetornarCategoriaFotoVideo(ActionEvent event) {
		ProdutoAlterarCategoria.setText("Foto e Vídeo");
		aux = CategoriaController.getInstancia().buscarCategoriaPorId(5);
	}

	@FXML
	public void RetornarCategoriaGadgets(ActionEvent event) {
		ProdutoAlterarCategoria.setText("Gadgets");
		aux = CategoriaController.getInstancia().buscarCategoriaPorId(2);
	}

	@FXML
	public void RetornarCategoriaSmartphones(ActionEvent event) {
		ProdutoAlterarCategoria.setText("Smartphones");
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
