/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * Interface, ktorý musia triedy implementovať, aby sa aktualizovali všetky subjekty
 * @author Juraj Szücs
 */
public interface Observer {

    /**
     * Metóda aktualizuje všetky subjekty.
     */
    void update();
}
