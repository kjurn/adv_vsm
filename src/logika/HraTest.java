package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra.
 *
 * @author   Jarmila Pavlíčková, Juraj Szucs
 * @version  1.1.2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje priebeh hry, pri ktorom hráč vyhrá.
     * Po každom zavolaní príkazu let testuje, či hra končí a na akej
     * planéte sa hráč nachádza. 
     * 
     */
    @Test
    public void testUspesnyPrubehHry() {
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Venusa");
        assertEquals(false, hra1.konecHry());
        assertEquals("Venusa", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Merkur");
        assertEquals(false, hra1.konecHry());
        assertEquals("Merkur", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz veterny_stit");
        hra1.zpracujPrikaz("let Venusa");
        assertEquals(false, hra1.konecHry());
        assertEquals("Venusa", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Zem");
        assertEquals(false, hra1.konecHry());
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mesiac");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mesiac", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz opravny_balik");
        hra1.zpracujPrikaz("let Zem");
        assertEquals(false, hra1.konecHry());
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("oprav");
        hra1.zpracujPrikaz("let Deimos");
        assertEquals(false, hra1.konecHry());
        assertEquals("Deimos", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz laserovy_unosny_luc");
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());        
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Jupiter");
        assertEquals(false, hra1.konecHry());
        assertEquals("Jupiter", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Europa");
        assertEquals(false, hra1.konecHry());
        assertEquals("Europa", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz kvapalny_vodik");
        hra1.zpracujPrikaz("let Jupiter");
        assertEquals(false, hra1.konecHry());
        assertEquals("Jupiter", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Ganymedes");
        assertEquals(false, hra1.konecHry());
        assertEquals("Ganymedes", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz opravny_balik");
        hra1.zpracujPrikaz("let Jupiter");
        assertEquals(false, hra1.konecHry());
        assertEquals("Jupiter", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("oprav");
        hra1.zpracujPrikaz("let Io");
        assertEquals(false, hra1.konecHry());
        assertEquals("Io", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz hladac_inteligencie");
        hra1.zpracujPrikaz("let Jupiter");
        assertEquals(false, hra1.konecHry());
        assertEquals("Jupiter", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Saturn");
        assertEquals(false, hra1.konecHry());
        assertEquals("Saturn", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Titan");
        assertEquals(false, hra1.konecHry());
        assertEquals("Titan", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz kvapalny_kyslik");
        hra1.zpracujPrikaz("let Saturn");
        assertEquals(false, hra1.konecHry());
        assertEquals("Saturn", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Uran");
        assertEquals(false, hra1.konecHry());
        assertEquals("Uran", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz kreslitel_poli");
        hra1.zpracujPrikaz("let Titania");
        assertEquals(false, hra1.konecHry());
        assertEquals("Titania", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz opravny_balik");
        hra1.zpracujPrikaz("let Uran");
        assertEquals(false, hra1.konecHry());
        assertEquals("Uran", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Neptun");
        assertEquals(false, hra1.konecHry());
        assertEquals("Neptun", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("oprav");
        hra1.zpracujPrikaz("let Triton");
        assertEquals(false, hra1.konecHry());
        assertEquals("Triton", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("vloz protonova_strela");
        hra1.zpracujPrikaz("let Neptun");
        assertEquals(false, hra1.konecHry());
        assertEquals("Neptun", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Uran");
        assertEquals(false, hra1.konecHry());
        assertEquals("Uran", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Saturn");
        assertEquals(false, hra1.konecHry());
        assertEquals("Saturn", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Jupiter");
        assertEquals(false, hra1.konecHry());
        assertEquals("Jupiter", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Zem");
        assertEquals(true, hra1.konecHry());
    }
    
    /***************************************************************************
     * Testuje priebeh hry, pri ktorom hráč prehrá.
     * Po každom zavolaní príkazu let testuje, či hra končí a na akej
     * planéte sa hráč nachádza. 
     * 
     */
    @Test
    public void testFailPriebehHry() {
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Zem");
        assertEquals(false, hra1.konecHry());
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Zem");
        assertEquals(false, hra1.konecHry());
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Zem");
        assertEquals(false, hra1.konecHry());
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Zem");
        assertEquals(false, hra1.konecHry());
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        assertEquals("Mars", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("let Zem");
        assertEquals(true, hra1.konecHry());
    }
    
    /***************************************************************************
     * Testuje priebeh hry, pri ktorom hráč ukončí hru príkazom konec.
     * Po každom zavolaní príkazu let testuje, či hra končí a na akej
     * planéte sa hráč nachádza. 
     * 
     */
    @Test
    public void testKonecPriebehHry() {
        assertEquals("Zem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("napoveda");
        hra1.zpracujPrikaz("let Mars");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("vloz oxid_zelezity");
        hra1.zpracujPrikaz("prozkoumej Olympus_Mons");
        hra1.zpracujPrikaz("let Deimos");
        assertEquals(false, hra1.konecHry());
        assertEquals("Deimos", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("inventar");
        hra1.zpracujPrikaz("vyhod oxid_zelezity");
        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
    }
}
