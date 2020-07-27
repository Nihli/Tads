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
public class Triangulo implements FormaGeometrica{

    private double base;
    private double altura;
    
    public Triangulo(double base, double altura){
         if (base<0 || altura<0) {
            throw new RuntimeException("Valores negativos não são permitidos para essa forma geométrica.");
        }else{
             this.base = base;
            this.altura = altura;
        }
    }

    double getBase() {
        return this.base;
    }

    double getAltura() {
        return this.altura;
    }

    @Override
    public double area() {
        return ((this.base*this.altura)/2);
    }
    
}
