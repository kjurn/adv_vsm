package logika;

import java.util.ArrayList;
import java.util.List;
import util.Observer;
import util.Subject;



/**
 * Trieda {@code VesmirnaLod} popisuje vesmírnu lod, ktorá
 * má v sebe uložený stav vesmírnej lode.
 * Táto trieda je súčasťou jednoduchej textovej hry.
 * 
 * @author  Juraj Szucs
 * @version 31.12.2016
 */
public class VesmirnaLod implements Subject {
 
    private int zivotLode = 100;
    private int palivoLode = 100;
    private List<Observer> listObserveru = new ArrayList<>();
    
    /**
     * Metóda vracia hodnotu atribútu zivotLode
     * 
     * @return život lode
     */
    public int getZivotLode()
    {
        return zivotLode;
    }
    
    /**
     * Metóda vracia hodnotu atribútu palivoLode    
     * 
     * @return palivo lode
     */
    
    public int getPalivoLode() {
        return palivoLode;
    }
    
    /**
     * Metóda nastaví hodnotu atribútu zivotLode na základe
     * parametra poklesZivota. Ak neklesne, tak nastaví zivotLode
     * na 100
     * 
     * @param poklesZivota ak je true, tak život klesne, ak je false,
     * život sa nastaví na pôvodnú hodnotu
     */
    public void setZivotLode(boolean poklesZivota) {
        if (poklesZivota) {
            zivotLode -= 10;
        } else {
            zivotLode = 100;
        }
    }
    
    public void setPalivoLode(boolean poklesPaliva) {
        if (poklesPaliva) {
            palivoLode -= 5;
        } else {
            palivoLode = 100;
        }
    }
    
    /**
     * Metoda testuje, koľko života lodi ešte ostáva a vracia textový
     * reťazec na základe týchto testov
     * 
     * @param zostatokZivota Zostatok života lode 
     * @return Stav života lode
     */
    public String popisZivota(int zostatokZivota) {
        if (zostatokZivota < 30) {
            return "Lodi zostáva " + zostatokZivota +
            " života, čo je kritická hranica.\nUrýchlene nájdi a použi opravný balík";
        } else if (zostatokZivota == 50) {
            return "Lodi zostáva ešte polovica života";
        } else {
            return "Lodi zostáva "+ zostatokZivota + " života";
        }
    }
    
            /**
     * Metoda testuje, koľko paliva lodi ešte ostáva a vracia textový
     * reťazec na základe týchto testov
     * 
     * @param zostatokPaliva Zostatok paliva lode 
     * @return Stav paliva lode
     */
    
    public String popisPaliva(int zostatokPaliva) {
        if (zostatokPaliva < 20) {
            return "Lodi zostáva " + zostatokPaliva +
            " paliva, čo je kritická hranica.\nUrýchlene nájdi palivo a natankuj";
        } else if (zostatokPaliva == 50) {
            return "Lodi zostáva ešte polovica paliva";
        } else {
            return "Lodi zostáva "+ zostatokPaliva + " paliva";
        }
    }       

        /**
     *  Metóda pridáva pozorovateľov do listu pozorovateľov
     * @param observer Pozorovateľ
     */
    @Override
    public void registerObserver(Observer observer) {
        listObserveru.add(observer);
    }

    /**
     * Metóda odoberá pozorovateľov z listu pozorovateľov
     * @param observer Pozorovateľ
     */
    @Override
    public void removeObserver(Observer observer) {
        listObserveru.remove(observer);
    }

    /**
     *  Metóda aktualizuje pozorovateľov v liste pozorovateľov.
     */
    @Override
    public void notifyObservers() {
        for (Observer listObserveruItem : listObserveru) {
            listObserveruItem.update();
        }
    }
 }
