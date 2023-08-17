package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField usuarioInput;
    @FXML
    private PasswordField senhaInput;

    @FXML
    public void confirmarLogin(ActionEvent event) {
        String username = usuarioInput.getText();
        String password = senhaInput.getText();
        
        if (validarCredenciais(username, password)) {
            System.out.println("Login bem-sucedido!");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Credenciais Invalidas");
            alert.setHeaderText("Credenciais invalidas. Tente novamente!");

            alert.showAndWait();
        }
    }

    @FXML
    public void cadastrarAcionado(ActionEvent event) {

    }

    private boolean validarCredenciais(String username, String password) {

        return username.equals("usuario") && password.equals("senha");
    }
}
