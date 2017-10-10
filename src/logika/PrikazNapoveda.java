package logika;

/**
 *  Třída {@code PrikazNapoveda} implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Jarmila Pavlickova, Luboš Pavlíček, Jan Riha, Juraj Szucs
 * @version    31.12.2016
 */
class PrikazNapoveda implements IPrikaz {
    
    private static final String NAZEV = "napoveda";
    private SeznamPrikazu platnePrikazy;
    
    /**
     *  Konštruktor objektov triedy PrikazNapoveda
     *  
     *  @param platnePrikazy seznam příkazů,
     *                       které je možné ve hře použít,
     *                       aby je nápověda mohla zobrazit uživateli. 
     */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    @Override
    public String proved(String... parametry) {
        return "Tvojou úlohou je preskúmať Slnečnú sústavu a\n" 
        + "nájsť 6 vecí, ktoré sú potrebné k vyslaniu flotily\n"
        + "na kontaktovanie mimozemskej civilizácie a vrátit\n"
        + "sa úspešne na Zem\n"
        + "\n"
        + "Môžeš zadať tieto príkazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
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
