/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logika.IHra;
import main.Main;
import util.Observer;

/**
 * Trieda @code PanelStavZivota zobrazuje stav života
 * @author Juraj Szücs
 */
public class PanelStavZivota extends HBox implements Observer {
    
    private IHra hra;
    private Main main;
    private Button opravButton;
    private TextField zobrazZivot;
    private Label zivotLabel;
    
    /**
     * Konštruktor triedy PanelStavZivota inicializuje hru a main a grafické prvky
     * 
     * @param hra hra, ktorá sa hrá 
     * @param main inštancia mainu
     */
    
    public PanelStavZivota(IHra hra, Main main) {
        this.hra = hra;
        this.main = main;
        hra.getHerniPlan().registerObserver(this);
        opravButton = new Button("Oprav");
        zobrazZivot = new TextField();
        zivotLabel = new Label("Život");
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
    
    /**
     * Metóda @code init nastavuje grafické prvky.
     * 
     */
    void init() {
        this.setSpacing(10);
        this.setPadding(new Insets(8, 0, 0, 0));
        zobrazZivot.setEditable(false);
        zobrazZivot.setPrefWidth(50);
        zivotLabel.setPadding(new Insets(5, 0, 0, 3));
        zivotLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        this.getChildren().addAll(zivotLabel, zobrazZivot, opravButton);
        opravButton.setOnAction((ActionEvent event) -> {
                    main.getCentralText().appendText("\n\n" + hra.zpracujPrikaz("oprav"));
                    hra.getHerniPlan().notifyObservers();
        });
        update();
    }
    /**
     * Metóda update sa stará o zobrazovanie aktuálneho života v grafickom prvku a 
     * o grafické efekty.
     * 
     */
    @Override
    public void update() {
        int zivot = hra.getVesmirnaLod().getZivotLode();
        if (hra.getInventar().jeVInventari("opravny_balik")) {
            opravButton.setStyle("-fx-background-color: #82BBCE;");
        } else {
            opravButton.setStyle("");
        }
        if (zivot <= 20) {
            zobrazZivot.setStyle("-fx-background-color: red;");
        } else {
            zobrazZivot.setStyle("");
        }
        zobrazZivot.setText("");
        zobrazZivot.appendText("" + zivot);
    }
}
