/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/*******************************************************************************
 * Trieda {@code PrikazVloz} implementuje pre hru príkaz vloz.
 * Táto trieda je súčasťou jednoduchej textovej hry.
 *
 * @author        Juraj Szucs
 * @version       31.12.2016
 */
public class PrikazVloz implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "vloz";
    private Inventar inventar;
    private HerniPlan herniPlan;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konštruktor objektov triedy PrikazVloz
     *  
     * @param hPlan odkaz na herný plán, na ktorom sa hraje
     * @param inventar odkaz na inventár, ktorý sa používa na vkladanie a vyhadzovanie vecí z herného plánu  
     */
    public PrikazVloz(HerniPlan hPlan, Inventar inventar)
    {
        this.herniPlan = hPlan;
        this.inventar = inventar;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * V prípade, že má príkaz menej ako 2 slová, metóda hráča upozorní,
     * že musí zadať, čo má vložiť,
     * inak testuje, či sa vec nachádza v aktuálnom priestore herného plánu,
     * či je možné ju vziať, či sa už náhodou nenachádza v inventári a či nie je
     * inventár plný a následne vloží vec do inventára
     * 
     * @param parametry ako parameter obsahuje názov veci, ktorá sa má vložiť do inventára
     * @return správa, ktorú vypíše hra hráčovi 
     */
    public String proved(String... parametry) {
        if (parametry.length < 1) {
            return "Neviem, čo mám zobrať";
        }

        String nazevVeci = parametry[0];
        Vec vec = herniPlan.getAktualniProstor().odeberVec(nazevVeci);
        
        if (vec == null) {
            return nazevVeci + " sa tu nenachádza";
        }
        
        if (! vec.isPrenositelna()) {
            herniPlan.getAktualniProstor().vlozVec(vec);
            return nazevVeci + " nemôžeš vziať";
        } 
        
        if (inventar.jeVInventari(nazevVeci)) {
            herniPlan.getAktualniProstor().vlozVec(vec);
            return nazevVeci + " sa už nachádza v inventári";
        }
        
        if (inventar.pridajDoInventara(vec)) {
            return nazevVeci + " bola vlozená do inventára";
        } else {
            herniPlan.getAktualniProstor().vlozVec(vec);
            return "Inventár je plný, nie je možné vložiť";
        }      
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

    //== Soukromé metody (instancí i třídy) ========================================

}
