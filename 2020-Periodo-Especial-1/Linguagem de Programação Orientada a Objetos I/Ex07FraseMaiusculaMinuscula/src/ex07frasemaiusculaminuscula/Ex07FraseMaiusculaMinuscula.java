/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex07frasemaiusculaminuscula;

import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */
public class Ex07FraseMaiusculaMinuscula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int maiuscula=0, minuscula=0;
        
        System.out.println("Entre com uma frase:");
        
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        
        for(int i=0;i<frase.replaceAll(" ", "").length();i++){
            if (Character.isUpperCase(frase.replaceAll(" ", "").charAt(i))){
                maiuscula++;
            }else{
                minuscula++;
            }
        }
        
        if (maiuscula<=minuscula){
            System.out.println(frase.toUpperCase());
        }else{
            System.out.println(frase.toLowerCase());
        }
        
    }
    
}
