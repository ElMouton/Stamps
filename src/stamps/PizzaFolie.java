package stamps;

import java.util.ArrayList;

public class PizzaFolie {
    private ArrayList<Pizza> nosPizzas;
    private ArrayList<Pizza> vosPizzas;
    private ArrayList<String> ingredients;

    private int page;

    public PizzaFolie() {
        this.nosPizzas = new ArrayList<>();
        this.vosPizzas = new ArrayList<>();
        this.page = 0;
    }

    public void ajouterVosPizzas(Pizza p){
        this.vosPizzas.add(p);
    }

    public void retirerVosPizzas(Pizza p){
        this.vosPizzas.remove(p);
    }
}
