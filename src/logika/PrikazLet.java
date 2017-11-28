package logika;

import java.util.Random;

/**
 * Třída {@code PrikazLet} implementuje pro hru příkaz let.
 * Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jarmila Pavlickova, Luboš Pavlíček, Jan Riha, Juraj Szucs
 * @version    31.12.2016
 */
class PrikazLet implements IPrikaz {
    private static final String NAZEV = "let";
    private HerniPlan plan;
    private Inventar inventar;
    private Random nahoda;
    private VesmirnaLod vesmirnaLod;
    private Hra hra;
    private static final int MINIMALNI_ZIVOT = 20;
    private static final int MINIMALNI_PALIVO = 20;
    
    /**
    *  Konštruktor objektov triedy PrikazLet
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    *  @param inventar odkaz na inventár, ktorý sa používa na vkladanie a vyhadzovanie vecí z herného plánu
    *  @param vesmirnaLod odkaz na vesmírnu lod, ktorá sa používa na znižovanie a zvyšovanie života lode
    */    
    public PrikazLet(Hra hra, HerniPlan plan, Inventar inventar, VesmirnaLod vesmirnaLod) {
        this.hra = hra;
        this.plan = plan;
        this.inventar = inventar;
        this.nahoda = new Random();
        this.vesmirnaLod = vesmirnaLod;
    }

    /**
     *  Provádí příkaz "let". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení. Ďalej testuje,
     *  či sa môže loď priblížiť k plynnému obrovi, či má loď dostatok života a či sa podarilo ujsť pirátom, alebo nie.
     *  Metóda generuje náhodné číslo, ktoré sa používa ako parameter v metóde utekPiratom(). Ďalej znižuje život lode pri
     *  prelete na inú planétu/mesiac a volá setHracPrehral(true), ak hráč prehral.
     *  Vracia textový reťazec na základe 
     *  vyššie spomenutých textov 
     *  
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám ísť? Musíš zadať meno planéty alebo mesiaca";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);
        if (sousedniProstor == null) {
            return "Tam se odtiaľto nedá ísť!";
        } 
        
        if (vesmirnaLod.getZivotLode() < MINIMALNI_ZIVOT) {
            hra.setHracPrehral(true);
            return "Nedostatok života, lod bola zničená, misia neúspešná";
        }
        
        if (vesmirnaLod.getPalivoLode() < MINIMALNI_PALIVO) {
            hra.setHracPrehral(true);
            return "Nedostatok paliva, loď nemôže letieť, misia neúspešná";
        }
        
        if (sousedniProstor.getJePlynnyObor() && ! inventar.jeVInventari("veterny_stit")) {
            return "Táto planéta je plynný obor," + "\n" +
            "nemožeš sa k nej priblížiť bez veterného štítu";
        }
        
        if (sousedniProstor.getMaPiratov()) {
            vesmirnaLod.setZivotLode(true);
            vesmirnaLod.setPalivoLode(true);
            plan.setAktualniProstor(sousedniProstor);
            return "Bol si napadnutý pirátmi,\nskús utiecť na" + 
            " vedľajšiu planétu alebo mesiac !\n" +
            sousedniProstor.popisVychodu() + "\n" + vesmirnaLod.popisZivota(vesmirnaLod.getZivotLode()) +
            "\n" + vesmirnaLod.popisPaliva(vesmirnaLod.getPalivoLode());
        }
        
        int nahodneCislo = nahoda.nextInt((100 - 1) + 1) + 1;
        
        if (plan.getAktualniProstor().getMaPiratov() && plan.getAktualniProstor().utekPiratom(nahodneCislo)) {
            vesmirnaLod.setZivotLode(true);
            vesmirnaLod.setPalivoLode(true);
            plan.setAktualniProstor(sousedniProstor);
            return "Podarilo sa ti ujsť pirátom!\n" +
            sousedniProstor.dlouhyPopis() + vesmirnaLod.popisZivota(vesmirnaLod.getZivotLode()) +
            "\n" + vesmirnaLod.popisPaliva(vesmirnaLod.getPalivoLode());
        } else if (plan.getAktualniProstor().getMaPiratov() && ! plan.getAktualniProstor().utekPiratom(nahodneCislo)) {
            hra.setHracPrehral(true);
            return "Zabili a okradli ťa piráti, misia neúspešná";
        } else {
            vesmirnaLod.setZivotLode(true);
            vesmirnaLod.setPalivoLode(true);
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis() + vesmirnaLod.popisZivota(vesmirnaLod.getZivotLode()) + 
            "\n" + vesmirnaLod.popisPaliva(vesmirnaLod.getPalivoLode());
        }
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
