package stamps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stamps.vues.VueGlobale;
import stamps.vues.VueMenu;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        PizzaFolie pizzaFolie = new PizzaFolie();


        BorderPane root = new BorderPane();

        FXMLLoader loaderGlob = new FXMLLoader();
        loaderGlob.setLocation(getClass().getResource("/FXML/VueGlobale.fxml"));
        loaderGlob.setControllerFactory(iC->new VueGlobale(pizzaFolie));
        root.setCenter(loaderGlob.load());

        FXMLLoader loaderMenu = new FXMLLoader();
        loaderMenu.setLocation(getClass().getResource("/FXML/VueMenu.fxml"));
        loaderMenu.setControllerFactory(iC->new VueMenu(pizzaFolie));
        root.setTop(loaderMenu.load());

        stage.setScene(new Scene(root, 1000, 700));
        stage.setTitle("PizzaFolie");
        stage.show();
    }
}