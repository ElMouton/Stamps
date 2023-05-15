package stamps.vues;

import javafx.fxml.FXML;
import stamps.Page;
import stamps.PizzaFolie;

public class VueGlobale {
    private PizzaFolie pizzaFolie;
    public VueGlobale(PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
    }

    @FXML
    public void ButtonNosPizzas(){
        pizzaFolie.changementPage(Page.NOSPIZZAS);
    }

    @FXML
    public void ButtonTesPizzas(){
        pizzaFolie.changementPage(Page.TESPIZZAS);
    }
}
