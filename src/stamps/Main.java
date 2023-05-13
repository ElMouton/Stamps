package stamps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stamps.vues.VueGlobale;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        PizzaFolie pizzaFolie = new PizzaFolie();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML/VueGlobale.fxml"));
        loader.setControllerFactory(iC->new VueGlobale(pizzaFolie));
        root.setCenter(loader.load());

        stage.setScene(new Scene(root, 1000, 700));
        stage.setTitle("PizzaFolie");
        stage.show();
    }
}