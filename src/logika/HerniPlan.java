package logika;


/**
 * Trieda {@code HerniPlan} - třída představující mapu a stav adventury.
 * 
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory, propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Riha, Juraj Szucs
 * @version    31.12.2016
 */
public class HerniPlan {

    private static final String CILOVY_PROSTOR = "Zem";
    private Prostor aktualniProstor;
    private Inventar inventar;
    private boolean hracPrehral = false;

    /**
     *  Konstruktor, který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Zem.
     *  
     *  @param inventar odkaz na inventár, ktorý sa používa na vkladanie a vyhadzovanie vecí z herného plánu
     */
    public HerniPlan(Inventar inventar) {
        zalozProstoryHry();
        this.inventar = inventar;
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Zem.
     */
    private void zalozProstoryHry() {
        
        // vytvářejí se jednotlivé prostory
          
        Prostor planetaMerkur = new Prostor("Merkur", "planéte Merkúr, ktorá je na strane privrátenej k Slnku horúca\nna strane odvrátenej studená ako ľad", false, false, 1, 1);
        Prostor planetaVenusa = new Prostor("Venusa", "planéte Venuša, ktorá je veľkosťou najviac podobná Zemi, ale zároveň\nnajhorúcejšia", false, false, 1, 1);
        Prostor planetaZem = new Prostor("Zem","planéte Zem, na ktorej začíname, plná života a vody", false, false, 1, 1);
        Prostor planetaMars = new Prostor("Mars", "planéte Mars, pokrytá oxidom železitým, ktorý jej dáva červenú farbu", false, false, 1, 1);
        Prostor planetaJupiter = new Prostor("Jupiter", "planéte Jupiter, najväčší plynný obor, najväčšia planéta\nSlnečnej sústavy", false, true, 1, 1);
        Prostor planetaSaturn = new Prostor("Saturn" ,"planéte Saturn, plynný obor, do žlta sfarbená, s nádhernými prstencami", false, true, 1, 1);
        Prostor planetaUran = new Prostor("Uran", "planéte Urán, plynný obor, otočená inak ako iné planéty", false, true, 1, 1);
        Prostor planetaNeptun = new Prostor("Neptun", "planéte Neptún, plynný obor, modrá ako obloha vďaka metánu", false, true, 1, 1);          
        Prostor mesiacMesiac = new Prostor("Mesiac", "mesiaci Mesiac, jediný prirodzený satelit Zeme", false, false, 1, 1);
        Prostor mesiacPhobos = new Prostor("Phobos", "mesiaci Phobos, väčší z dvojice mesiacov, ktoré má Mars", true, false, 1, 1);
        Prostor mesiacDeimos = new Prostor("Deimos", "mesiaci Deimos, menší z dvojice mesiacov, ktoré má Mars", false, false, 1, 1);        
        Prostor mesiacGanymedes = new Prostor("Ganymedes", "mesiaci Ganymedes, najväčší mesiac v Slnečnej sústave\nväčší ako samotný Merkúr", false, false, 1, 1);
        Prostor mesiacKallisto = new Prostor("Kallisto", "mesiaci Kallisto, zložený z oxidu uhličitého\nkremičitanova organických látok", true, false, 1, 1);
        Prostor mesiacIo = new Prostor("Io", "mesiaci Io, vulkanicky najaktívnejšie teleso v Slnečnej sústave\nz diaľky vyzerajúci ako pizza", false, false, 1, 1);
        Prostor mesiacEuropa = new Prostor("Europa", "mesiaci Európa, pokrytý ľadom, pod ktorého povrchom sa pravdepodobne\nnachádza obrovský oceán", false, false, 1, 1);
        Prostor mesiacTitan = new Prostor("Titan", "mesiaci Titan, mesiac väčší ako Merkúr, ktorého atmosféra\nje tak obrovská, že kvôli nej nevidno jeho povrch ", false, false, 1, 1);
        Prostor mesiacJapetus = new Prostor("Japetus", "mesiaci Japetus, ktorý má veľmi nízku hustotu", true, false, 1, 1);
        Prostor mesiacTitania = new Prostor("Titania", "mesiaci Titánia, známy obrovským kaňonom, ktorý je väčší ako\nGrand Canyon", false, false, 1, 1);
        Prostor mesiacTriton = new Prostor("Triton", "mesiaci Triton, najväčší mesiac Neptúna a zároveň jediný\nktorý má guľatý tvar", false, false, 1, 1);
          
        // přiřazují se průchody mezi prostory (sousedící prostory)
        
        planetaMerkur.setVychod(planetaVenusa);
        planetaVenusa.setVychod(planetaZem);
        planetaVenusa.setVychod(planetaMerkur);
        planetaZem.setVychod(mesiacMesiac);
        planetaZem.setVychod(planetaMars);
        planetaZem.setVychod(planetaVenusa);
        planetaMars.setVychod(mesiacPhobos);
        planetaMars.setVychod(mesiacDeimos);
        planetaMars.setVychod(planetaJupiter);
        planetaMars.setVychod(planetaZem);
        planetaJupiter.setVychod(mesiacGanymedes);
        planetaJupiter.setVychod(mesiacKallisto);
        planetaJupiter.setVychod(mesiacIo);
        planetaJupiter.setVychod(mesiacEuropa);
        planetaJupiter.setVychod(planetaSaturn);
        planetaJupiter.setVychod(planetaMars);
        planetaSaturn.setVychod(mesiacTitan);
        planetaSaturn.setVychod(mesiacJapetus);
        planetaSaturn.setVychod(planetaUran);
        planetaSaturn.setVychod(planetaJupiter);
        planetaUran.setVychod(mesiacTitania);
        planetaUran.setVychod(planetaNeptun);
        planetaUran.setVychod(planetaSaturn);
        planetaNeptun.setVychod(mesiacTriton);
        planetaNeptun.setVychod(planetaUran);
        mesiacMesiac.setVychod(planetaZem);
        mesiacPhobos.setVychod(planetaMars);
        mesiacDeimos.setVychod(planetaMars);
        mesiacGanymedes.setVychod(planetaJupiter);
        mesiacKallisto.setVychod(planetaJupiter);
        mesiacIo.setVychod(planetaJupiter);
        mesiacEuropa.setVychod(planetaJupiter);
        mesiacTitan.setVychod(planetaSaturn);
        mesiacJapetus.setVychod(planetaSaturn);
        mesiacTitania.setVychod(planetaUran);
        mesiacTriton.setVychod(planetaNeptun);

        // vytvoříme několik věcí
        
        Vec veternyStit = new Vec("veterny_stit", "Tento štít slúži na priblíženie sa k plynným obrom", true);
        Vec opravnyBalik = new Vec("opravny_balik", "Balík slúži na opravenie lodi, vráti späť celý život", true);
        Vec palivo = new Vec("palivo", "Palivo slúži na doplnenie paliva lode, doplní palivo do plna", true);
        Vec hladacInteligencie = new Vec("hladac_inteligencie", "Hľadač slúži na vyhľadávanie mimozemštanov", true);
        Vec kvapalnyVodik = new Vec("kvapalny_vodik", "Kvapalný vodík slúži ako súčasť paliva do rakety", true);
        Vec protonovaStrela = new Vec("protonova_strela","Túto strelu použiješ v prípade, že nájdení mimozemštania nebudú priateľskí", true);
        Vec laserovyLuc = new Vec("laserovy_unosny_luc","Lúč použiješ, ked budeš chcieť preskúmať flóru a faunu na inej planéte", true);
        Vec kvapalnyKyslik = new Vec("kvapalny_kyslik","Kvapalný kyslík slúži ako súčasť paliva do rakety", true);
        Vec kreslitelPoli = new Vec("kreslitel_poli","Tento nástroj je užitočný pri interakcii s nižšou mimozemskou inteligenciou", true);       
        Vec kontAmerika = new Vec("Amerika","Amerika, kontinent známy veľkými jazerami, dlhým horským systémom a pralesom", false);
        Vec kontAfrika = new Vec("Afrika","Afrika, kontinent známy savanami, rozmanitou flórou a faunou a daždovými pralesmi", false);
        Vec kontEurazia = new Vec("Eurazia","Eurázia, kontinent, ktorý je najľudnatejší a najväčší", false);
        Vec kontAustralia = new Vec("Australia","Austrália, najmenší kontinent, ktorý reprezentujú púšte", false);
        Vec kontAntarktida = new Vec("Antarktida","Antarktída, kontinent pokrytý ľadom, ktorý je najchladnejší", false);
        Vec oceany = new Vec("oceany","Obsahujú veľa vody", false);
        Vec zvieraPes = new Vec("Hafanek","Nebudes na ceste sám", true);
        Vec radiovyVysielac = new Vec("radiový_vysielac","Dáva možnosť komunikovať", true);
        Vec anortozit = new Vec("anortozit","Hlbinná vyvrenina zložená takmer výhradne z bázických živcov anortitu, bytownitu a labradoritu",true);
        Vec ilmenit = new Vec("ilmenit","Minerál, ktorý sa obyčajne vyskytuje vo forme celistvých alebo zrnitých agregátov", true);
        Vec kraterPanvaCaloris = new Vec("krater_Panva_Caloris","Najväčší kráter na povrchu Merkúra a zároveň jeden z najväčších kráterov v Slnečnej sústave", false);
        Vec kraterDegas = new Vec("krater_Degas","Impaktný kráter starý 500 miliónov rokov s priemerom 45 – 60 km", false);
        Vec kraterBeethoven = new Vec("krater_Beethoven","Druhý najväčší impaktný kráter na Merkúre", false);
        Vec oxidSiricity = new Vec("oxid_siricity","Oxid siričitý je bezfarebný reaktívny plyn, ktorý môže byť aj jedovatý", true);
        Vec kyselinaSirova = new Vec("kyselina_sirova","Kyselina sírová je silná minerálna, anorganická kyselina, miešateľná s vodou v neobmedzenom pomere", true);
        Vec horyMaxwellMontes = new Vec("Maxwell_Montes","Maxwell Montes je horské pásmo na Venuši. Nachádza sa v ňom aj najvyšší bod Venuše", false);
        Vec aphroditeTerra= new Vec("Aphrodite_Terra","Aphrodite Terra je tektonická vyvýšenina", false);
        Vec kremik = new Vec("kremik", "Kremík je pomerne tvrdý polokov s vysokou afinitou ku kyslíku", true);
        Vec regolit = new Vec("regolit", "Regolit je nespevnený heterogénny materiál, pokrývajúci povrch Mesiaca", true);
        Vec kraterTycho = new Vec("krater_Tycho", "Kráter Tycho je impaktný kráter, ktorý vznikol pred 109 miliónmi rokov", false);
        Vec kraterKopernik = new Vec("krater_Kopernik", "Kráter Koperník je impaktný kráter, ktorý vznikol pred 810 miliónmi rokov ", false);
        Vec oceanBurok = new Vec("Ocean_Burok", "Oceán Búrok je najväčšie mesačné more", false);
        Vec oxidZelezity = new Vec("oxid_zelezity", "Oxid železitý je amfotérny oxid železa hnedočervenej farby", true);
        Vec hematit = new Vec("hematit", "Hematit je minerál kryštalizujúci v trigonálnej sústave", true);
        Vec olympusMons = new Vec("Olympus_Mons", "Olympus Mons je najvyššia známa hora Slnečnej sústavy", false);
        Vec vallesMarineris = new Vec("Valles_Marineris", "Valles Marineris, je najväčší riftový systém v slnečnej sústave", false);
        Vec tharsis = new Vec("Tharsis", "Tharsis je obrovská vulkanická oblasť", false);
        Vec materialUhlik = new Vec("uhlik", "Uhlík tvorí základný stavebný kameň všetkých organických zlúčenín", true);
        Vec materialVodik = new Vec("vodik", "Vodík je číry, bezfarebný plyn bez chuti a zápachu", true);
        Vec materialHelium = new Vec("helium", "Hélium je bezfarebný plyn, bez chuti a zápachu, chemicky úplne inertný", true);
        Vec zmrznutyAmoniak = new Vec("zmrznuty_amoniak", "Amoniak je toxický, žieravý, bezfarebný plyn so silne dráždivým zápachom", true);
        Vec velkaSkvrna = new Vec("Velka_cervena_skvrna", "Veľká červená škvrna je obrovský hurikán, väčší ako samotná Zem", false);
        Vec galileoRegio= new Vec("Galileo_Regio", "Galileo Regio je veľká, tmavo zafarbená, povrchová štruktúra", false);
        Vec kraterAsgard = new Vec("krater_Asgard", "Asgard je druhý najväčší impaktný kráter", false);
        Vec tohilMons = new Vec("Tohil_Mons", " Tohil Mons je hora vysoká 5,4 km", false);
        Vec materialLad = new Vec("lad", "Ľad je pevné skupenstvo vody", true);
        Vec lentikuly = new Vec("lentikuly","Lentikuly sú hladké ľadové planiny a okrúhle či podlhovasté škvrny", false);
        Vec prstence = new Vec("prstence", "Prstence sú tvorené množstvom drobných čiastočiek", false);
        Vec materialDusik = new Vec("dusik", "Dusík je plyn bez farby a zápachu", true);
        Vec ligeiaMare = new Vec("Ligeia_Mare", "Ligeia Mare je metánové jazero na povrchu Titana", false);
        Vec kraterTurgis = new Vec("krater_Turgis", "Kráter Turgis je obrovský kráter s priemerom 580 km", false);
        Vec materialMetan = new Vec("metan", "Metán je najjednoduchší uhľovodík", true);
        Vec messinaChasma = new Vec("Messina_Chasma", "Messina Chasma je obrovský kaňon na povrchu Titánie", false);
        Vec gejziryDusika = new Vec("gejziry_dusika", "Tieto gejzíry na povrchu Tritona vystreľujú do atmosféry dusík", false);
        
        // umístíme věci do prostorů
        
        mesiacTriton.vlozVec(gejziryDusika);
        mesiacTriton.vlozVec(materialDusik);
        planetaNeptun.vlozVec(materialVodik);
        planetaNeptun.vlozVec(materialHelium);
        planetaNeptun.vlozVec(materialMetan);
        planetaNeptun.vlozVec(palivo);
        mesiacTitania.vlozVec(messinaChasma);
        planetaUran.vlozVec(materialVodik);
        planetaUran.vlozVec(materialHelium);
        planetaUran.vlozVec(materialMetan);
        mesiacJapetus.vlozVec(kraterTurgis);
        mesiacTitan.vlozVec(ligeiaMare);
        mesiacTitan.vlozVec(materialDusik);
        planetaSaturn.vlozVec(prstence);
        planetaSaturn.vlozVec(materialVodik);
        planetaSaturn.vlozVec(materialHelium);
        mesiacEuropa.vlozVec(lentikuly);
        mesiacEuropa.vlozVec(materialLad);
        mesiacIo.vlozVec(tohilMons);
        mesiacIo.vlozVec(oxidSiricity);
        mesiacKallisto.vlozVec(kraterAsgard);
        mesiacKallisto.vlozVec(oxidSiricity);
        mesiacGanymedes.vlozVec(galileoRegio);
        planetaJupiter.vlozVec(materialVodik);
        planetaJupiter.vlozVec(materialHelium);
        planetaJupiter.vlozVec(zmrznutyAmoniak);
        planetaJupiter.vlozVec(velkaSkvrna);
        mesiacPhobos.vlozVec(materialUhlik);
        mesiacDeimos.vlozVec(materialUhlik);
        mesiacDeimos.vlozVec(palivo);
        planetaMars.vlozVec(oxidZelezity);
        planetaMars.vlozVec(hematit);
        planetaMars.vlozVec(olympusMons);
        planetaMars.vlozVec(vallesMarineris);
        planetaMars.vlozVec(tharsis);
        planetaMerkur.vlozVec(veternyStit);
        planetaMerkur.vlozVec(anortozit);
        planetaMerkur.vlozVec(ilmenit);
        planetaMerkur.vlozVec(kraterPanvaCaloris);
        planetaMerkur.vlozVec(kraterDegas);
        planetaMerkur.vlozVec(kraterBeethoven);
        planetaVenusa.vlozVec(oxidSiricity);
        planetaVenusa.vlozVec(kyselinaSirova);
        planetaVenusa.vlozVec(horyMaxwellMontes);
        planetaVenusa.vlozVec(aphroditeTerra);
        planetaZem.vlozVec(kontAmerika);
        planetaZem.vlozVec(kontAfrika);
        planetaZem.vlozVec(kontEurazia);
        planetaZem.vlozVec(kontAustralia);
        planetaZem.vlozVec(kontAntarktida);
        planetaZem.vlozVec(oceany);
        planetaZem.vlozVec(zvieraPes);
        planetaZem.vlozVec(radiovyVysielac);
        mesiacMesiac.vlozVec(opravnyBalik);
        mesiacMesiac.vlozVec(kremik);
        mesiacMesiac.vlozVec(regolit);
        mesiacMesiac.vlozVec(kraterTycho);
        mesiacMesiac.vlozVec(kraterKopernik);
        mesiacMesiac.vlozVec(oceanBurok);
        mesiacGanymedes.vlozVec(opravnyBalik);
        mesiacTitania.vlozVec(opravnyBalik);
        mesiacTriton.vlozVec(protonovaStrela);
        mesiacEuropa.vlozVec(kvapalnyVodik);
        mesiacDeimos.vlozVec(laserovyLuc);
        mesiacTitan.vlozVec(kvapalnyKyslik);
        mesiacTitan.vlozVec(palivo);
        planetaUran.vlozVec(kreslitelPoli);
        mesiacIo.vlozVec(hladacInteligencie);
        
        aktualniProstor = planetaZem;  // hra začíná na Zemi
    
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve kterém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }
    
    /**
     *  Metoda testuje, či hráč vyhral alebo nie, porovnáva aktuálny
     *  priestor s cieľovým priestorom a kontroluje, či 
     *  hráč zozbieral všetky potrebné predmety,
     *  pri testovaní využíva metódu jeVInventari("názov_predmetu") 
     *
     *@return  true = hráč vyhral, false = hráč prehral
     */
    public boolean hracVyhral() {
        if (aktualniProstor.getNazev().equals(CILOVY_PROSTOR) && inventar.jeVInventari("hladac_inteligencie") && 
        inventar.jeVInventari("kvapalny_vodik") && inventar.jeVInventari("protonova_strela") && inventar.jeVInventari("laserovy_unosny_luc") &&
        inventar.jeVInventari("kvapalny_kyslik") && inventar.jeVInventari("kreslitel_poli")) {
            return true;
        }
        
        return false;
    }
    
    /**
     *  Metoda vracia hodnotu premennej hracPrehral, ktorá obsahuje 
     *  informáciu o tom, či hráč prehral alebo nie
     *
     *@return  true = hráč prehral, false = hráč neprehral
     */
    public boolean getHracPrehral() {
        return hracPrehral;
    }
    
    /**
     *  Metoda nastavuje hodnotu premennej hracPrehral, ktorá obsahuje 
     *  informáciu o tom, či hráč prehral alebo nie
     *
     *@param hracPrehral true = hráč prehral, false = hráč vyhral
     */
    public void setHracPrehral(boolean hracPrehral) {
        this.hracPrehral = hracPrehral;
    }

}
