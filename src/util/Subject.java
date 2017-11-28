/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * Interface, ktorý musia triedy implementovať, aby mohli manipulovať s pozorovateľmi
 * @author Juraj Szücs
 */
public interface Subject {

    /**
     *  Metóda pridá pozorovateľa
     * @param observer Pozorovateľ
     */
    void registerObserver(Observer observer);

    /**
     *  Metóda odoberie pozorovateľa
     * @param observer Pozorovateľ
     */
    void removeObserver(Observer observer);

    /**
     * Metóda upozorní pozorovateľov.
     */
    void notifyObservers();
}
