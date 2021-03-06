package logika;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry-
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Riha, Juraj Szucs
 * @version 31.12.2016
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
    private Map<String, Vec> veci;
    private boolean maPiratov;
    private boolean jePlynnyObor;
    private double posLeft;
    private double posTop;

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     * @param maPiratov informácia, či má daná planéta/mesiac pirátov alebo nie
     * @param jePlynnyObor informácia, či je daná planéta plynný obor alebo nie
     * @param posLeft y-ntá pozícia rakety na mape
     * @param posTop  x-tá pozícia rakety na mape
     */
    public Prostor(String nazev, String popis, boolean maPiratov, boolean jePlynnyObor, double posLeft, double posTop) {
        this.nazev = nazev;
        this.popis = popis;
        this.maPiratov = maPiratov;
        this.jePlynnyObor = jePlynnyObor;
        this.posLeft = posLeft;
        this.posTop = posTop;
        vychody = new HashSet<>();
        veci = new HashMap<>();
        
    }

    /**
     * 
     * Vráti mapu s vecami, ktoré sa nachádzajú v priestore
     * @return mapa s vecami v priestore
     */
    public Map<String, Vec> getVeci() {
        return veci;
    }

    /**
     * 
     * Vráti x-ovú pozíciu daného priestoru na mape
     * @return pozícia x
     */
    public double getPosLeft() {
        return posLeft;
    }

       /**
     * 
     * Vráti y-novú pozíciu daného priestoru na mape
     * @return pozícia y
     */
    public double getPosTop() {
        return posTop;
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     * 
     * @return Výsledek
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Si na " + popis + ".\n"
                + popisVychodu() + "\n"
                + popisVeci() + "\n";
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    public String popisVychodu() {
        String vracenyText = "vychody:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
            if (sousedni.getJePlynnyObor()) {
            vracenyText += "(plynný obor)";
            }
        }
        return vracenyText;
    }
    
    /**
     * Vráti textový reťazec, který popisuje veci, například:
     * "veci: hala ".
     *
     * @return Popis vecí - názvy vecí
     */
    private String popisVeci() {
        String vracenyText = "veci:";
        for (String nazev : veci.keySet()) {
            vracenyText += " " + nazev;
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
                   .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                   .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }
    
    /**
     * Metóda vkladá vec do priestoru
     * 
     * @param vec vec, ktorá sa má vložiť do priestoru 
     * 
     */
    public void vlozVec(Vec vec) {
        veci.put(vec.getNazev(), vec);
    }
    
    /**
     * Metóda odstráni vec z mapy
     * 
     * @param nazev názov veci, ktorá sa má odstrániť z mapy 
     * @return vec, ktorá bola z mapy odstránená
     * 
     */
    public Vec odeberVec(String nazev) {
        return veci.remove(nazev);
    }
    
    /**
     * Metóda vracia hodnotu atribútu maPiratov
     *  
     * @return true = ak má pirátov, false = ak nemá pirátov
     * 
     */
    public boolean getMaPiratov() {
        return maPiratov;
    }
    
    /**
     * Metóda vracia hodnotu atribútu jePlynnyObor
     *  
     * @return true = ak je plynný obor, false = ak nie je plynný obor
     * 
     */
    public boolean getJePlynnyObor() {
        return jePlynnyObor;
    }
    
    /**
     * Metóda testuje, či je daný parameter väčší ako 70 a vracia 
     * hodnotu, či hráč ušiel pirátom alebo nie
     * 
     *  
     * @param cislo Náhodné číslo
     * @return true = hráč ušiel pirátom, false = hráč neušiel pirátom
     * 
     */
    public boolean utekPiratom(int cislo) {
        if (cislo > 70) {
            return true;
        } else {
            return false;
        }
    }
}
