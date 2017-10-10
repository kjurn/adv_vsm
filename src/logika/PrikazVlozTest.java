package logika;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code PrikazVlozTest} slúži na komplexné
 * otestovanie triedy {@link PrikazVlozTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class PrikazVlozTest
{
    private Inventar inventar;
    private HerniPlan hPlan;
    private PrikazVloz prikaz;
    /**
     * Predvolený konštruktor testovacej triedy PrikazVlozTest
     */
    public PrikazVlozTest()
    {
        inventar = new Inventar();
        hPlan = new HerniPlan(inventar);
        prikaz = new PrikazVloz(hPlan, inventar);
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
     * Testuje, či je možné vložiť vec z priestoru do inventára,
     * keď je neprenositeľná, keď neexistuje, alebo keď už je v
     * inventári. Netestuje, či má inventár obmedzenú kapacitu, to je
     * otestované v testoch triedy Inventar. Názvy vecí nemusia
     * súvisieť s hrou
     */
    @Test
    public void testVlozProved() {
        Prostor prostor = new Prostor("izba","na bývanie", false, false);
        Vec vec1 = new Vec("sponka", "sponka do vlasov", true);
        Vec vec2 = new Vec("kamión", "veľké vozidlo", false);
        prostor.vlozVec(vec1);
        prostor.vlozVec(vec2);
        hPlan.setAktualniProstor(prostor);
        assertEquals(vec1.getNazev() + " bola vlozená do inventára", prikaz.proved(vec1.getNazev()));
        assertEquals(vec2.getNazev() + " nemôžeš vziať", prikaz.proved(vec2.getNazev()));
        assertEquals("slon" + " sa tu nenachádza", prikaz.proved("slon"));
    }
}
