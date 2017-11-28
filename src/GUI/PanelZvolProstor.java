/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Collection;
import java.util.HashSet;
import javafx.scene.control.ComboBox;
import logika.IHra;
import logika.Prostor;
import util.Observer;

/**
 * Trieda PanelZvolProstor umožňuje presunutie sa z aktuálneho priestoru
 * do susedného
 * @author Juraj Szücs
 */
public class PanelZvolProstor extends ComboBox<String> implements Observer {
    
    private IHra hra;
    private Collection<Prostor> vychody;
    
    /**
     *  Konštruktor PanelZvolProstor vytvára panel so zvoliteľnými priestormi
     * a inicializuje hru, main a registruje pozorovateľa
     * 
     * @param hra hra, ktorá sa nastaví ako nová
     */
    public PanelZvolProstor(IHra hra) {
        this.hra = hra;
        vychody = new HashSet<>();
        hra.getHerniPlan().registerObserver(this);
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
        init();
    }
    
    void init() {
        update();
    }
    
    /**
     * Metóda priradí do grafického prvku jednotlivé priestory.
     * 
     */

    @Override
    public void update() {
        
        vychody = hra.getHerniPlan().getAktualniProstor().getVychody();
        
        this.getItems().clear();
        for (Prostor prostor : vychody) {
            this.getItems().add(prostor.getNazev());
        }
    }
}
