/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex06contagemcaracteres;

import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */
public class Ex06ContagemCaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Entre com um texto:");
        
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        
        System.out.println(String.format("O texto digitado tem %d caracteres.", texto.length()));
    }
    
}
