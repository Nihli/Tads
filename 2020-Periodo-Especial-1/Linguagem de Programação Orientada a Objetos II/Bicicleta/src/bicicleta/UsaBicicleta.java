/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicicleta;

/**
 *
 * @author Lia
 */
public class UsaBicicleta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bicicleta bicicletaAnonima = new Bicicleta () {
            void aplicarFreios(int decremento){
                velocidade = velocidade - 2*decremento;
            }
        };
        
        bicicletaAnonima.mudarCadencia(2);
        bicicletaAnonima.mudarMarcha(1);
        bicicletaAnonima.aumentarVelocidade(15);
        bicicletaAnonima.printStates();
        bicicletaAnonima.mudarMarcha(2);
        bicicletaAnonima.aplicarFreios(5);
        bicicletaAnonima.printStates();
        
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.mudarCadencia(2);
        bicicleta.mudarMarcha(1);
        bicicleta.aumentarVelocidade(15);
        bicicleta.printStates();
        bicicleta.mudarMarcha(2);
        bicicleta.aplicarFreios(5);
        bicicleta.printStates();
        
    }
    
}
