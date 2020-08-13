/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex08separapalavras;

import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */
public class Ex08SeparaPalavras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Entre com uma frase:");
        
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        
        String[] lista = frase.split(" ");
        
        for(String elemento : lista) {
            System.out.println(elemento);
        }
    }
    
}
