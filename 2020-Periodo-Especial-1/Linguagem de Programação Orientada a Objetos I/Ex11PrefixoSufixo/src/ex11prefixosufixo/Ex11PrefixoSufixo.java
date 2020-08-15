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

        for(int i=0;i<palavras.length;i++) {
            System.out.println("Entre com uma palavra:");
            Scanner sc = new Scanner(System.in);
            palavras[i]= sc.next();
        }

        for (int i = 0; i < palavras.length; i++) {
            for(int j=0;j<palavras[i].length();j++){
                String prefix = palavras[i].substring(0, palavras[i].length()-j);
                String sufix = palavras[i].substring(j);
                for(int k = i; k < palavras.length; k++) {
                    if(palavras[k].startsWith(prefix)){
                        System.out.println("Prefixo\t\t"+ prefix + "\t\t" + palavras[k]);
                    }
                    if(palavras[k].endsWith(sufix)){
                        System.out.println("Sufixo\t\t"+ prefix + "\t\t" + palavras[k]);
                    }
                }
            }
        }
        
    }
    
}
