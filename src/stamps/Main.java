package stamps;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        PizzaFolie pizzaFolie = new PizzaFolie();
        GestionnairePage gestionnairePage = new GestionnairePage(stage, pizzaFolie);

        gestionnairePage.changementPage();
    }
}