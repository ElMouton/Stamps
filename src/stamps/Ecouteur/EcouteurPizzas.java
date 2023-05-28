package stamps.Ecouteur;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stamps.Pizza;
import stamps.PizzaFolie;
import stamps.vues.VueDetail;

import java.io.IOException;

public class EcouteurPizzas implements EventHandler<MouseEvent> {
    private PizzaFolie pizzaFolie;
    private Pizza p;

    public EcouteurPizzas(Pizza p, PizzaFolie pizzaFolie) {
        this.p = p;
        this.pizzaFolie = pizzaFolie;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/VueDetail.fxml"));
        loader.setControllerFactory(iC->new VueDetail(p, pizzaFolie));
        try {
            root.setCenter(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("PizzaFolie");
        stage.show();
    }
}
