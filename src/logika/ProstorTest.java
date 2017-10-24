package logika;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková, Juraj Szucs
 * @version   1.1.2017
 */
public class ProstorTest
{
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
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public void testLzeProjit() {
        Prostor prostor1 = new Prostor("Zem", "modrá planéta", false, false, 1, 1);
        Prostor prostor2 = new Prostor("Mars", "červená planéta", false, false, 1, 1);
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("Mars"));
        assertEquals(null, prostor2.vratSousedniProstor("Neptún"));
    }
    
    /**
     * Testuje, či z priestoru odobraná vec rovná veci, ktorá tam
     * bola vložená a či môžeme zobrať vec, ktorá v priestore nie je
     */
    @Test
    public void testVeci()
    {
        logika.Prostor prostor1 = new logika.Prostor(null, null, false, false, 1, 1);
        logika.Vec vec1 = new logika.Vec("a", "popis a", true);
        logika.Vec vec2 = new logika.Vec("b", "popis b", false);
        prostor1.vlozVec(vec1);
        prostor1.vlozVec(vec2);
        assertSame(vec1, prostor1.odeberVec("a"));
        assertNull(prostor1.odeberVec("c"));
    }
    
    /**
     * Testuje, či v prípade, keď sú na planéte piráti sa im podarí ujsť
     * alebo nie
     */
    @Test
    public void testUtekPiratom() {
        Prostor prostor1 = new Prostor("Zem", "modrá planéta", true, false, 1, 1);
        assertTrue(prostor1.utekPiratom(82));
        assertFalse(prostor1.utekPiratom(50));
    }
    
    /**
     * Testuje, či je daná planéta plynný obor, alebo nie
     * 
     */
    @Test
    public void testGetJePlynnyObor() {
        Prostor prostor1 = new Prostor("Zem", "modrá planéta", false, false, 1, 1);
        Prostor prostor2 = new Prostor("Jupiter", "veľká planéta", false, true, 1, 1);
        assertFalse(prostor1.getJePlynnyObor());
        assertTrue(prostor2.getJePlynnyObor());
    }
    
    /**
     * Testuje, či má daná planéta pirátov, alebo nie
     * 
     */
    @Test
    public void testGetMaPiratov() {
        Prostor prostor1 = new Prostor("Zem", "modrá planéta", false, false, 1, 1);
        Prostor prostor2 = new Prostor("Mesiac", "satelit Zeme", true, false, 1, 1);
        assertFalse(prostor1.getMaPiratov());
        assertTrue(prostor2.getMaPiratov());
    }

}
