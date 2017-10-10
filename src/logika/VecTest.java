package logika;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code VecTest} slúži na komplexné
 * otestovanie triedy {@link VecTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class VecTest
{
    /**
     * Predvolený konštruktor testovacej triedy VecTest
     */
    public VecTest()
    {
    }

    /**
     * Inicializácia predchádzajúca spusteniu každého testu a pripravujúca
     * tzv. prípravok (fixture), čo je množina objektov, s ktorými budú
     * testy pracovať.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Upratovanie po teste – táto metóda je spustená po vykonaní každého
     * testu.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Testuje, či sa názov veci zhoduje
     */
    @Test
    public void testMetodyGetNazev() {
        Vec vec1 = new Vec("kameň", "obyčajný kameň", true);
        Vec vec2 = new Vec("papier", "obyčajný papier", true);
        assertSame("kameň", vec1.getNazev());
        assertNotSame("kameň", vec2.getNazev());
    }
    
    /**
     * Testuje, či sa popis veci zhoduje
     */
    @Test
    public void testMetodyGetPopis() {
        Vec vec1 = new Vec("kameň", "obyčajný kameň", true);
        Vec vec2 = new Vec("papier", "obyčajný papier", true);
        assertSame("obyčajný kameň", vec1.getPopis());
        assertNotSame("obyčajný kameň", vec2.getPopis());
    }
    
    /**
     * Testuje, či sa zhoduje prenositeľnosť veci
     */
    @Test
    public void testMetodyIsPrenositelna() {
        Vec vec1 = new Vec("kameň", "obyčajný kameň", true);
        Vec vec2 = new Vec("hora", "veľmi vysoká hora", false);
        assertFalse(vec2.isPrenositelna());
        assertTrue(vec1.isPrenositelna());
    }
}
