package stamps.Ecouteur;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import stamps.Pizza;
import stamps.PizzaFolie;

public class EcouteurIngredient implements EventHandler<MouseEvent> {
    private PizzaFolie pizzaFolie;
    private Pizza p;

    public EcouteurIngredient(PizzaFolie pizzaFolie, Pizza p) {
        this.pizzaFolie = pizzaFolie;
        this.p = p;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getTarget());
        String res = mouseEvent.getTarget().toString();

        String[] sep = res.split("\"");
        System.out.println(sep[1]);
        p.enleverIngredient(sep[1]);
    }
}
