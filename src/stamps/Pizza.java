package stamps;

import stamps.outils.GestionnaireIdentifiants;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizza implements Iterable<String>{
    private String nom;
    private int id;
    private Base base;
    private ArrayList<String> ingredients;

    public Pizza(String nom) {
        this.nom = nom;
    }
    public Pizza(String nom, Base base, String... ing) {
        this.id = GestionnaireIdentifiants.getInstance().getIdPizzas();
        this.nom = nom;
        this.base = base;
        this.ingredients = new ArrayList<>();

        for(int i = 0; i < ing.length; i++){
            this.ingredients.add(ing[i]);
        }
    }

    public void choixBase(Base base){
        this.base = base;
    }

    public Base getBase(){
        return this.base;
    }

    public void choixIngredient(String... ingredient){
        for (int i = 0; i < ingredient.length; i++) {
            this.ingredients.add(ingredient[i]);
        }
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }

    @Override
    public Iterator<String> iterator() {
        return this.ingredients.iterator();
    }
}
