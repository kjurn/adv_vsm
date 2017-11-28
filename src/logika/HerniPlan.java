package logika;

import java.util.ArrayList;
import java.util.List;
import util.Observer;
import util.Subject;


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
public class HerniPlan implements Subject {

    private static final String CILOVY_PROSTOR = "Zem";
    private Prostor aktualniProstor;
    
    private List<Observer> listObserveru = new ArrayList<>();

    /**
     *  Konstruktor, který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Zem.
     *  
     */
    
    public HerniPlan() {
        zalozProstoryHry();
    }
    
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Zem.
     */
    private void zalozProstoryHry() {
        
        // vytvářejí se jednotlivé prostory
          
        Prostor planetaMerkur = new Prostor("Merkur", "planéte Merkúr, ktorá je na strane privrátenej k Slnku horúca\nna strane odvrátenej studená ako ľad", false, false, 50, 48);
        Prostor planetaVenusa = new Prostor("Venusa", "planéte Venuša, ktorá je veľkosťou najviac podobná Zemi, ale zároveň\nnajhorúcejšia", false, false, 120, 48);
        Prostor planetaZem = new Prostor("Zem","planéte Zem, na ktorej začíname, plná života a vody", false, false, 190, 48);
        Prostor planetaMars = new Prostor("Mars", "planéte Mars, pokrytá oxidom železitým, ktorý jej dáva červenú farbu", false, false, 270, 48);
        Prostor planetaJupiter = new Prostor("Jupiter", "planéte Jupiter, najväčší plynný obor, najväčšia planéta\nSlnečnej sústavy", false, true, 330, 120);
        Prostor planetaSaturn = new Prostor("Saturn" ,"planéte Saturn, plynný obor, do žlta sfarbená, s nádhernými prstencami", false, true, 280, 220);
        Prostor planetaUran = new Prostor("Uran", "planéte Urán, plynný obor, otočená inak ako iné planéty", false, true, 180, 235);
        Prostor planetaNeptun = new Prostor("Neptun", "planéte Neptún, plynný obor, modrá ako obloha vďaka metánu", false, true, 60, 210);          
        Prostor mesiacMesiac = new Prostor("Mesiac", "mesiaci Mesiac, jediný prirodzený satelit Zeme", false, false, 180, 100);
        Prostor mesiacPhobos = new Prostor("Phobos", "mesiaci Phobos, väčší z dvojice mesiacov, ktoré má Mars", true, false, 250, 10);
        Prostor mesiacDeimos = new Prostor("Deimos", "mesiaci Deimos, menší z dvojice mesiacov, ktoré má Mars", false, false, 305, 10);        
        Prostor mesiacGanymedes = new Prostor("Ganymedes", "mesiaci Ganymedes, najväčší mesiac v Slnečnej sústave\nväčší ako samotný Merkúr", false, false, 355, 70);
        Prostor mesiacKallisto = new Prostor("Kallisto", "mesiaci Kallisto, zložený z oxidu uhličitého\nkremičitanova organických látok", true, false, 337, 187);
        Prostor mesiacIo = new Prostor("Io", "mesiaci Io, vulkanicky najaktívnejšie teleso v Slnečnej sústave\nz diaľky vyzerajúci ako pizza", false, false, 390, 100);
        Prostor mesiacEuropa = new Prostor("Europa", "mesiaci Európa, pokrytý ľadom, pod ktorého povrchom sa pravdepodobne\nnachádza obrovský oceán", false, false, 385, 155);
        Prostor mesiacTitan = new Prostor("Titan", "mesiaci Titan, mesiac väčší ako Merkúr, ktorého atmosféra\nje tak obrovská, že kvôli nej nevidno jeho povrch ", false, false, 235, 167);
        Prostor mesiacJapetus = new Prostor("Japetus", "mesiaci Japetus, ktorý má veľmi nízku hustotu", true, false, 305, 269);
        Prostor mesiacTitania = new Prostor("Titania", "mesiaci Titánia, známy obrovským kaňonom, ktorý je väčší ako\nGrand Canyon", false, false, 155, 182);
        Prostor mesiacTriton = new Prostor("Triton", "mesiaci Triton, najväčší mesiac Neptúna a zároveň jediný\nktorý má guľatý tvar", false, false, 70, 150);
          
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
        
        Vec veternyStit = new Vec("veterny_stit", "Veterný štít", "Tento štít slúži na priblíženie sa k plynným obrom", true, "/zdroje/items/shield.png"); //done
        Vec opravnyBalik = new Vec("opravny_balik", "Opravný balík", "Balík slúži na opravenie lodi, vráti späť celý život", true, "/zdroje/items/repair.png"); //done
        Vec palivo = new Vec("palivo", "Palivo", "Palivo slúži na doplnenie paliva lode, doplní palivo do plna", true, "/zdroje/items/fuel.png"); //done
        Vec hladacInteligencie = new Vec("hladac_inteligencie", "Hľadač inteligencie", "Hľadač slúži na vyhľadávanie mimozemštanov", true, "/zdroje/items/alienfinder.png"); //done
        Vec kvapalnyVodik = new Vec("kvapalny_vodik", "Kvapalný vodík", "Kvapalný vodík slúži ako súčasť paliva do rakety", true, "/zdroje/items/liquid_h.png"); //done
        Vec protonovaStrela = new Vec("protonova_strela","Protónová strela", "Túto strelu použiješ v prípade, že nájdení mimozemštania nebudú priateľskí", true, "/zdroje/items/missile.png"); //done
        Vec laserovyLuc = new Vec("laserovy_unosny_luc","Laserový únosný lúč", "Lúč použiješ, ked budeš chcieť preskúmať flóru a faunu na inej planéte", true, "/zdroje/items/laser.png"); //done
        Vec kvapalnyKyslik = new Vec("kvapalny_kyslik","Kvapalný kyslík", "Kvapalný kyslík slúži ako súčasť paliva do rakety", true, "/zdroje/items/liquid_o.png"); //done
        Vec kreslitelPoli = new Vec("kreslitel_poli","Kresliteľ polí", "Tento nástroj je užitočný pri interakcii s nižšou mimozemskou inteligenciou", true, "/zdroje/items/kreslitel.png"); //done     
        Vec kontAmerika = new Vec("Amerika","Amerika", "Amerika, kontinent známy veľkými jazerami, dlhým horským systémom a pralesom", false, "/zdroje/items/america.png"); //done
        Vec kontAfrika = new Vec("Afrika","Afrika", "Afrika, kontinent známy savanami, rozmanitou flórou a faunou a daždovými pralesmi", false, "/zdroje/items/africa.png"); //done
        Vec kontEurazia = new Vec("Eurazia","Eurázia", "Eurázia, kontinent, ktorý je najľudnatejší a najväčší", false, "/zdroje/items/eurasia.png"); //done
        Vec kontAustralia = new Vec("Australia","Austrália", "Austrália, najmenší kontinent, ktorý reprezentujú púšte", false, "/zdroje/items/australia.png"); //done
        Vec kontAntarktida = new Vec("Antarktida","Antarktída", "Antarktída, kontinent pokrytý ľadom, ktorý je najchladnejší", false, "/zdroje/items/antarctica.png"); //done
        Vec oceany = new Vec("oceany","Oceány", "Obsahujú veľa vody", false, "/zdroje/items/oceans.png"); //done
        Vec zvieraPes = new Vec("Hafanek","Hafánek", "Nebudes na ceste sám", true, "/zdroje/items/dog.png"); //done
        Vec radiovyVysielac = new Vec("radiovy_vysielac","Rádiový vysielač", "Dáva možnosť komunikovať", true, "/zdroje/items/satellite.png"); //done
        Vec anortozit = new Vec("anortozit", "Anortozit", "Hlbinná vyvrenina zložená takmer výhradne z bázických živcov anortitu, bytownitu a labradoritu", true, "/zdroje/items/anortozit.jpg"); //done
        Vec ilmenit = new Vec("ilmenit", "Ilmenit", "Minerál, ktorý sa obyčajne vyskytuje vo forme celistvých alebo zrnitých agregátov", true, "/zdroje/items/ilmenit.JPG"); //done
        Vec kraterPanvaCaloris = new Vec("krater_Panva_Caloris","Kráter Panva Caloris", "Najväčší kráter na povrchu Merkúra a zároveň jeden z najväčších kráterov v Slnečnej sústave", false, "/zdroje/items/crater.jpg"); //done
        Vec kraterDegas = new Vec("krater_Degas","Kráter Degas", "Impaktný kráter starý 500 miliónov rokov s priemerom 45 – 60 km", false, "/zdroje/items/crater.jpg"); //done
        Vec kraterBeethoven = new Vec("krater_Beethoven","Kráter Beethoven", "Druhý najväčší impaktný kráter na Merkúre", false, "/zdroje/items/crater.jpg"); //done
        Vec oxidSiricity = new Vec("oxid_siricity","Oxid siričitý", "Oxid siričitý je bezfarebný reaktívny plyn, ktorý môže byť aj jedovatý", true, "/zdroje/items/oxidsir.png"); //done
        Vec kyselinaSirova = new Vec("kyselina_sirova","Kyselina sírová", "Kyselina sírová je silná minerálna, anorganická kyselina, miešateľná s vodou v neobmedzenom pomere", true, "/zdroje/items/h2so4.png"); //done
        Vec horyMaxwellMontes = new Vec("Maxwell_Montes","Maxwell Montes", "Maxwell Montes je horské pásmo na Venuši. Nachádza sa v ňom aj najvyšší bod Venuše", false, "/zdroje/items/mountains.png"); //done
        Vec aphroditeTerra= new Vec("Aphrodite_Terra","Aphrodite Terra", "Aphrodite Terra je tektonická vyvýšenina", false, "/zdroje/items/aphroditet.jpg"); //done
        Vec kremik = new Vec("kremik","Kremík", "Kremík je pomerne tvrdý polokov s vysokou afinitou ku kyslíku", true, "/zdroje/items/kremik.jpg"); //done
        Vec regolit = new Vec("regolit", "Regolit", "Regolit je nespevnený heterogénny materiál, pokrývajúci povrch Mesiaca", true, "/zdroje/items/regolit.jpg"); //done
        Vec kraterTycho = new Vec("krater_Tycho", "Kráter Tycho", "Kráter Tycho je impaktný kráter, ktorý vznikol pred 109 miliónmi rokov", false, "/zdroje/items/crater.jpg"); //done
        Vec kraterKopernik = new Vec("krater_Kopernik", "Kráter Kopernik", "Kráter Koperník je impaktný kráter, ktorý vznikol pred 810 miliónmi rokov ", false, "/zdroje/items/crater.jpg"); //done
        Vec oceanBurok = new Vec("Ocean_Burok", "Oceán Búrok", "Oceán Búrok je najväčšie mesačné more", false, "/zdroje/items/oceanburok.png"); //done
        Vec oxidZelezity = new Vec("oxid_zelezity", "Oxid železitý", "Oxid železitý je amfotérny oxid železa hnedočervenej farby", true, "/zdroje/items/oxidzel.jpg"); //done
        Vec hematit = new Vec("hematit", "Hematit", "Hematit je minerál kryštalizujúci v trigonálnej sústave", true, "/zdroje/items/hematit.jpg"); //done
        Vec olympusMons = new Vec("Olympus_Mons", "Olympus Mons", "Olympus Mons je najvyššia známa hora Slnečnej sústavy", false, "/zdroje/items/olympusmons.jpg"); //done
        Vec vallesMarineris = new Vec("Valles_Marineris", "Valles Marineris", "Valles Marineris, je najväčší riftový systém v slnečnej sústave", false, "/zdroje/items/valles_marineris.jpg"); //done
        Vec tharsis = new Vec("Tharsis", "Tharsis", "Tharsis je obrovská vulkanická oblasť", false, "/zdroje/items/tharsis.jpg"); //done
        Vec materialUhlik = new Vec("uhlik", "Uhlík", "Uhlík tvorí základný stavebný kameň všetkých organických zlúčenín", true, "/zdroje/items/uhlik.png"); //done
        Vec materialVodik = new Vec("vodik", "Vodík", "Vodík je číry, bezfarebný plyn bez chuti a zápachu", true, "/zdroje/items/vodik.png"); //done
        Vec materialHelium = new Vec("helium", "Hélium", "Hélium je bezfarebný plyn, bez chuti a zápachu, chemicky úplne inertný", true, "/zdroje/items/helium.png"); //done
        Vec zmrznutyAmoniak = new Vec("zmrznuty_amoniak", "Zmrznutý amoniak", "Amoniak je toxický, žieravý, bezfarebný plyn so silne dráždivým zápachom", true, "/zdroje/items/amoniak.png"); //done
        Vec velkaSkvrna = new Vec("Velka_cervena_skvrna", "Veľká Červená Škvrna", "Veľká červená škvrna je obrovský hurikán, väčší ako samotná Zem", false, "/zdroje/items/redspot.jpg"); //done
        Vec galileoRegio= new Vec("Galileo_Regio", "Galileo Regio", "Galileo Regio je veľká, tmavo zafarbená, povrchová štruktúra", false, "/zdroje/items/regio.jpg"); //done
        Vec kraterAsgard = new Vec("krater_Asgard", "Kráter Asgard", "Asgard je druhý najväčší impaktný kráter", false, "/zdroje/items/crater.jpg"); //done
        Vec tohilMons = new Vec("Tohil_Mons", "Tohils Mons", "Tohil Mons je hora vysoká 5,4 km", false, "/zdroje/items/mountains.png"); //done
        Vec materialLad = new Vec("lad", "Ľad", "Ľad je pevné skupenstvo vody", true, "/zdroje/items/ice.png"); //done
        Vec lentikuly = new Vec("lentikuly","Lentikuly", "Lentikuly sú hladké ľadové planiny a okrúhle či podlhovasté škvrny", false, "/zdroje/items/lentikuly.jpg"); //done
        Vec prstence = new Vec("prstence", "Prstence", "Prstence sú tvorené množstvom drobných čiastočiek", false, "/zdroje/items/ringssat.jpg"); //done
        Vec materialDusik = new Vec("dusik", "Dusík", "Dusík je plyn bez farby a zápachu", true, "/zdroje/items/dusik.png"); //done
        Vec ligeiaMare = new Vec("Ligeia_Mare", "Ligeia Mare", "Ligeia Mare je metánové jazero na povrchu Titana", false, "/zdroje/items/ligeamare.jpg"); //done
        Vec kraterTurgis = new Vec("krater_Turgis", "Kráter Turgis" , "Kráter Turgis je obrovský kráter s priemerom 580 km", false, "/zdroje/items/crater.jpg"); //done
        Vec materialMetan = new Vec("metan", "Metán", "Metán je najjednoduchší uhľovodík", true, "/zdroje/items/metan.png"); //done
        Vec messinaChasma = new Vec("Messina_Chasma", "Messina Chasma", "Messina Chasma je obrovský kaňon na povrchu Titánie", false, "/zdroje/items/messina.jpg"); //done
        Vec gejziryDusika = new Vec("gejziry_dusika", "Gejzíry dusíka", "Tieto gejzíry na povrchu Tritona vystreľujú do atmosféry dusík", false, "/zdroje/items/geyser.png"); //done
        
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
       notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        listObserveru.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listObserveru.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer listObserveruItem : listObserveru) {
            listObserveruItem.update();
        }
    }
    
    /**
     * Metóda vráti cieľový priestor, na ktorom sa začína
     * 
     * @return CILOVY_PROSTOR cieľový priestor
     */
    public String getCilovyProstor() {
        return CILOVY_PROSTOR;
    }

}
