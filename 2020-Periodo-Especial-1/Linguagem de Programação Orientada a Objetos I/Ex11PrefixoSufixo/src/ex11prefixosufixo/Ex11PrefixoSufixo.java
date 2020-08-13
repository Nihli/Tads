/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex11prefixosufixo;

import java.util.Scanner;

/**
 *
 * @author Lia
 */
public class Ex11PrefixoSufixo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] palavras = new String[10];
        String[] prefixos = null;
        String[] sufixos = null;       
        
        for(int i=0;i<palavras.length;i++) {
            System.out.println("Entre com uma palavra:");
            Scanner sc = new Scanner(System.in);
            palavras[i]= sc.next();
        }
        for (int i = 0; i < palavras.length; i++) {
            String prefix = palavras[i].substring(0,1);
            String sufix = palavras[i].substring(palavras[i].length()-1);
                for(int j = i+1; j < palavras.length; j++) {
                        if(palavras[j].startsWith(prefix)){
//                            prefixos[j]=palavras[j];
                            System.out.println("Prefixo " + palavras[j]);
                        }
                        if(palavras[j].endsWith(sufix)){
//                            sufixos[j]=palavras[j];
                            System.out.println("Sufixo " + palavras[j]);
                        }
                }    
        }
//        System.out.println("Prefixos:");
//        for(int i = 0; i < prefixos.length; i++) {
//            System.out.println(prefixos[i]);
//        }
//        System.out.println("Sufixos");
//        for(int i = 0; i < sufixos.length; i++) {
//            System.out.println(sufixos[i]);
//        }
        
    }
    
}
