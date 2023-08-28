package gui;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import exception.FalhaPagamentoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import negocio.CarrinhoDeComprasController;
import negocio.PedidoController;
import negocio.beans.CartaoDeCredito;
import negocio.beans.Cliente;
import negocio.beans.Item;
import negocio.beans.Pagamento;
import negocio.beans.PagamentoPix;
import negocio.beans.Pedido;
import negocio.beans.Produto;

public class PagamentoController {

    //atributos Pix

    @FXML
    private AnchorPane telaPIX;

    @FXML
    private Label lblChavePix;

    @FXML
    private TableView<Item> tableViewItens;
    
    //Atributos credito

    @FXML
    private GridPane gridPane;
    
    @FXML
    private StackPane pagamentoStackPane;
    
    @FXML
    private TextField creditoCVV, creditoNomeTitular, creditoNumCartao;

    @FXML
    private ChoiceBox<String> creditoParcelas;
    
    public String[] opcoes = {"1x", "2x", "3x"};
    
    @FXML
    private DatePicker creditoValidade;

    @FXML
    private TableColumn<Item, String> itemColumn, subTotalColumn;
    
    //Atributos Pagamento
    private Stage stage;
    private Scene scene;

    @FXML
    private AnchorPane PagamentoAnchorPane;
    
    @FXML
    private Label valorTotal,pagamentoTotal, valorDaParcela, parcelas;
    @FXML
    private Button btnConfirmarPedido, btnCredito, btnPagamentoVoltar, btnPix;

    @FXML
    private AnchorPane telaCredito, telaCompra;
    
    @FXML
    private TableColumn<Pedido, String> PagamentoProduto;
    
    @FXML
    private TableColumn<Produto, String> PagamentoDescricao, PagamentoPreco;
    
    double valorInicialDoPedido;
    
    @FXML
    void telaCredito(ActionEvent event) throws IOException{ 
    		creditoParcelas.setValue("1x (sem juros)");
		    valorDaParcela.setText(valorTotal.getText());
    		gridPane.setVisible(true);   
        	gridPane.setManaged(true);
        	valorDaParcela.setVisible(true);
 		   	parcelas.setVisible(true);
    	    telaPIX.setVisible(false);
    	    telaPIX.setManaged(false);
    }

    @FXML
    void telaPix(ActionEvent event) throws IOException {  
    	Cliente c = (Cliente) SessionController.getInstance().getUsuarioLogado();
    	valorTotal.setText(Double.toString(PedidoController.getInstancia().retornarUltimoPedido(c).getValorItens()));
    	gridPane.setVisible(false);  
    	gridPane.setManaged(false);
    	valorDaParcela.setVisible(false);
		parcelas.setVisible(false);
    	telaPIX.setVisible(true);
    	telaPIX.setManaged(true);
    	
    }

