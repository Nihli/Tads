/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somaarea;

/**
 *
 * @author Lia
 */
public class Quadrado implements Superficie {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado*lado;
    }
    
}
