package logika;
import java.util.Map;
import java.util.HashMap;



/**
 * Trieda {@code Inventar} popisuje inventár, ktorý umožňuje vkladanie,
 * zobrazenie a vyhodenie veci
 * 
 *
 * @author        Juraj Szucs
 * @version       31.12.2016
 */
public class Inventar
{
    
    private static final int KAPACITA = 10;
    private Map<String, Vec> inventar;
    
    /**
     * Konštruktor objektov triedy Inventar
     */
    public Inventar()
    {
        inventar = new HashMap<>();
    }

    /**
     * Metóda slúži na pridanie veci do inventára, pričom metóda 
     * testuje, či inventár nie je plný.
     * Vráti hodnotu true alebo false, na základe toho, či sa 
     * vec podarí vložiť do inventára alebo nie
     *
     * @param vec Vec, ktorá sa má vložiť do inventára
     * @return true = vec sa vložila do inventára, false = vec sa nevložila 
     * do inventára
     */
    
    public boolean pridajDoInventara(Vec vec) {
        if (inventar.size() < KAPACITA) {
            inventar.put(vec.getNazev(), vec);
            return true;
        }
        return false;
    }
    
    /**
     * Metóda slúži na vrátenie veci z inventára
     * 
     * @param meno názov veci
     * @return vec z inventára alebo null
     */
    public Vec vratZInventara(String meno) {
        Vec tempVec;
        if (inventar.containsKey(meno)) {
            tempVec = inventar.get(meno);
            return tempVec;
        }
        return null;
    }
    
    /**
     * Metóda slúži na zistenie, či sa daná vec nachádza v inventári
     * alebo nie
     * 
     * @param meno názov veci
     * @return true = vec je v inventári, false = vec nie je v inventári
     */
    public boolean jeVInventari(String meno) {
        if (inventar.containsKey(meno)) {
            return true;
        }
        return false;
    }
    
    /**
     * Metóda slúži na vymazanie veci z inventára
     * 
     * @param meno názov veci
     */
    public void vymazZInventara(String meno) { 
            inventar.remove(meno);
    }
    
    /**
     * Metóda slúži na vypísanie vecí, ktoré sú vložené v inventári.
     * Metóda testuje, či je inventár prázdny a vráti textový
     * reťazec 
     * 
     * 
     * @return veci, ktoré sú v inventári
     */
    public String vypisInventara() {
        if (inventar.isEmpty()) {
            return "Inventár je momentálne prázdny";
        }
        
        String vratenyText = "V inventári sú:";
        
        for (String nazov : inventar.keySet()) {
            vratenyText += " " + nazov;
        }            
        return vratenyText;
    }
}
