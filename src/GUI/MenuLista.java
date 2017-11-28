/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import logika.Hra;
import logika.IHra;
import logika.Inventar;

/**
 *  Trieda MenuLista sa stará o hornú lištu hlavného menu grafickej verzie adventúry
 * 
 * @author Juraj Szücs
 */
public class MenuLista extends MenuBar {
    
    private IHra hra;
    private Main main;
    private Inventar inventar;
    
    public MenuLista(IHra hra, Main main) {
        this.hra = hra;
        this.main = main;
        init();
    }
    
    /**
     * Metóda inicializuje jednotlivé komponenty lišty hlavného menu
     * 
     */
    
    private void init() {
        Menu novySoubor = new Menu("Adventúra");
        Menu napoveda = new Menu("Help");
        
        MenuItem novaHra = new MenuItem("Nová hra");
        
        novaHra.setAccelerator(KeyCombination.keyCombination("Ctrl + H"));
        
        MenuItem konecHry = new MenuItem("Koniec hry");
        
        novySoubor.getItems().addAll(novaHra, konecHry);
        
        MenuItem oProgramu = new MenuItem("O programe");
        MenuItem napovedaItem = new MenuItem("Napoveda");
        
        napoveda.getItems().addAll(oProgramu, napovedaItem);
        
        this.getMenus().addAll(novySoubor, napoveda);
        
        konecHry.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Metóda ukončí hru po kliknutí na komponentu Koniec hry
             * 
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        novaHra.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Metóda spusti novú hru a nastaví jednotlivé prvky grafického rozhrania po
             * kliknutí na komponentu Nová hra
             * 
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                hra = new Hra();
                inventar = new Inventar();
                main.getMapa().newGame(hra);
                main.getPanelProstory().newGame(hra);
                main.getPanelInventar().newGame(hra);
                main.getPanelVeciVProstoru().newGame(hra);
                main.getPanelZvolProstor().newGame(hra);
                main.getPanelStavZivota().newGame(hra);
                main.getPanelStavPaliva().newGame(hra);
                main.setHra(hra);
                main.getCentralText().setText(hra.vratUvitani());
                main.getZadejPrikazTextField().setEditable(true);
            }
        });
        
        
        
        oProgramu.setOnAction(new EventHandler<ActionEvent>() {
            
            /**
             * Metóda nastaví doplnkové menu hlavnej lišty
             * 
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                Alert oProgramuAlert = new Alert(Alert.AlertType.INFORMATION);
                oProgramuAlert.setTitle("O programe");
                oProgramuAlert.setHeaderText("Adventúra");
                oProgramuAlert.setContentText("Verzia 1.0\nAutor: Juraj Szücs");
                oProgramuAlert.initOwner(main.getStage());
                
                oProgramuAlert.showAndWait();
            }
        });
        
        napovedaItem.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Metóda nastaví a zobrazí nápovedu po kliknutí na komponentu Nápoveda
             * 
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                
                Stage stage = new Stage();
                stage.setTitle("Nápoveda");
                
                WebView webView = new WebView();
                webView.getEngine().load(Main.class.getResource("/zdroje/napoveda.html").toExternalForm());
                stage.setScene(new Scene(webView, 1200, 900));
                stage.show();
            }
        });
        
        
        
    }
}
