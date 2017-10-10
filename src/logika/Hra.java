package logika;


/**
 * Třída {@code Hra} - třída představující logiku adventury.
 * 
 * Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan,
 * která inicializuje místnosti hry a vytváří seznam platných příkazů a instance tříd
 * provádějící jednotlivé příkazy. Vypisuje uvítací a ukončovací text hry. Také
 * vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 * @author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Riha, Juraj Szucs
 * @version    31.12.2016
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private Inventar inventar;
    private boolean konecHry = false;
    private VesmirnaLod vesmirnaLod;

    /**
     *  Konštruktor objektov triedy Hra.
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     *  Vytvára a inicializuje inventár a vesmírnu lod
     */
    public Hra() {
        inventar = new Inventar();
        vesmirnaLod = new VesmirnaLod();
        herniPlan = new HerniPlan(inventar);
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazLet(herniPlan, inventar, vesmirnaLod));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazVloz(herniPlan, inventar));
        platnePrikazy.vlozPrikaz(new PrikazProzkoumej(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazInventar(inventar));
        platnePrikazy.vlozPrikaz(new PrikazVyhod(herniPlan, inventar));
        platnePrikazy.vlozPrikaz(new PrikazOprav(inventar, vesmirnaLod));
        platnePrikazy.vlozPrikaz(new PrikazTankuj(inventar, vesmirnaLod));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "Vitajte!\n" +
               "Toto je vesmírna adventúra.\n" +
               "Napíšte 'napoveda', ak si neviete rady, ako hrať dalej.\n" +
               "\n" +
               herniPlan.getAktualniProstor().dlouhyPopis() + vesmirnaLod.popisZivota(vesmirnaLod.getZivotLode()) + 
               "\n" + vesmirnaLod.popisPaliva(vesmirnaLod.getPalivoLode());
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Ďakujem za zahratie si hry. Pekný deň";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano, spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
            parametry[i]= slova[i+1];   
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);

            if (herniPlan.hracVyhral()) {
                konecHry = true;
                return "Tvoja misia bola úspešná! Vdaka tebe teraz\n" +
            "môžeme vyslať flotilu lodí";
            } else if (herniPlan.getHracPrehral()) {
                konecHry = true;
            }
        } else {
            textKVypsani="Neviem, čo tým myslíš? Tento príkaz nepoznám. ";
        }
        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní IPrikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
    
}
