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

    @FXML
    private GridPane PizzasTomate;
    @FXML
    private GridPane PizzasCreme;
    @FXML
    private ChoiceBox<String> choixFiltre;

    public VueNosPizzas(PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
    }

    private void reload(String... filtre){
        this.PizzasTomate.getChildren().clear();
        this.PizzasCreme.getChildren().clear();
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
                            PizzasCreme.add(new Label(p.toString()), iCreme, jCreme);

                            iCreme++;
                            if(iCreme == 2){
                                iCreme = 0;
                                jCreme++;
                            }

                        }else{
                            PizzasTomate.add(new Label(p.toString()), iTomate, jTomate);

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
                    PizzasCreme.add(new Label(p.toString()), iCreme, jCreme);

                    iCreme++;
                    if(iCreme == 2){
                        iCreme = 0;
                        jCreme++;
                    }

                }else{
                    PizzasTomate.add(new Label(p.toString()), iTomate, jTomate);

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
    void ReloadButton(){
        this.reload();
    }
}
