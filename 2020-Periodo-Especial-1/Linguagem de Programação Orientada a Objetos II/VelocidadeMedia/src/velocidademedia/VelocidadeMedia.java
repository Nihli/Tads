/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velocidademedia;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Lia
 */
public class VelocidadeMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao cálculo de velocidade média!");
        System.out.println("Entre com a distância percorrida (em Km):");
        Scanner scanner = new Scanner(System.in);
        
        double distanciaDouble = scanner.nextDouble();
        
        System.out.println("Entre com o tempo gasto de viagem (em horas):");
        scanner = new Scanner(System.in);
        
        double tempoDouble = scanner.nextDouble();

        DecimalFormat decimalFormat = new DecimalFormat("0.0000000000");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        
        //garante que entrada só tem 10 digitos
        double d = Double.parseDouble(decimalFormat.format(distanciaDouble).replace(",","."));
        double t = Double.parseDouble(decimalFormat.format(tempoDouble).replace(",","."));
        
        //transforma entrada em BigDecimal
        BigDecimal distancia = BigDecimal.valueOf(d).setScale(3, RoundingMode.HALF_EVEN);
        BigDecimal tempo = BigDecimal.valueOf(t).setScale(3, RoundingMode.HALF_EVEN);
     
        //calcula velocidadeMedia
        BigDecimal velocidadeMedia = distancia.divide(tempo,2,RoundingMode.HALF_EVEN);

        System.out.println("A velocidade média é: "+velocidadeMedia);
        

    }
    
}