    @FXML
    void voltarCarrinho(ActionEvent event) throws IOException{
    	Cliente cliente = (Cliente) SessionController.getInstance().getUsuarioLogado();
    	if (PedidoController.getInstancia().retornarUltimoPedido(cliente).getPagamento() == null) {
    		boolean cancelarPedido = cancelarPedidoSimNao();
        	if (cancelarPedido) {
        	PedidoController.getInstancia().cancelarPedido(PedidoController.getInstancia().retornarUltimoPedido(cliente));
        	Parent root = FXMLLoader.load(getClass().getResource("Produtos.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("ATMZ STORE PRODUTOS");
            stage.setScene(scene);
            stage.show();
        	}
    	}
    	else {
    		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Carrinho.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("ATMZ STORE");
            stage.setScene(scene);
            stage.show();		
    	} 
    }

   @FXML
    public void confirmarCompra(ActionEvent event) throws IOException {
	   realizarPagamento();
    }
   
   @FXML
   public void initialize() {
	   // definindo as opcoes de parcelamento
	   ObservableList<String> parcelasOpcoes = FXCollections.observableArrayList(
               "1x (sem juros)",
               "2x (sem juros)",
               "3x (sem juros)",
               "4x (sem juros)",
               "5x (com juros de 3% a.m)",
               "6x (com juros de 4,5% a.m)"
       );
	   creditoParcelas.setItems(parcelasOpcoes);
	   creditoParcelas.setValue("1x (sem juros)");
	   // calculando o valor das parcelas
	   creditoParcelas.valueProperty().addListener((observable, antigoValor, novoValor) -> {
		    Cliente c = (Cliente) SessionController.getInstance().getUsuarioLogado();
		    int valor = Integer.parseInt(novoValor.substring(0, 1)); 
		    double valorTotalDouble = Double.parseDouble(valorTotal.getText());
		    
		    double juros = calcularJurosCartao(PedidoController.getInstancia().retornarUltimoPedido(c), valor);
		    double resultado = valorTotalDouble / valor;

		    valorTotal.setText(Double.toString(juros)); 
		    valorDaParcela.setText(Double.toString(resultado));
		    
		    double novoValorTotal = Double.parseDouble(valorTotal.getText());
        	c.getPedidos().get(c.getPedidos().size() - 1).setValorTotal(novoValorTotal);
        
		});
	   /*
	    * deixando o valor das parcelas invisível até que
	    * a forma de pagamento Cartão seja selecionada
	    */
	   valorDaParcela.setVisible(false);
	   parcelas.setVisible(false);
   
	   creditoNumCartao.textProperty().addListener((observable, valorAnterior, novoValor) -> {
	        if (!novoValor.matches("\\d*") || novoValor.length() > 16) {
	            creditoNumCartao.setText(valorAnterior);
	        }
	    });
	   // inicializando a tableview
	   Cliente cliente = (Cliente) SessionController.getInstance().getUsuarioLogado();
	   valorInicialDoPedido = PedidoController.getInstancia().retornarUltimoPedido(cliente).getValorItens();
	   Pedido pedido = PedidoController.getInstancia().retornarUltimoPedido(cliente);
	   valorTotal.setText("" + pedido.getValorItens());
	   tableViewItens.getItems().clear();
	   tableViewItens.refresh();
       itemColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));
       subTotalColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getSubtotal())));
       tableViewItens.getItems().addAll(pedido.getItens());
   }
   
   private void realizarPagamento() {
	  
	   negocio.PagamentoController pagamento = negocio.PagamentoController.getInstancia();
	   Cliente c = (Cliente)SessionController.getInstance().getUsuarioLogado();
	   
	   if (gridPane.isVisible()) {
		 
		   LocalDate cartaoValidade = creditoValidade.getValue();
	       CartaoDeCredito cartao = new CartaoDeCredito(Character.getNumericValue(creditoParcelas.getValue().charAt(0)),
	               creditoNumCartao.getText(), creditoCVV.getText(), creditoNomeTitular.getText(), cartaoValidade,
	               Double.parseDouble(valorTotal.getText()));
	       
	       	Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Processando pagamento");
	        alert.setHeaderText("Seu pagamento está sendo processado.");
	        alert.setContentText("Aguarde...");
	        alert.show();
	        double duracaoAlerta = 3.0;

	        Timeline timeline = new Timeline(
	            new KeyFrame(Duration.seconds(duracaoAlerta), event -> {
	                alert.close();
	                
	                try {
	                	double novoValorTotal = Double.parseDouble(valorTotal.getText());
	                	c.getPedidos().get(c.getPedidos().size() - 1).setValorTotal(novoValorTotal);
	                    pagamento.realizarPagamento(c.getPedidos().get(c.getPedidos().size() - 1), cartao);
	                	Alert alertValidacao = new Alert(Alert.AlertType.INFORMATION);
		     	    	alertValidacao.setTitle("Pagamento com Credito");
		     	    	alertValidacao.setHeaderText("Pagamento realizado com sucesso!");
		     	    	alertValidacao.show();
		     	   
	                }
	     	    	catch (FalhaPagamentoException e) {
	     	    		Alert alertValidacao = new Alert(Alert.AlertType.ERROR);
		     	    	alertValidacao.setTitle("Falha no pagamento");
		     	    	alertValidacao.setHeaderText(e.getMessage());
		     	    	alertValidacao.show();
		     	    	creditoParcelas.setValue("1x (sem juros)");
		     	    	valorTotal.setText(Double.toString(valorInicialDoPedido));
		     	    	valorDaParcela.setText(Double.toString(valorInicialDoPedido));
	     	    	}
	            })
	        );
	        timeline.setCycleCount(1); 
	        timeline.play();
	       
	   }
	   else {
		   double novoValorTotal = Double.parseDouble(valorTotal.getText());
       		c.getPedidos().get(c.getPedidos().size() - 1).setValorTotal(novoValorTotal);
		   PagamentoPix pagCliente = new PagamentoPix(Double.parseDouble(valorTotal.getText()), "12.345.678/0001-23");
		   Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Processando pagamento");
	        alert.setHeaderText("Seu pagamento está sendo processado.");
	        alert.setContentText("Aguarde...");
	        alert.show();
	        double duracaoAlerta = 3.0; 
	        Timeline timeline = new Timeline(
	            new KeyFrame(Duration.seconds(duracaoAlerta), event -> {
	            	alert.close();
	            	try {
	            		pagamento.realizarPagamento(PedidoController.getInstancia().retornarUltimoPedido(c), pagCliente);
	            		Alert alertPix = new Alert(Alert.AlertType.CONFIRMATION);
		     		   	alertPix.setTitle("Pagamento processado");
		     		   	alertPix.setHeaderText("Pagamento realizado com sucesso!");
		     		   	alertPix.show();
	                }
	     	    	catch (FalhaPagamentoException e) {
	     	    		Alert alertValidacao = new Alert(Alert.AlertType.ERROR);
		     	    	alertValidacao.setTitle("Pagamento");
		     	    	alertValidacao.setHeaderText("Erro no pagamento: " + e.getMessage());
		     	    	alertValidacao.show();
		     	    	creditoParcelas.setValue("1x (sem juros)");
		     	    	valorTotal.setText(Double.toString(valorInicialDoPedido));
	     	    	}
	            })
	        );
	        timeline.setCycleCount(1); 
	        timeline.play();
	        
	   }
   }
   
   private boolean cancelarPedidoSimNao() {
   	Alert alert = new Alert(AlertType.WARNING);
   	alert.setTitle("Aviso");
   	alert.setHeaderText("O pedido será cancelado se o pagamento não for realizado.");
   	alert.setContentText("Deseja cancelar o pedido?");

   	alert.getButtonTypes().clear();

   	ButtonType simButton = new ButtonType("Sim");
   	ButtonType naoButton = new ButtonType("Não");
   	alert.getButtonTypes().addAll(simButton, naoButton);
   	
   	Optional<ButtonType> resposta = alert.showAndWait();
   	
   	if (resposta.isPresent() && resposta.get() == simButton) {
   	    return true;
   	} 
		return false;
   }
   
   private double calcularJurosCartao(Pedido pedido, Integer parcela) {
   	double valorComJuros = valorInicialDoPedido;
   	if (parcela == 5) {
   		 valorComJuros = 1.03*valorInicialDoPedido;
   	}
   	else if (parcela == 6) {
   		valorComJuros = 1.045*valorInicialDoPedido;
   	}
   	return valorComJuros;
   }

}
