package stamps.vues;

import javafx.fxml.FXML;
import stamps.PizzaFolie;

public class VueGlobale {
    private PizzaFolie pizzaFolie;
    public VueGlobale(PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
    }

    @FXML
    public void ButtonNosPizzas(){
        System.out.println("Nos Pizzas");
    }

    @FXML
    public void ButtonTesPizzas(){
        System.out.println("Tes Pizzas");
    }
}
