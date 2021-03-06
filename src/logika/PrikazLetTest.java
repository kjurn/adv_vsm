package logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code PrikazLetTest} slúži na komplexné
 * otestovanie triedy {@link PrikazLetTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class PrikazLetTest
{
    private Hra hra;
    private HerniPlan hPlan;
    private Inventar inventar;
    private VesmirnaLod vesmirnaLod;
    private PrikazLet let;
    /**
     * Predvolený konštruktor testovacej triedy PrikazLetTest
     */
    public PrikazLetTest()
    {
        inventar = new Inventar();
        vesmirnaLod = new VesmirnaLod();
        hPlan = new HerniPlan();
        hra = new Hra();
        let = new PrikazLet(hra, hPlan, inventar, vesmirnaLod);
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
     * Testuje, či sa dá k plynnému obrovi priblížiť bez veterného štítu a zároveň testuje, či sa dá ísť na planétu,
     * ktorá nie je susedná k aktuálnej planéte alebo neexistuje.
     */
    @Test
    public void testLetProved() {
        Vec veternyStit = new Vec("veterny_stit", "", "Tento štít slúži na priblíženie sa k plynným obrom", true, "/zdroje/bla");
        Prostor planetaMars = new Prostor("Mars","červená planéta", false, false, 1, 1); 
        Prostor planetaJupiter = new Prostor("Jupiter","plynný obor", false, true, 1, 1);
        hPlan.setAktualniProstor(planetaMars);
        planetaMars.setVychod(planetaJupiter);
        planetaJupiter.setVychod(planetaMars);
        Prostor sousedniProstor = hPlan.getAktualniProstor().vratSousedniProstor("Jupiter");
        assertEquals("Táto planéta je plynný obor," + "\n" +
                     "nemožeš sa k nej priblížiť bez" +
                     " veterného štítu", let.proved("Jupiter"));
        inventar.pridajDoInventara(veternyStit);
        assertEquals(sousedniProstor.dlouhyPopis() + vesmirnaLod.popisZivota(vesmirnaLod.getZivotLode() - 10), let.proved("Jupiter"));
        assertEquals("Tam se odtiaľto nedá ísť!", let.proved("Pluto"));
    }
}
