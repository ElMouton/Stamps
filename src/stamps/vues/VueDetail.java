package stamps.vues;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import stamps.Pizza;
import stamps.PizzaFolie;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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

    public void initialize(){
        pizzaName.setText(p.getNom());
        pizzaBase.setText("Base : " + p.getBase());

        ingredientList.getChildren().clear();
        for(String ingredient : p){
            ingredientList.getChildren().add(new Label("- " + ingredient));
        }
        this.pizzaImage.setImage(p.getIm());
    }

    private void reload(){
        ingredientList.getChildren().clear();
        for(String ingredient : p){
            ingredientList.getChildren().add(new Label("- " + ingredient));
        }
    }

    @FXML
    void suppPizza(){
        stage = (Stage) borderScene.getScene().getWindow();
        this.pizzaFolie.retirerPizzas(this.p);

        stage.close();
    }

    @FXML
    void ajoutIng(){
        AtomicReference<String> nom = new AtomicReference<>();

        ChoiceDialog<String> dialog = new ChoiceDialog<>(pizzaFolie.premIng(), pizzaFolie.getIngredients());
        dialog.setTitle("Ajout d'un ingrédient");
        dialog.setHeaderText("Choisissez le nouvel ingrédient:");
        dialog.setContentText("Ingrédient:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(nom::set);
        p.choixIngredient(nom.get());
        reload();
    }

    @FXML
    void ajoutAutreIng(){
        AtomicReference<String> nom = new AtomicReference<>();

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ajout d'un ingrédient");
        dialog.setHeaderText("Choisissez le nouvel ingrédient:");
        dialog.setContentText("Ingrédient:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(nom::set);
        p.choixIngredient(nom.get());
        pizzaFolie.ajouterIngredient(nom.get());
        reload();
    }
}
