package gui;

import java.io.IOException;
import java.util.Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import negocio.beans.CartaoDeCredito;

public class PagamentoController {

    //atributos Pix

    @FXML
    private AnchorPane TelaPIX;

    @FXML
    private Label lblChavePix;


    @FXML
    private TextField txtPixChave;

    //Atributos credito

    @FXML
    private GridPane TelaCredito;

    @FXML
    private TextField creditoCVV;

    @FXML
    private TextField creditoNomeTitular;

    @FXML
    private TextField creditoNumCartao;

    @FXML
    private TextField creditoParcelas;

    @FXML
    private DatePicker creditoValidade;

    
    
    //Atributos Pagamento
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
    void telaCredito(ActionEvent event) throws IOException{       
        TelaCredito.setVisible(true);
        TelaPIX.setVisible(false);
    }

    @FXML
    void telaPix(ActionEvent event) throws IOException {
       
        TelaCredito.setVisible(false);
        TelaPIX.setVisible(true);
    }

    @FXML
    void voltarCarrinho(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Carrinho.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("ATMZ STORE");
        stage.setScene(scene);
        stage.show();
    }
   

    @FXML
    public boolean codigoPix(){
        int randomNumber = (int) (Math.random() *9000000) + 10000000;
        if (lblChavePix != null) {
            lblChavePix.setText("" + randomNumber);
            if (lblChavePix.getText().equals(txtPixChave.getText())){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

   @FXML
    public void confirmarCompra(ActionEvent event) throws IOException {
	   negocio.PagamentoController pagamento = negocio.PagamentoController.getInstancia();
       LocalDate cartaoValidade = creditoValidade.getValue();
       CartaoDeCredito cartao = new CartaoDeCredito(Integer.parseInt(creditoParcelas.getText()),
               creditoNumCartao.getText(), creditoCVV.getText(), creditoNomeTitular.getText(), cartaoValidade,
               Float.parseFloat(PagamentoSubTotal.getText()));
       System.out.println(cartao);
       
        boolean auxPix = codigoPix();
        boolean auxCred = pagamento.verificarAtributosCartao(cartao);
        //event.getSource().equals(btnConfirmarPedido);

        if (auxPix && !auxCred) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento Com Pix");
            alert.setHeaderText("Pagamento realizado com sucesso!");
            alert.showAndWait();
        }
        if (auxCred && !auxPix) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento com Credito");
            alert.setHeaderText("Pagamento realizado com sucesso!");
            alert.showAndWait();
        }
        if ((auxCred == false) && (auxPix == false)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento");
            alert.setHeaderText("Erro no pagamento!");
            alert.showAndWait();
        }
    }

}
