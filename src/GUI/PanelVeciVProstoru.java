/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logika.IHra;
import logika.Vec;
import main.Main;
import util.Observer;

/**
 * Trieda PanelVeciVProstoru zobrazuje v grafickej verzii adventúry veci, ktoré sa nachádzajú v aktuálnom priestore
 * @author Juraj Szücs
 */
public class PanelVeciVProstoru extends VBox implements Observer {
    
    public IHra hra;
    private Main main;
    private Map<String, Vec> veciMap;
    private ImageView obrazokVeci;
    
    public PanelVeciVProstoru(IHra hra, Main main) {
        this.hra = hra;
        this.main = main;
        veciMap = new HashMap<>();
        hra.getHerniPlan().registerObserver(this);
        init();
    }
    
    private void init() {
        
        this.setPrefSize(250, 800);
        this.setSpacing(6);
        update();
        hra.getHerniPlan().notifyObservers();
    }
    
    /**
     * Metóda nastaví novú hru inventár a odobere a zaregistruje Pozorovateľa pri novom
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
    
    /**
     * Metóda priraďuje tlačidlám názov a obrázok veci, ktorá sa nachádza v aktuálnom priestore
     * a umožňuje ich vložiť do inventára.
     * 
     * 
     */

    @Override
    public void update() {
        veciMap = hra.getHerniPlan().getAktualniProstor().getVeci();
        this.getChildren().clear();
        this.getChildren().add(new Label("Veci v priestore"));
        for (Map.Entry<String, Vec> entry : veciMap.entrySet()) {
            String key = entry.getKey();
            Vec vec = entry.getValue();
            obrazokVeci = new ImageView(new Image(Main.class.getResourceAsStream(vec.getUmiestnenie()), 50, 50, false, true));
            Button button = new Button(vec.getNazevGrafika(), obrazokVeci);
            this.getChildren().add(button);
            button.setOnAction((ActionEvent event) -> {
                    main.getCentralText().appendText("\n\n" + hra.zpracujPrikaz("vloz " + key));
                    hra.getHerniPlan().notifyObservers();
                    if (vec.isPrenositelna()) {
                        this.getChildren().remove(button);
                    }
            });
        }
    }
    
}
