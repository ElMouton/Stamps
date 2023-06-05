package stamps.vues;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import stamps.Base;
import stamps.Ecouteur.EcouteurPizzas;
import stamps.Pizza;
import stamps.PizzaFolie;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class VueGlobale {
    private PizzaFolie pizzaFolie;
    public int timePassed;

    @FXML
    private GridPane pizzasTomate;
    @FXML
    private GridPane pizzasCreme;
    @FXML
    private ComboBox<Label> choixFiltre;


    public VueGlobale(PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
        this.timePassed = 0;
    }

    public void initialize(){
        this.pizzasTomate.getChildren().clear();
        this.pizzasCreme.getChildren().clear();
        this.choixFiltre.getItems().clear();

        Iterator<Pizza> it = pizzaFolie.pizzaIterator();

        int iTomate = 0, jTomate = 0;
        int iCreme = 0, jCreme = 0;
        while (it.hasNext()){
            Pizza p = it.next();

            ImageView pi = new ImageView(p.getIm());

            pi.setFitWidth(130);
            pi.setFitHeight(130);

            pi.setId(p.getId() + "");
            pi.setOnMouseClicked(new EcouteurPizzas(p, pizzaFolie));
                if(p.getBase() == Base.CREME){
                    pizzasCreme.add(pi, iCreme, jCreme);
                    iCreme++;
                    if(iCreme == 3){
                        iCreme = 0;
                        jCreme++;
                    }

                }else{
                    pizzasTomate.add(pi, iTomate, jTomate);
                    iTomate++;
                    if(iTomate == 3){
                        iTomate = 0;
                        jTomate++;
                    }
                }
        }

        for(String ing : this.pizzaFolie){
            Label name = new Label(ing);
            name.setFont(Font.font("Abyssinica SIL"));
            this.choixFiltre.getItems().add(name);
        }
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

            ImageView pi = new ImageView(p.getIm());

            pi.setFitWidth(130);
            pi.setFitHeight(130);

            pi.setId(p.getId() + "");
            pi.setOnMouseClicked(new EcouteurPizzas(p, pizzaFolie));

            for(String ingFiltre : filtre){
                for(String ing : p){
                    if(ing.equals(ingFiltre)){
                        if(p.getBase() == Base.CREME){
                            pizzasCreme.add(pi, iCreme, jCreme);
                            iCreme++;
                            if(iCreme == 3){
                                iCreme = 0;
                                jCreme++;
                            }

                        }else{
                            pizzasTomate.add(pi, iTomate, jTomate);
                            iTomate++;
                            if(iTomate == 3){
                                iTomate = 0;
                                jTomate++;
                            }
                        }
                    }
                }
            }

            if(filtre.length == 0){
                if(p.getBase() == Base.CREME){
                    pizzasCreme.add(pi, iCreme, jCreme);
                    iCreme++;
                    if(iCreme == 3){
                        iCreme = 0;
                        jCreme++;
                    }

                }else{
                    pizzasTomate.add(pi, iTomate, jTomate);
                    iTomate++;
                    if(iTomate == 3){
                        iTomate = 0;
                        jTomate++;
                    }
                }
            }
        }

        for(String ing : this.pizzaFolie){
            Label name = new Label(ing);
            name.setFont(Font.font("Abyssinica SIL"));
            this.choixFiltre.getItems().add(name);
        }
    }

    @FXML
    void FilterButton(){
        String filtre = this.choixFiltre.getValue().getText();
        if(filtre != null){
            this.reload(filtre);
        }
    }

    @FXML
    void ajoutPizzas(){
        String nom = demandeNom();
        String base = demandeBase();
        File image = demandeImage();

        this.pizzaFolie.ajouterPizzas(new Pizza(nom, Base.valueOf(base.toUpperCase(Locale.ROOT)), image));
        this.reload();
    }

    @FXML
    void reloadButton(){
        this.reload();
    }

    private String demandeNom(){
        AtomicReference<String> nom = new AtomicReference<>();
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Nom de la pizza");
        dialog.setHeaderText("Entrer le nom de la pizza:");
        dialog.setContentText("Nom:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(nom::set);
        return nom.get();
    }

    private String demandeBase(){
        AtomicReference<String> nom = new AtomicReference<>();

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Tomate","Tomate",  "Creme");
        dialog.setTitle("Base de la pizza");
        dialog.setHeaderText("Choisissez la base de la pizza:");
        dialog.setContentText("Base:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(nom::set);
        return nom.get();
    }

    private File demandeImage(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());

        try {
            System.out.println(file.toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return file;
    }
}
