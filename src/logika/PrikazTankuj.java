/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 * Trieda {@code PrikazTankuj} implementuje pre hru príkaz tankuj. 
 * Táto trieda je súčasťou jednoduchej textovej hry.
 *
 * @author        Juraj Szucs
 * @version       31.12.2016
 */
public class PrikazTankuj implements IPrikaz {
   
    private static final String NAZEV = "tankuj";
    private Inventar inventar;
    private VesmirnaLod vesmirnaLod;

    /**
     * Konštruktor objektov triedy PrikazOprav
     * 
     * @param inventar odkaz na inventár, ktorý sa používa na vkladanie a vyhadzovanie vecí z inventára
     * @param vesmirnaLod odkaz na vesmírnu lod, ktorá sa používa na znižovanie a zvyšovanie života lode
     */
    public PrikazTankuj(Inventar inventar, VesmirnaLod vesmirnaLod)
    {
//        super("tankuj", "Doplní palivo lode za predpokladu, že sa v inventári nachádza palivo");
        this.inventar = inventar;
        this.vesmirnaLod = vesmirnaLod;
    }


    /**
     * V prípade, že príkaz má len jedno slovo "tankuj", metóda testuje, či
     * sa v inventári nachádza vec "palivo" a zavolá metódu setZivotLode(false)
     * a nastaví vesmírnej lodi plné palivo,
     * inak pokračuje napr. pri zadaní "tankuj bla".
     *
     * 
     * @return správa, ktorú vypíše hra hráčovi
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length > 0) {
            return "Nechápem, prečo ste zadali dalšie slovo.";
        }
        Vec palivo = inventar.vratZInventara("palivo");
        
        if (palivo == null) {
            return "V inventári nemáš palivo. Nemôžeš natankovať lod";
        } else {
            inventar.vymazZInventara("palivo");
            vesmirnaLod.setZivotLode(false);
            return "Lod bola dotankovaná, teraz máš plnú nádrž";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
