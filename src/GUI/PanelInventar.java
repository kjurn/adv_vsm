/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logika.IHra;
import logika.Inventar;
import logika.Vec;
import main.Main;
import util.Observer;

/**
 *
 * Trieda PanelInventar je zodpovedná za zobrazenie panelu s inventárom
 * @author Juraj Szücs
 */
public class PanelInventar extends VBox implements Observer {
    
    public IHra hra;
    private Inventar inventar;
    private Map<String, Vec> veciMap;
    private ImageView obrazokVeci;
    private Main main;
    
    /**
     * Konštruktor triedy PanelInventar
     * 
     * @param hra hra, ktorá sa hrá
     * @param main inštancia main
     */
    
    public PanelInventar(IHra hra, Main main) {
        this.hra = hra;
        this.main = main;
        hra.getHerniPlan().registerObserver(this);
        veciMap = new HashMap<>();
        init();
    }
    
    /**
     * Metóda nastaví nový inventár a odobere a zaregistruje Pozorovateľa pri novom
     * spustení hry 
     * 
     * @param novaHra hra, ktorá sa nastaví ako nová 
     */
    
    public void newGame(IHra novaHra) {
        hra.getHerniPlan().removeObserver(this);
        hra = novaHra;
        hra.getHerniPlan().registerObserver(this);
        update();   
    }
    
    void init() {
        this.setSpacing(6);
        this.setPrefSize(250, 800);
        update();
        hra.getHerniPlan().notifyObservers();
    }
    
    /**
     * Metóda, ktorá zobrazuje tlačidlá z názvom a obrázkom veci, ktorá je v inventári.
     * 
     */

    @Override
    public void update() {
        veciMap = hra.getInventar().getInventarMap();
        this.getChildren().clear();
        this.getChildren().addAll(new Label("Inventár"));
        for (Map.Entry<String, Vec> entry : veciMap.entrySet()) {
        String key = entry.getKey();
        Vec vec = entry.getValue();
        obrazokVeci = new ImageView(new Image(Main.class.getResourceAsStream(vec.getUmiestnenie()), 50, 50, false, true));
        Button button = new Button(vec.getNazevGrafika(), obrazokVeci);
        this.getChildren().add(button);
        button.setOnAction((ActionEvent event) -> {
            main.getCentralText().appendText("\n\n" + hra.zpracujPrikaz("vyhod " + key));
            hra.getHerniPlan().notifyObservers();
        });
       }      
    }
    
}
