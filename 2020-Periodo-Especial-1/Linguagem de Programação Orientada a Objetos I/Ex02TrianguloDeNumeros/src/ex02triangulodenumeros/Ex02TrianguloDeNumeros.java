/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02triangulodenumeros;

/**
 *
 * @author Lia Alflen
 */
public class Ex02TrianguloDeNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numerosImpressosLinha=0;
        int linha=1;
        
        String x = "1;4;56;-5";
        String[] s = x.split(";");
        System.out.println(s.length);
        for (int i=0;i<s.length;i++){
            if (s[i].matches("[0-9]+")){
                System.out.println(s[i]);
            }
        }
        
        
//        for (int i=1;i<=15;i++){
//            if (linha==numerosImpressosLinha){
//                System.out.println("\n");
//                numerosImpressosLinha=0;
//                linha++;
//            }
//            
//            System.out.print(i+" ");
//            numerosImpressosLinha++;
//
//        }
    }
    
}
