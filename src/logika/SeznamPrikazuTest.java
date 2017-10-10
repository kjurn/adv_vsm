package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída {@code SeznamPrikazuTest} slouží ke komplexnímu otestování třídy  
 * SeznamPrikazu.
 * 
 * @author    Luboš Pavlíček, Juraj Szucs
 * @version   1.1.2017
 */
public class SeznamPrikazuTest
{
    private Hra hra;
    private Inventar inventar;
    private PrikazKonec prKonec;
    private PrikazLet prLet;
    private VesmirnaLod vesmirnaLod;
    
    @Before
    public void setUp() {
        hra = new Hra();
        inventar = new Inventar();
        prKonec = new PrikazKonec(hra);
        prLet = new PrikazLet(hra.getHerniPlan(), inventar, vesmirnaLod);
    }
    
    /**
     * Metóda testuje, či sa príkazy vložili správne do HashSetu
     */
    @Test
    public void testVlozeniVybrani() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prLet);
        assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
        assertEquals(prLet, seznPrikazu.vratPrikaz("let"));
        assertEquals(null, seznPrikazu.vratPrikaz("napoveda"));
    }
    
     /**
     * Metóda testuje, či príkazy, ktoré boli vložené do HashSetu
     * sú platné
     */
    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prLet);
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("konec"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("let"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("napoveda"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }
    
     /**
     * Metóda testuje, či sú správne názvy príkazov
     */
    @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prLet);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("let"));
        assertEquals(false, nazvy.contains("napoveda"));
        assertEquals(false, nazvy.contains("Konec"));
    }
}
