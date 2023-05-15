package stamps;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stamps.vues.VueGlobale;
import stamps.vues.VueNosPizzas;

import java.io.IOException;

public class GestionnairePage {
    private PizzaFolie pizzaFolie;
    private Stage stage;

    public GestionnairePage(Stage stage, PizzaFolie pizzaFolie) {
        this.stage = stage;
        this.pizzaFolie = pizzaFolie;
        this.pizzaFolie.setGestionnaire(this);
    }

    public void changementPage() throws IOException {
        BorderPane root = new BorderPane();
        FXMLLoader loader = new FXMLLoader();

        switch (pizzaFolie.pageActuelle()){
            case GLOBALE:
                loader.setLocation(getClass().getResource("/FXML/VueGlobale.fxml"));
                loader.setControllerFactory(iC->new VueGlobale(pizzaFolie));
                break;

            case NOSPIZZAS:
                loader.setLocation(getClass().getResource("/FXML/VueNosPizzas.fxml"));
                loader.setControllerFactory(iC->new VueNosPizzas(pizzaFolie));
                break;

            case TESPIZZAS:
                loader.setLocation(getClass().getResource("/FXML/VueVosPizzas.fxml"));
                loader.setControllerFactory(iC->new VueGlobale(pizzaFolie));
                break;

            case DETAIL:
                loader.setLocation(getClass().getResource("/FXML/VueDetail.fxml"));
                loader.setControllerFactory(iC->new VueGlobale(pizzaFolie));
                break;
        }


        root.setCenter(loader.load());

        stage.setScene(new Scene(root, 1000, 700));
        stage.setTitle("PizzaFolie");
        stage.show();
    }
}
