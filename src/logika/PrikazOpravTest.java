package logika;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code PrikazOpravTest} slúži na komplexné
 * otestovanie triedy {@link PrikazOpravTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class PrikazOpravTest
{
    private Inventar inventar;
    private VesmirnaLod vesmirnaLod;
    private PrikazOprav oprav;
    /**
     * Predvolený konštruktor testovacej triedy PrikazOpravTest
     */
    public PrikazOpravTest()
    {
        inventar = new Inventar();
        vesmirnaLod = new VesmirnaLod();
        oprav = new PrikazOprav(inventar, vesmirnaLod);
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
     * Testuje, či sa podarí opraviť loď, ak je v inventári
     * opravný balík alebo nie
     */
    @Test
    public void testOpravProved() {
        Vec balik = new Vec("opravny_balik","", "Na opravenie lodi", true, "/zdroje/bla");
        assertEquals("V inventári nemáš opravný balík. Nemôžeš opraviť lod", oprav.proved());
        inventar.pridajDoInventara(balik);
        assertEquals("Lod bola opravená, teraz máš plný život", oprav.proved());
    }
}
