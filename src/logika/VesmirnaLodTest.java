package logika;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code VesmirnaLodTest} slúži na komplexné
 * otestovanie triedy {@link VesmirnaLodTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class VesmirnaLodTest
{
    /**
     * Predvolený konštruktor testovacej triedy VesmirnaLodTest
     */
    public VesmirnaLodTest()
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
     * Testuje, či lodi ubúda život a testuje aj reťazce,
     * ktoré hra vypíše pri určitej hodnote života lode.
     */
    @Test
    public void testLode() {
        VesmirnaLod lod = new VesmirnaLod();
        assertEquals(100, lod.getZivotLode());
        lod.setZivotLode(true);
        assertEquals(90, lod.getZivotLode());
        assertEquals("Lodi zostáva "+ lod.getZivotLode() + " života", lod.popisZivota(lod.getZivotLode()));
        lod.setZivotLode(true);
        lod.setZivotLode(true);
        lod.setZivotLode(true);
        lod.setZivotLode(true);
        assertEquals(50, lod.getZivotLode());
        assertEquals("Lodi zostáva ešte polovica života", lod.popisZivota(lod.getZivotLode()));
        lod.setZivotLode(true);
        lod.setZivotLode(true);
        lod.setZivotLode(true);
        assertEquals(20, lod.getZivotLode());
        assertEquals("Lodi zostáva " + lod.getZivotLode() +
                     " života, čo je kritická hranica.\nUrýchlene" +
                     " nájdi a použi opravný balík", lod.popisZivota(lod.getZivotLode()));
    }
}
