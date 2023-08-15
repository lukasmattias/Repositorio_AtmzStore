package gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;
    @FXML
    public void loginButtonClicked(MouseEvent mouseEvent) {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        
        if (isValidCredentials(username, password)) {
            System.out.println("Login bem-sucedido!");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Credenciais Invalidas");
            alert.setHeaderText("Credenciais invalidas. Tente novamente!");

            alert.showAndWait();
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals("usuario") && password.equals("senha");
    }
}
