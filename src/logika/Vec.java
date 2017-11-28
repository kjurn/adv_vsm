/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 * Trieda {@code Vec} popisuje veci v hre.
 * Táto trieda je súčasťou jednoduchej textovej hry.
 * Vec reprezentuje jednu vec, ktorá je v hre.
 * Každá vec má názov, popis a vlastnosť, či sa dá preniesť alebo nie.
 *
 * @author    Juraj Szucs
 * @version   31.12.2016
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private String nazevGrafika;
    private String popis;
    private boolean prenositelna;
    private String umiestnenie;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konštruktor objektov triedy Vec
     *  
     *  @param nazev názov prostoru, jednoznačný identifikátor, jedno slovo alebo
     *  viacslovný názov bez medzier.
     *  @param nazevGrafika názov veci v grafickom prostredí
     *  @param popis Popis veci
     *  @param prenositelna informácia, či je možné vec preniesť alebo nie
     *  @param umiestnenie umiestnenie obrázku veci na disku
     */
    public Vec(String nazev, String nazevGrafika, String popis, boolean prenositelna, String umiestnenie)
    {
        this.nazev = nazev;
        this.nazevGrafika = nazevGrafika;
        this.popis = popis;
        this.prenositelna = prenositelna;
        this.umiestnenie = umiestnenie;
    }


    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Metóda vráti názov veci
     * 
     * @return Názov veci 
     * 
     */
    public String getNazev() {
        return nazev;
    }
    
    /**
     * Metóda vráti názov veci v grafickej verzii
     * 
     * @return Názov veci 
     */
    public String getNazevGrafika() {
        return nazevGrafika;
    }

    
    /**
     * Metóda vráti popis veci
     * 
     * @return Popis
     */
    public String getPopis() {
        return popis;
    }
    
    /**
     * Metóda vráti hodnotu prenositeľnosti, či je vec prenositeľná
     * alebo nie
     * 
     * @return true = je prenositeľná, false = nie je prenositeľná
     * 
     */
    public boolean isPrenositelna() {
        return prenositelna;
    }
    /**
    * Metóda umiestnenie obrázku danej veci
    * 
    * @return umiestnenie
    * 
    */
    public String getUmiestnenie() {
        return umiestnenie;
    }


    // Možná bude potřeba přidat settery pro atributy 'popis' a 'prenositelna'.
    // Atribut 'nazev' by se měnit neměl.

    //== Soukromé metody (instancí i třídy) ========================================

}
