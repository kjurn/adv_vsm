/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 * Trieda {@code PrikazProzkoumej} implementuje pre hru príkaz prozkoumej.
 * Táto trieda je súčasťou jednoduchej textovej hry
 *
 * @author    Juraj Szucs
 * @version   31.12.2016
 */
public class PrikazProzkoumej implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "prozkoumej";
    
    private HerniPlan hPlan;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konštruktor objektov triedy PrikazProzkoumej
     *  
     *  @param hPlan odkaz na herný plán, na ktorom sa hraje
     */
    public PrikazProzkoumej(HerniPlan hPlan)
    {
        this.hPlan = hPlan;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     * V prípade, že má príkaz menej ako 2 slová, metóda hráča upozorní,
     * že musí zadať, akú vec má preskúmať,
     * inak testuje, či sa v hernom pláne nachádza vec a  
     * vráti jej popis zavolaním metódy getPopis()
     * 
     * @param parametry ako parameter obsahuje názov veci, ktorú chce hráč preskúmať 
     * @return správa, ktorú vypíše hra hráčovi 
     */
    
    @Override
    public String proved(String... parametry) {
        if (parametry.length < 1) {
            return "Neviem, čo mám preskúmať";
        }
        
        String nazevVeci = parametry[0];
        
        Vec vec = hPlan.getAktualniProstor().odeberVec(nazevVeci);
        if (vec == null) {
            return "Vec '" + nazevVeci + "' tu nie je";
        }
        
        hPlan.getAktualniProstor().vlozVec(vec);
        
        return nazevVeci + ": " + vec.getPopis();
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
