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
public class Retangulo implements FormaGeometrica{

    private double lado1;
    private double lado2;
    
    public Retangulo(double lado1, double lado2) {
        if (lado1<0 || lado2<0) {
            throw new RuntimeException("Valores negativos não são permitidos para essa forma geométrica.");
        }else{
            this.lado1 = lado1;
            this.lado2 = lado2;
        }
    }

    public double getLado1() {
        return this.lado1;
    }

    public double getLado2() {
        return this.lado2;
    }

    @Override
    public double area() {
        return (this.lado1*this.lado2);
    }

    public double perimetro() {
        return ((2*this.lado1)+(2*this.lado2));
    }
    
}
