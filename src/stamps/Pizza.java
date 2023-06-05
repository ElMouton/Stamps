package stamps;

import javafx.scene.image.Image;
import stamps.outils.GestionnaireIdentifiants;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Pizza implements Iterable<String>{
    private String nom;
    private int id;
    private Base base;
    private ArrayList<String> ingredients;
    private Image im;

    public Pizza(String nom) {
        this.nom = nom;
    }
    public Pizza(String nom, Base base, String im, String... ing) {
        this.id = GestionnaireIdentifiants.getInstance().getIdPizzas();
        this.nom = nom;
        this.base = base;
        this.ingredients = new ArrayList<>();

        this.im = new Image(im);

        for(int i = 0; i < ing.length; i++){
            this.ingredients.add(ing[i]);
        }
    }

    public Pizza(String nom, Base base, File im) {
        this.id = GestionnaireIdentifiants.getInstance().getIdPizzas();
        this.nom = nom;
        this.base = base;
        this.ingredients = new ArrayList<>();
        System.out.println(im);
        try {
            this.im = new Image(im.toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
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

    public Image getIm() {
        return im;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
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
