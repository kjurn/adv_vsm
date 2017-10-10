package logika;


/**
 * Trieda {@code PrikazVyhod} implementuje pre hru príkaz vyhod.
 * Táto trieda je súčasťou jednoduchej textovej hry.
 *
 * @author        Juraj Szucs
 * @version       31.12.2016
 */
public class PrikazVyhod implements IPrikaz {

    private static final String NAZEV = "vyhod";
    private Inventar inventar;
    private HerniPlan herniPlan;
        
    /**
     * Konštruktor objektov triedy PrikazVyhod
     * 
     * @param herniPlan odkaz na herný plán, na ktorom sa hraje
     * @param inventar odkaz na inventár, ktorý sa používa na vkladanie a vyhadzovanie vecí z herného plánu
     */
    public PrikazVyhod(HerniPlan herniPlan, Inventar inventar)
    {
        this.inventar = inventar;
        this.herniPlan = herniPlan;
    }

    /**
     * V prípade, že má príkaz menej ako 2 slová, metóda hráča upozorní,
     * že musí zadať, čo má vyhodiť,
     * inak testuje, či sa v inventári nachádza vec a  
     * vec z inventára vymaže a vloží ju do aktuálneho priestoru herného plánu
     *
     * @param parametry ako parameter obsahuje názov veci, ktorá sa má vyhodiť z inventára
     * @return správa, ktorú vypíše hra hráčovi 
     */
    
    @Override
    public String proved(String... parametry) {
        if (parametry.length < 1) {
            return "Neviem, čo mám vyhodiť";
        }
        
        String nazovVeci = parametry[0];
        Vec vec = inventar.vratZInventara(nazovVeci);
        
        if (vec == null) {
            return nazovVeci + " nie je v inventári";
        }
        herniPlan.getAktualniProstor().vlozVec(vec);
        inventar.vymazZInventara(nazovVeci);
        return nazovVeci + " bola vyhodená z inventára";
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
    
}
