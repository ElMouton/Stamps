package stamps;

import java.util.ArrayList;
import java.util.Iterator;

public class PizzaFolie implements Iterable<String>{
    private ArrayList<Pizza> pizzas;
    private ArrayList<String> ingredients;

    public PizzaFolie() {
        this.pizzas = new ArrayList<>();
        this.ingredients = new ArrayList<>();

        this.ajoutNosPizzas();
    }

    public void ajouterPizzas(Pizza p){
        this.pizzas.add(p);
    }

    public void retirerPizzas(Pizza p){
        this.pizzas.remove(p);
    }

    public void ajoutNosPizzas(){
        Pizza p1 = new Pizza("3 Fromages", Base.CREME, "image/pizzas/3From.png", "mozzarella", "oignon", "emmental", "roquefort");
        Pizza p2 = new Pizza( "Saumon", Base.CREME, "image/pizzas/saumon.png", "saumon", "ciboulette", "mozzarella");
        Pizza p4 = new Pizza( "Chèvre miel", Base.CREME, "image/pizzas/chevreMiel.png", "gruyère", "chèvre", "miel");
        Pizza p3 = new Pizza( "Chorizo", Base.TOMATE, "image/pizzas/chorizo.png", "chorizo", "oignon", "gruyère");
        Pizza p5 = new Pizza( "Texane", Base.TOMATE, "image/pizzas/texane.png", "boeuf", "bacon", "oignon", "gruyère");

        this.pizzas.add(p1);
        this.pizzas.add(p2);
        this.pizzas.add(p3);
        this.pizzas.add(p4);
        this.pizzas.add(p5);

        for(Pizza p : this.pizzas){
            for(String ingFolie : p){
                boolean ingTrouve = false;
                for(String ingPizza : this.ingredients){
                    if (ingPizza.equals(ingFolie)) {
                        ingTrouve = true;
                        break;
                    }
                }
                if(!ingTrouve){
                    this.ingredients.add(ingFolie);
                }
            }
        }
    }

    public Iterator<Pizza> pizzaIterator(){
        return this.pizzas.iterator();
    }

    @Override
    public Iterator<String> iterator() {
        return this.ingredients.iterator();
    }
}
