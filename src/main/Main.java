/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.Mapa;
import GUI.MenuLista;
import GUI.PanelInventar;
import GUI.PanelProstory;
import GUI.PanelStavPaliva;
import GUI.PanelStavZivota;
import GUI.PanelVeciVProstoru;
import GUI.PanelZvolProstor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logika.Hra;
import logika.IHra;
import uiText.TextoveRozhrani;

/**
 * Trieda Main je hlavná trieda grafického prostredia adventúry
 *
 * @author Juraj Szücs
 */
public class Main extends Application {
    
    private TextArea centralText;
    private IHra hra;
    private TextField zadejPrikazTextField;
    private Mapa mapa;
    private MenuLista menuLista;
    private Stage stage;
    private PanelInventar panelInventar;
    private PanelProstory panelProstory;
    private PanelZvolProstor panelZvolProstor;
    private PanelVeciVProstoru panelVeciVProstoru;
    private Button letButton;
    private PanelStavZivota panelStavZivota;
    private PanelStavPaliva panelStavPaliva;
    
    /**
     * Metóda zobrazí javisko, na do ktorého budú umiestnené prvky grafického rozhrania
     * adventúry
     * 
     * @param primaryStage javisko, na ktorom sa odohráva celá scéna
     */
    @Override
    public void start(Stage primaryStage) {
        this.setStage(primaryStage);
        hra = new Hra();
        mapa = new Mapa(hra);
        menuLista = new MenuLista(hra, this);
        panelInventar = new PanelInventar(hra, this);
        panelProstory = new PanelProstory(hra);
        panelZvolProstor = new PanelZvolProstor(hra);
        panelVeciVProstoru = new PanelVeciVProstoru(hra, this);
        panelStavZivota = new PanelStavZivota(hra, this);
        panelStavPaliva = new PanelStavPaliva(hra, this);
        letButton = new Button("Leť!");
        
        BorderPane borderPane = new BorderPane();
        
        centralText = new TextArea();
        centralText.setEditable(false);
        centralText.setText(hra.vratUvitani());
        centralText.setPrefSize(400, 400);
        
        
        Label zadejPrikazLabel = new Label("Zadaj príkaz: ");
        zadejPrikazLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        Label vypisVychody = new Label("Východy: ");
        vypisVychody.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vypisVychody.setPrefWidth(150);
        
        Label zvolVychody = new Label("Leť na: ");
        zvolVychody.setFont(Font.font("Arial", FontWeight.BOLD, 14));
             
        zadejPrikazTextField = new TextField();
        zadejPrikazTextField.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * 
             * Metóda, ktorá na základe vstupu od užívateľa vypíše výstup
             * hry v závislosti na zadanom vstupe
             * 
             * @param event 
             */
            @Override
            public void handle(ActionEvent event) {
                
                String vstupniPrikaz = zadejPrikazTextField.getText();
                String odpovedHry = hra.zpracujPrikaz(vstupniPrikaz);
                
                centralText.appendText("\n" + vstupniPrikaz + "\n");
                centralText.appendText("\n" + odpovedHry + "\n");
                
                panelVeciVProstoru.update();
                panelZvolProstor.update();
                panelInventar.update();
                
                zadejPrikazTextField.setText("");
                if (hra.konecHry()) {
                    zadejPrikazTextField.setEditable(false);
                    centralText.appendText(hra.vratEpilog());
                }
            }
        });
        letButton.setPrefWidth(50);
        letButton.setOnAction((ActionEvent event) -> {
                this.getCentralText().appendText("\n\n" + hra.zpracujPrikaz("let " + panelZvolProstor.getValue()));
                if (hra.konecHry()) {
                    this.zadejPrikazTextField.setEditable(false);
                    this.getCentralText().appendText("\n" + hra.vratEpilog());
                }
           });
        
        
        FlowPane dolniLista = new FlowPane();
        dolniLista.setAlignment(Pos.CENTER);
        dolniLista.getChildren().addAll(zadejPrikazLabel, zadejPrikazTextField);
        
        FlowPane levaLista = new FlowPane();
        levaLista.setAlignment(Pos.TOP_LEFT);
        
        FlowPane levaListaDolu = new FlowPane();
        levaListaDolu.setAlignment(Pos.BOTTOM_LEFT);
        VBox stavLode = new VBox();
        stavLode.getChildren().addAll(panelStavZivota, panelStavPaliva);
        levaListaDolu.getChildren().addAll(panelProstory, stavLode);
        
        levaLista.getChildren().addAll(mapa, vypisVychody, zvolVychody, panelZvolProstor, letButton, levaListaDolu);
        
        FlowPane pravaLista = new FlowPane();
        pravaLista.setAlignment(Pos.TOP_LEFT);
        pravaLista.setPrefSize(500, 700);
        pravaLista.getChildren().addAll(panelInventar, panelVeciVProstoru);
        
        
        borderPane.setTop(menuLista);
        borderPane.setCenter(centralText);
        borderPane.setLeft(levaLista);
        borderPane.setRight(pravaLista);
        borderPane.setBottom(dolniLista);
        
        Scene scene = new Scene(borderPane, 1500, 900);
        
        primaryStage.setTitle("Adventúra");
        primaryStage.setScene(scene);
        primaryStage.show();
        zadejPrikazTextField.requestFocus();
    }

    /**
     * Metóda slúži na spustenie grafickej verzie adventúry
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
        launch(args);
       }
        else {
            if (args[0].equals(" txt")) {
                IHra hra = new Hra();
                TextoveRozhrani textHra = new TextoveRozhrani(hra);
                textHra.hraj();
            }
            
            else {
                System.out.println("Nesprávny argument");
                System.exit(1);
            }
        }
        
    }
    
    
    /**
     * Metóda vráti panel so stavom života
     * 
     * @return panel so stavom života
     */
    public PanelStavZivota getPanelStavZivota() {
        return panelStavZivota;
    }
    
    /**
     * Metóda vráti panel so stavom paliva
     * 
     * @return panel so stavom života
     */
    public PanelStavPaliva getPanelStavPaliva() {
        return panelStavPaliva;
    }
    
    /**
     * Metóda vráti TextField pre zadávanie príkazov
     * 
     * @return zadejPrikazTextField
     */

    public TextField getZadejPrikazTextField() {
        return zadejPrikazTextField;
    }

    /**
     * 
     * Metóda vráti panel, v ktorom sú zobrazené veci v priestore
     * @return panel vecí 
     */
    public PanelVeciVProstoru getPanelVeciVProstoru() {
        return panelVeciVProstoru;
    }
    
    /**
     * 
     * Metóda vráti panel, v ktorom sú zobrazené veci v inventári
     * @return panel inventára
     */
    public PanelInventar getPanelInventar() {
        return panelInventar;
    }
    
        /**
     * 
     * Metóda vráti panel, v ktorom sú zobrazené priestory, do ktorých sa dá
     * ísť z aktuálneho priestoru
     * @return panel susedných priestorov
     */

    public PanelProstory getPanelProstory() {
        return panelProstory;
    }
    
        /**
     * 
     * Metóda vráti panel, v ktorom sú zobrazené priestory, do ktorých sa dá ísť
     * po vybratí na danom paneli
     * @return panel susedných priestorov výber
     */
    
    public PanelZvolProstor getPanelZvolProstor() {
        return panelZvolProstor;
    }
    
    /**
     * 
     * Metóda nastaví javisko, v ktorom sa bude odohrávať celá grafika
     * 
     * @param stage javisko
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
     /**
     * 
     * Metóda vráti javisko.
     * 
     * @return stage javisko
     */
    public Stage getStage() {
        return stage;
    }
    
    /**
     * Metóda vráti textareu, v ktorej sa vypisuje text adventúry
     * 
     * @return textový výpis z hry
     */

    public TextArea getCentralText() {
        return centralText;
    }
    
    /**
     * Metóda vráti mapu priestorov, v ktorých sa dá pohybovať
     * 
     * @return mapa priestorov
     */

    public Mapa getMapa() {
        return mapa;
    }
    
    /**
     * Metóda nastaví hru
     * 
     * @param hra hra, ktorá sa nastaví
     */

    public void setHra(IHra hra) {
        this.hra = hra;
    }
    
}
