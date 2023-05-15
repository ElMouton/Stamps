package stamps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PizzaFolie implements Iterable<String>{
    private ArrayList<Pizza> nosPizzas;
    private ArrayList<Pizza> vosPizzas;
    private ArrayList<String> ingredients;
    private GestionnairePage gePage;

    private Page page;

    public PizzaFolie() {
        this.nosPizzas = new ArrayList<>();
        this.vosPizzas = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.page = Page.GLOBALE;

        this.ajoutNosPizzas();
    }

    public void setGestionnaire(GestionnairePage gest){
        this.gePage = gest;
    }

    public void ajouterVosPizzas(Pizza p){
        this.vosPizzas.add(p);
    }

    public void retirerVosPizzas(Pizza p){
        this.vosPizzas.remove(p);
    }

    public void ajoutNosPizzas(){
        Pizza p1 = new Pizza("3 Fromages", Base.CREME, "mozzarella", "oignon", "emmental", "roquefort");
        Pizza p2 = new Pizza("Saumon", Base.CREME, "saumon", "ciboulette", "mozzarella");
        Pizza p4 = new Pizza("Chèvre miel", Base.CREME, "gruyère", "chévre", "miel");
        Pizza p3 = new Pizza("Chorizo", Base.TOMATE, "chorizo", "oignon", "gruyère");
        Pizza p5 = new Pizza("Texane", Base.TOMATE, "boeuf", "bacon", "oignon", "gruyère");

        this.nosPizzas.add(p1);
        this.nosPizzas.add(p2);
        this.nosPizzas.add(p3);
        this.nosPizzas.add(p4);
        this.nosPizzas.add(p5);

        for(Pizza p : this.nosPizzas){
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

    public Page pageActuelle(){
        return this.page;
    }

    public void changementPage(Page page){
        this.page = page;
        try {
            System.out.println(this.ingredients);
            gePage.changementPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterator<Pizza> nosPizzas(){
        return this.nosPizzas.iterator();
    }
    public Iterator<Pizza> vosPizzas(){
        return this.vosPizzas.iterator();
    }

    @Override
    public Iterator<String> iterator() {
        return this.ingredients.iterator();
    }
}
