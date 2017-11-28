/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Collection;
import java.util.HashSet;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import logika.IHra;
import logika.Prostor;
import util.Observer;

/**
 * Trieda PaneProstory zobrazuje priestory v grafickej verzii adventúry, do ktorých sa dá ísť z aktuálneho priestore
 *
 * @author Juraj Szücs
 */
public class PanelProstory extends TextArea implements Observer {
    
    private IHra hra;
    private Collection<Prostor> vychody;
    
    public PanelProstory(IHra hra) {
        this.hra = hra;
        vychody = new HashSet<>();
        hra.getHerniPlan().registerObserver(this);
        init();
    }
    
    /**
     * Metóda nastaví základné parametre okna
     * 
     */
    
    public void init() {
        this.setPrefWidth(120);
        this.setEditable(false);
        update();
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
     * Metóda zobrazuje susedné priestory aktuálneho priestoru
     * 
     */

    @Override
    public void update() {
        this.setText("");
        vychody = hra.getHerniPlan().getAktualniProstor().getVychody();
        for (Prostor prostor : vychody) {
            this.appendText(prostor.getNazev() + "\n");
        }
    }
}
