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
public class Circunferencia implements Superficie{
    private double raio;

    public Circunferencia(double raio) {
        this.raio = raio;
    }
    
    @Override
    public double area() {
        return (3.14*this.raio*this.raio);
    }
    
}
