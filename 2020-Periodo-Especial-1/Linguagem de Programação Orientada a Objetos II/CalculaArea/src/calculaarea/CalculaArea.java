/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculaarea;

/**
 *
 * @author Lia
 */
public class CalculaArea {
    public static double areaRetangulo(double lado1, double lado2) {
        if(lado1<0 || lado2<0){
            throw new RuntimeException("Não é possível calcular a área com números negativos.");
        }else{
            return (lado1*lado2);
        }
    }

    public static double areaCircunferencia(double raio) {
        if(raio<0){
            throw new RuntimeException("Não é possível calcular a área com números negativos.");
        }else{
            return (3.14*raio*raio);
        }
    }

    public static double areaTriangulo(double base, double altura) {
        if(base<0 || altura<0){
            throw new RuntimeException("Não é possível calcular a área com números negativos.");
        }else{
            return ((base*altura)/2);
        }
        
    }
}
