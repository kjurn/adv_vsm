package logika;


/**
 * Trieda {@code PrikazInventar} implementuje pre hru príkaz inventar.
 * Táto trieda je súčasťou jednoduchej textovej hry
 *
 * @author        Juraj Szucs
 * @version       31.12.2016
 */
public class PrikazInventar implements IPrikaz {
    
    private static final String NAZEV = "inventar";
    private Inventar inventar;
    
    /**
     * Konštruktor objektov triedy PrikazInventar
     * 
     * @param inventar odkaz na inventár, ktorý sa má vypísať
     */
    public PrikazInventar(Inventar inventar) {
        this.inventar = inventar;
    }
    
    /**
     * V prípade, že príkaz má len jedno slovo "inventar", hra zobrazí aktuálny inventár (volá se metóda vypisInventara()),
     * inak pokračuje napr. pri zadaní "inventar bla".
     * 
     * @return správa, ktorú vypíše hra hráčovi
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length > 0) {
            return "Nechápem, prečo ste zadali dalšie slovo.";
        }
        
        return inventar.vypisInventara();
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @return NAZEV nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
