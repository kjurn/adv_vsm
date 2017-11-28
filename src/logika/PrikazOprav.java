package logika;


/**
 * Trieda {@code PrikazOprav} implementuje pre hru príkaz oprav. 
 * Táto trieda je súčasťou jednoduchej textovej hry.
 *
 * @author        Juraj Szucs
 * @version       31.12.2016
 */
public class PrikazOprav implements IPrikaz {
    
    private static final String NAZEV = "oprav";
    private Inventar inventar;
    private VesmirnaLod vesmirnaLod;

    /**
     * Konštruktor objektov triedy PrikazOprav
     * 
     * @param inventar odkaz na inventár, ktorý sa používa na vkladanie a vyhadzovanie vecí z inventára
     * @param vesmirnaLod odkaz na vesmírnu lod, ktorá sa používa na znižovanie a zvyšovanie života lode
     */
    public PrikazOprav(Inventar inventar, VesmirnaLod vesmirnaLod)
    {
        this.inventar = inventar;
        this.vesmirnaLod = vesmirnaLod;
    }


    /**
     * V prípade, že príkaz má len jedno slovo "oprav", metóda testuje, či
     * sa v inventári nachádza vec "opravný_balík" a zavolá metódu setZivotLode(false)
     * a nastaví vesmírnej lodi plný život,
     * inak pokračuje napr. pri zadaní "oprav bla".
     * 
     * 
     * @return správa, ktorú vypíše hra hráčovi
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length > 0) {
            return "Nechápem, prečo ste zadali dalšie slovo.";
        }
        Vec opravnyBalik = inventar.vratZInventara("opravny_balik");
        
        if (opravnyBalik == null) {
            return "V inventári nemáš opravný balík. Nemôžeš opraviť lod";
        } else {
            inventar.vymazZInventara("opravny_balik");
            vesmirnaLod.setZivotLode(false);
            return "Lod bola opravená, teraz máš plný život";
        }
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
