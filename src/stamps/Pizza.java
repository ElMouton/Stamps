package stamps;

import java.util.ArrayList;

public class Pizza {
    private String nom;
    private Base base;
    private ArrayList<String> ingredients;

    public Pizza(String nom) {
        this.nom = nom;
    }
    public Pizza(String nom, Base base) {
        this.nom = nom;
        this.base = base;
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

    @Override
    public String toString() {
        return this.nom;
    }
}
