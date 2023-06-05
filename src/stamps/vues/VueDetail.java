package stamps.vues;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import stamps.Ecouteur.EcouteurIngredient;
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
    private ListView<Label> ingredientList;
    @FXML
    private BorderPane borderScene;

    public VueDetail(Pizza p, PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
        this.p = p;
    }

    public void initialize(){
        pizzaName.setText(p.getNom());
        pizzaBase.setText("Base : " + p.getBase());

        ingredientList.getItems().clear();
        for(String ingredient : p){
            Label l = new Label(ingredient);
            l.setOnMouseClicked(mouseEvent -> {
                new EcouteurIngredient(pizzaFolie, p);
                this.reload();
            });
            ingredientList.getItems().add(l);
        }
        this.pizzaImage.setImage(p.getIm());
    }

    private void reloadPage(){
        ingredientList.getItems().clear();
        for(String ingredient : p){
            Label l = new Label(ingredient);
            l.setOnMouseClicked(new EcouteurIngredient(pizzaFolie, p));
            ingredientList.getItems().add(l);
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
        reloadPage();
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
        reloadPage();
    }

    @FXML
    void reload(){
        reloadPage();
    }
}
