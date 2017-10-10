package logika;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testovacia trieda {@code InventarTest} slúži na komplexné
 * otestovanie triedy {@link InventarTest}.
 *
 * @author        Juraj Szucs
 * @version       1.1.2017
 */
public class InventarTest
{
    Inventar inventar;
    Vec vec1; 
    Vec vec2;
    Vec vec3;
    Vec vec4;
    Vec vec5;
    Vec vec6;
    Vec vec7;
    Vec vec8;
    Vec vec9;
    Vec vec10;
    Vec vec11;
    /**
     * Predvolený konštruktor testovacej triedy InventarTest
     */
    public InventarTest()
    {
        inventar = new Inventar();
        vec1 = new Vec("lopta", "na hranie futbalu", true);
        vec2 = new Vec("pravítko", "na rysovanie", true);
        vec3 = new Vec("pero", "na písanie", true);
        vec4 = new Vec("myš", "na používanie PC", true);
        vec5 = new Vec("tričko", "na nosenie", true);
        vec6 = new Vec("telefón", "na telefonovanie", true);
        vec7 = new Vec("rúž", "pre ženy", true);
        vec8 = new Vec("kvet", "na skrášlenie okolia", true);
        vec9 = new Vec("kufor", "na prenášanie vecí", true);
        vec10 = new Vec("špagety", "na jedenie", true);
        vec11 = new Vec("taška", "na prenášanie nákupu", true);
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
     * Testuje, či je možné vložiť vec do inventára a zároveň či
     * sa neprekročí jeho kapacita. Netestuje, či tam môže byť
     * vložená vec, ktorá nie je prenositelná, pretože to je testované
     * v teste triedy PrikazVloz
     */
    @Test
    public void testMetodyPridajDoInventara() {
        assertTrue(inventar.pridajDoInventara(vec1));
        assertTrue(inventar.pridajDoInventara(vec2));
        assertTrue(inventar.pridajDoInventara(vec3));
        assertTrue(inventar.pridajDoInventara(vec4));
        assertTrue(inventar.pridajDoInventara(vec5));
        assertTrue(inventar.pridajDoInventara(vec6));
        assertTrue(inventar.pridajDoInventara(vec7));
        assertTrue(inventar.pridajDoInventara(vec8));
        assertTrue(inventar.pridajDoInventara(vec9));
        assertTrue(inventar.pridajDoInventara(vec10));
        assertFalse(inventar.pridajDoInventara(vec11));   
    }
    
    /**
     * Testuje, či metóda vráti vec, ktorá bola vložená do inventára
     */
    @Test
    public void testMetodyVratZInventara() {
        inventar.pridajDoInventara(vec1);
        assertEquals(vec1, inventar.vratZInventara("lopta"));
        inventar.vymazZInventara("lopta");
        assertNull(inventar.vratZInventara("kniha"));
        assertNull(inventar.vratZInventara("lopta"));
    }
    
    /**
     * Testuje, či metóda vráti hodnotu true, ak sa vec nachádza v
     * inventári a false, ak sa vec v inventári nenachádza
     */
    @Test
    public void testMetodyJeVInventari() {
        inventar.pridajDoInventara(vec1);
        assertTrue(inventar.jeVInventari("lopta"));
        inventar.vymazZInventara("lopta");
        assertFalse(inventar.jeVInventari("kniha"));
        assertFalse(inventar.jeVInventari("lopta"));
    }
    
    /**
     * Testuje, či metóda vráti správny textový reťazec v závislosti na 
     * veciach umiestnených v inventáre
     */
    @Test
    public void testMetodyVypisInventara() {
        assertEquals("Inventár je momentálne prázdny", inventar.vypisInventara());
        inventar.pridajDoInventara(vec1);
        inventar.pridajDoInventara(vec2);
        assertEquals("V inventári sú:" + 
        " lopta pravítko",inventar.vypisInventara());
    }
}
