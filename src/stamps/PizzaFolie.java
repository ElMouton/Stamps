package stamps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PizzaFolie {
    private ArrayList<Pizza> nosPizzas;
    private ArrayList<Pizza> vosPizzas;
    private ArrayList<String> ingredients;
    private GestionnairePage gePage;

    private Page page;

    public PizzaFolie() {
        this.nosPizzas = new ArrayList<>();
        this.vosPizzas = new ArrayList<>();
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
        Pizza p1 = new Pizza("Je sais pas", Base.CREME);
        Pizza p2 = new Pizza("Oui", Base.CREME);
        Pizza p3 = new Pizza("Non", Base.TOMATE);
        Pizza p4 = new Pizza("Peut", Base.CREME);
        Pizza p5 = new Pizza("etre", Base.TOMATE);

        this.nosPizzas.add(p1);
        this.nosPizzas.add(p2);
        this.nosPizzas.add(p3);
        this.nosPizzas.add(p4);
        this.nosPizzas.add(p5);
    }

    public Page pageActuelle(){
        return this.page;
    }

    public void changementPage(Page page){
        this.page = page;
        try {
            gePage.changementPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterator<Pizza> nosPizzas(){
        return this.nosPizzas.iterator();
    }
}
