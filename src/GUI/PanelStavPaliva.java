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
 * Trieda @code PanelStavPaliva zobrazuje stav paliva
 * @author Juraj Szücs
 */
public class PanelStavPaliva extends HBox implements Observer {
    private IHra hra;
    private Main main;
    private Button tankujButton;
    private TextField zobrazPalivo;
    private Label palivoLabel;
    
    /**
     * Konštruktor triedy PanelStavZivota inicializuje hru a main a grafické prvky
     * 
     * @param hra hra, ktorá sa hrá 
     * @param main inštancia mainu
     */
    
    public PanelStavPaliva(IHra hra, Main main) {
        this.hra = hra;
        this.main = main;
        hra.getHerniPlan().registerObserver(this);
        tankujButton = new Button("Tankuj");
        zobrazPalivo = new TextField();
        palivoLabel = new Label("Palivo");
        init();
    }
    
        /**
     * Metóda odobere a zaregistruje Pozorovateľa pri novom
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
        this.setSpacing(5);
        this.setPadding(new Insets(8, 0, 0, 0));
        zobrazPalivo.setEditable(false);
        zobrazPalivo.setPrefWidth(50);
        palivoLabel.setPadding(new Insets(5, 0, 0, 2));
        palivoLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        this.getChildren().addAll(palivoLabel, zobrazPalivo, tankujButton);
        tankujButton.setOnAction((ActionEvent event) -> {
                    main.getCentralText().appendText("\n\n" + hra.zpracujPrikaz("tankuj"));
                    hra.getHerniPlan().notifyObservers();
        });
        update();
    }
    /**
     * Metóda update sa stará o zobrazovanie aktuálneho paliva v grafickom prvku a 
     * o grafické efekty.
     * 
     */
    @Override
    public void update() {
        int palivo = hra.getVesmirnaLod().getPalivoLode();
        if (hra.getInventar().jeVInventari("palivo")) {
            tankujButton.setStyle("-fx-background-color: #82BBCE;");
        } else {
            tankujButton.setStyle("");
        }
        if (palivo <= 20) {
            zobrazPalivo.setStyle("-fx-background-color: red;");
        } else {
            zobrazPalivo.setStyle("");
        }
        zobrazPalivo.setText("");
        zobrazPalivo.appendText("" + palivo);
    }
}
