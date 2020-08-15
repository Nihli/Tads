/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex12sufixospossiveis;

import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */ 
public class Ex12SufixosPossiveis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Entre com uma frase:");
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        
        System.out.println("Todos os sufixos possíveís desta frase são:");
        
        for(int i=0;i<frase.length();i++){
            System.out.println(frase.substring(i));
        }
    }
    
}
