package logika;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code HerniPlanTest} slúži na komplexné
 * otestovanie triedy {@link HerniPlanTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class HerniPlanTest
{
    private Inventar inventar;
    private HerniPlan hPlan;
    /**
     * Predvolený konštruktor testovacej triedy HerniPlanTest
     */
    public HerniPlanTest()
    {
        inventar = new Inventar();
        hPlan = new HerniPlan();
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
     * Testuje, či sa správne nastavil aktuálny herný priestor 
     */
    @Test
    public void testAktualniProstor() {
        Prostor planetaZem = new Prostor("Zem", "modrá planéta", false, false, 1, 1);
        Prostor planetaMars = new Prostor("Mars", "červená planéta", false, false, 1, 1);
        hPlan.setAktualniProstor(planetaZem);
        assertSame(planetaZem, hPlan.getAktualniProstor());
        assertNotSame(planetaMars, hPlan.getAktualniProstor());
    }
    
    
    /**
     * Testuje, či hráč vyhral, ak sú v inventári dané predmety
     * a loď je na planéte Zem
     */
    @Test
    public void testHracVyhral() {
        Prostor planetaZem = new Prostor("Zem", "modrá planéta", false, false, 1, 1);
        Prostor planetaMars = new Prostor("Mars", "červená planéta", false, false, 1, 1);
        Vec kvapalnyVodik = new Vec("kvapalny_vodik","", "Kvapalný vodík slúži ako súčasť paliva do rakety", true, "/zdroje/bla");
        Vec kvapalnyKyslik = new Vec("kvapalny_kyslik","", "Kvapalný kyslík slúži ako súčasť paliva do rakety", true, "/zdroje/bla");
        Vec hladacInteligencie = new Vec("hladac_inteligencie","", "Hľadač slúži na vyhľadávanie mimozemštanov", true, "/zdroje/bla");
        Vec protonovaStrela = new Vec("protonova_strela","","Túto strelu použiješ v prípade, že nájdení mimozemštania nebudú priateľskí", true, "/zdroje/bla");
        Vec laserovyLuc = new Vec("laserovy_unosny_luc","","Lúč použiješ, ked budeš chcieť preskúmať flóru a faunu na inej planéte", true, "/zdroje/bla");
        Vec kreslitelPoli = new Vec("kreslitel_poli","","Tento nástroj je užitočný pri interakcii s nižšou mimozemskou inteligenciou", true, "/zdroje/bla");
        inventar.pridajDoInventara(kvapalnyVodik);
        inventar.pridajDoInventara(kvapalnyKyslik);
        inventar.pridajDoInventara(hladacInteligencie);
        inventar.pridajDoInventara(protonovaStrela);
        inventar.pridajDoInventara(laserovyLuc);
        inventar.pridajDoInventara(kreslitelPoli);
        hPlan.setAktualniProstor(planetaZem);
    }
}
