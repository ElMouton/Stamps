package stamps.vues;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import stamps.Pizza;
import stamps.PizzaFolie;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Iterator;

public class VueMenu {
    private PizzaFolie pizzaFolie;
    public VueMenu(PizzaFolie pizzaFolie) {
        this.pizzaFolie = pizzaFolie;
    }

    @FXML
    public void quitter(){
        Platform.exit();
    }

    @FXML
    public void sauvegarder(){
        JSONObject save = new JSONObject();

        Iterator<Pizza> it = pizzaFolie.pizzaIterator();
        while (it.hasNext()){
            Pizza p = it.next();
            System.out.println(p);

            save.put("Nom" + p.getId(), p.getNom());
            save.put("Id" + p.getId(), p.getId());
            save.put("Base" + p.getId(), p.getBase());
            save.put("ing" + p.getId(), p.getIngredients());
            save.put("image" + p.getId(), p.getIm().getUrl());
        }
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Json file (*.json", "*.json");
        fileChooser.getExtensionFilters().add(extensionFilter);

        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            if (!file.getPath().endsWith(".json")) file = new File(file.getPath() + ".json");
            try (FileWriter fichier = new FileWriter(file)) {
                fichier.write(save.toJSONString());
                fichier.flush();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }

    @FXML
    public void importer() throws IOException, ParseException {
        /*JSONParser jsonP = new JSONParser();

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());

        try {
            System.out.println(file.toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        JSONObject importer = (JSONObject) jsonP.parse(new FileReader(file));
        String name = (String) importer.get("Nom" + 1);*/
    }
}
