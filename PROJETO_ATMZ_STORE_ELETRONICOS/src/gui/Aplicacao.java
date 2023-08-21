package gui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class Aplicacao extends Application {

   @Override
   public void start(Stage stage) throws IOException {
       Parent fxmlLoader = FXMLLoader.load(Aplicacao.class.getResource("Login.fxml"));
       Scene scene = new Scene(fxmlLoader);
       stage.setTitle("ATMZ STORE");
       stage.setScene(scene);
       stage.show();
   }

    public static void main(String[] args) {
        launch();
    }

}


