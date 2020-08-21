/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somaarea;

import java.util.List;

/**
 *
 * @author Lia
 */
public class SomaAreas<E extends Superficie> {

    public double calculaArea(E array[]) {
        double soma=0.0;
        for (E e: array) {
            soma +=e.area();
        }
        return soma;
    }
    
}
