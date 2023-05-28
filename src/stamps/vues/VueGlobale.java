package stamps.vues;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import stamps.Base;
import stamps.Ecouteur.EcouteurPizzas;
import stamps.Pizza;
import stamps.PizzaFolie;

import java.util.Iterator;

public class VueGlobale {
    private PizzaFolie pizzaFolie;
    public int timePassed;

    @FXML
    private GridPane pizzasTomate;
    @FXML
    private GridPane pizzasCreme;
    @FXML
    private ChoiceBox<String> choixFiltre;


    public VueGlobale(PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
        this.timePassed = 0;
    }

    private void reload(String... filtre){
        this.pizzasTomate.getChildren().clear();
        this.pizzasCreme.getChildren().clear();
        this.choixFiltre.getItems().clear();

        Iterator<Pizza> it = pizzaFolie.pizzaIterator();

        int iTomate = 0, jTomate = 0;
        int iCreme = 0, jCreme = 0;
        while (it.hasNext()){
            Pizza p = it.next();

            Label name = new Label(p.toString());
            name.setId(p.getId() + "");
            name.setOnMouseClicked(new EcouteurPizzas(p, pizzaFolie));

            for(String ingFiltre : filtre){
                for(String ing : p){
                    if(ing.equals(ingFiltre)){
                        if(p.getBase() == Base.CREME){
                            pizzasCreme.add(name, iCreme, jCreme);
                            iCreme++;
                            if(iCreme == 2){
                                iCreme = 0;
                                jCreme++;
                            }

                        }else{
                            pizzasTomate.add(name, iTomate, jTomate);
                            iTomate++;
                            if(iTomate == 2){
                                iTomate = 0;
                                jTomate++;
                            }
                        }
                    }
                }
            }

            if(filtre.length == 0){
                if(p.getBase() == Base.CREME){
                    pizzasCreme.add(name, iCreme, jCreme);
                    iCreme++;
                    if(iCreme == 2){
                        iCreme = 0;
                        jCreme++;
                    }

                }else{
                    pizzasTomate.add(name, iTomate, jTomate);
                    iTomate++;
                    if(iTomate == 2){
                        iTomate = 0;
                        jTomate++;
                    }
                }
            }
        }

        for(String ing : this.pizzaFolie){
            this.choixFiltre.getItems().add(ing);
        }
    }

    @FXML
    void FilterButton(){
        String filtre = this.choixFiltre.getValue();
        this.reload(filtre);
    }

    @FXML
    void ajoutPizzas(){
        this.pizzaFolie.ajouterPizzas(new Pizza("Ajout", Base.CREME, "hehe"));
        this.reload();
    }

    @FXML
    void mouseEntered(){
        if(timePassed == 0){
            this.reload();
            timePassed++;
        }
    }

    @FXML
    void reloadButton(){
        this.reload();
    }
}
