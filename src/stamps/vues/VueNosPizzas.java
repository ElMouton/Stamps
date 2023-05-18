package stamps.vues;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import stamps.Base;
import stamps.Page;
import stamps.Pizza;
import stamps.PizzaFolie;

import java.util.Iterator;

public class VueNosPizzas {
    private PizzaFolie pizzaFolie;
    public int timePassed;

    @FXML
    private GridPane pizzasTomate;
    @FXML
    private GridPane pizzasCreme;
    @FXML
    private ChoiceBox<String> choixFiltre;


    public VueNosPizzas(PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
        this.timePassed = 0;
    }

    private void reload(String... filtre){
        this.pizzasTomate.getChildren().clear();
        this.pizzasCreme.getChildren().clear();
        this.choixFiltre.getItems().clear();

        Iterator<Pizza> it = pizzaFolie.nosPizzas();

        int iTomate = 0, jTomate = 0;
        int iCreme = 0, jCreme = 0;
        while (it.hasNext()){
            Pizza p = it.next();

            for(String ingFiltre : filtre){
                for(String ing : p){
                    if(ing.equals(ingFiltre)){
                        if(p.getBase() == Base.CREME){
                            pizzasCreme.add(new Label(p.toString()), iCreme, jCreme);

                            iCreme++;
                            if(iCreme == 2){
                                iCreme = 0;
                                jCreme++;
                            }

                        }else{
                            pizzasTomate.add(new Label(p.toString()), iTomate, jTomate);

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
                    pizzasCreme.add(new Label(p.toString()), iCreme, jCreme);

                    iCreme++;
                    if(iCreme == 2){
                        iCreme = 0;
                        jCreme++;
                    }

                }else{
                    pizzasTomate.add(new Label(p.toString()), iTomate, jTomate);

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
    void ReturnButton(){
        pizzaFolie.changementPage(Page.GLOBALE);
    }

    @FXML
    void mouseEntered(){
        if(timePassed == 0){
            this.reload();
            timePassed++;
        }
    }
}
