package stamps;

import java.util.ArrayList;

public class Pizza {
    private String nom;
    private Base base;
    private ArrayList<String> ingredients;

    public Pizza(String nom) {
        this.nom = nom;
    }

    public void choixBase(Base base){
        this.base = base;
    }

    public void choixIngredient(String... ingredient){
        for (int i = 0; i < ingredient.length; i++) {
            this.ingredients.add(ingredient[i]);
        }
    }
}
