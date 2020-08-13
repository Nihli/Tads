/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex13palindromo;

import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */
public class Ex13Palindromo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Entre com uma frase:");
        
        Scanner sc = new Scanner(System.in);
        String frase= sc.nextLine();
        
        frase = frase.replaceAll(" ", "");
        frase = frase.toLowerCase();
        frase = frase.replaceAll("[^a-zZ-Z]", "");
        
        char[] charfrase = new char[frase.length()];
        char[] charfraseInvertida = new char[frase.length()];
        
        for (int i = 0; i < frase.length(); i++) {
            charfrase[i] = frase.charAt(i);
        }
        
         for (int j = 0; j < frase.length(); j++) {
            charfraseInvertida[j] = charfrase[frase.length()-1-j];
        }
        
        String fraseInvertida = new String(charfraseInvertida);
        
        if(fraseInvertida.equals(frase)){
            System.out.println("A frase é um palíndromo.");
        }else{
            System.out.println("A frase não é um palíndromo.");
        }
    }
    
}
