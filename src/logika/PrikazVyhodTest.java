package logika;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code PrikazVyhodTest} slúži na komplexné
 * otestovanie triedy {@link PrikazVyhodTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class PrikazVyhodTest
{
    private Inventar inventar;
    private HerniPlan hPlan;
    private PrikazVyhod vyhod;
    /**
     * Predvolený konštruktor testovacej triedy PrikazVyhodTest
     */
    public PrikazVyhodTest()
    {
        inventar = new Inventar();
        hPlan = new HerniPlan(inventar);
        vyhod = new PrikazVyhod(hPlan, inventar);
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
     * Testuje, či sa podarí vec vyhodiť z inventára a či sa prázdna
     * vec dá vyhodiť z inventára
     */
    @Test
    public void testVyhodProved() {
        Vec vec1 = new Vec("jogurt", "potravina plná probiotických kultúr", true);
        Vec vec2 = new Vec("páska", "iba kus pásky", true);
        Vec vec3 = new Vec("peňaženka", "na prenášanie peňazí", true);
        inventar.pridajDoInventara(vec1);
        inventar.pridajDoInventara(vec2);
        assertEquals(vec1.getNazev() + " bola vyhodená z inventára", vyhod.proved(vec1.getNazev()));
        assertEquals(vec3.getNazev() + " nie je v inventári", vyhod.proved(vec3.getNazev()));
    }
}
