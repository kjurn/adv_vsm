/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import main.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logika.IHra;
import util.Observer;

/**
 * Trieda Mapa sa stará o zobrazenie mapy priestorov
 * @author Juraj Szücs
 */
public class Mapa extends AnchorPane implements Observer {
    
    public IHra hra;
    private ImageView raketa;
    
    public Mapa(IHra hra) {
        this.hra = hra;
        hra.getHerniPlan().registerObserver(this);
        init();
    }
    
    /**
     * Metóda init inicializuje obrázok mapy a obrázok kozmickej lode
     * 
     */
    
    private void init() {
        ImageView obrazekImageView = new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/plan.png"), 427, 320, false, true));
        raketa = new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/spaceship.png"), 30, 30, false, true));
        
        this.getChildren().addAll(obrazekImageView, raketa);
        update();
    }
    
    /**
     * Metóda nastavuje a zmaže Observera a slúži na spustenie novej inštancie hry
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
     * Metóda nastavuje pozíciu kozmickej lode vzhľadom na mapu
     * 
     */

    @Override
    public void update() {
       this.setTopAnchor(raketa, hra.getHerniPlan().getAktualniProstor().getPosTop());
       this.setLeftAnchor(raketa, hra.getHerniPlan().getAktualniProstor().getPosLeft());
    }
}
