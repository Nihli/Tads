package formasgeometricas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
public class Circunferencia implements FormaGeometrica{
    private double raio;

    public Circunferencia(double raio) {
        if (raio>=0){
            this.raio = raio;
        }else{
            throw new RuntimeException("Valores negativos não são permitidos para essa forma geométrica.");
        }
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public double area() {
        return (3.14*this.raio*this.raio);
    }
    
}
