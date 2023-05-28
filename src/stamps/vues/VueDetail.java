package stamps.vues;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import stamps.Pizza;
import stamps.PizzaFolie;

public class VueDetail {
    private PizzaFolie pizzaFolie;
    private Pizza p;

    private Stage stage;

    @FXML
    private Label pizzaName;
    @FXML
    private ImageView pizzaImage;
    @FXML
    private Label pizzaBase;
    @FXML
    private VBox ingredientList;
    @FXML
    private BorderPane borderScene;

    public VueDetail(Pizza p, PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
        this.p = p;
    }

    @FXML
    void suppPizza(){
        stage = (Stage) borderScene.getScene().getWindow();
        this.pizzaFolie.retirerPizzas(this.p);

        stage.close();
    }

    @FXML
    public void mvmtMouse(){
        pizzaName.setText(p.getNom());
        pizzaBase.setText("Base : " + p.getBase());

        ingredientList.getChildren().clear();
        for(String ingredient : p){
            ingredientList.getChildren().add(new Label("- " + ingredient));
        }
    }

}
