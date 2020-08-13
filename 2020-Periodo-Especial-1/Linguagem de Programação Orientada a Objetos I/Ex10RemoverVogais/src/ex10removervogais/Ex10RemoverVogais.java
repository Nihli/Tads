/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex10removervogais;

import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */
public class Ex10RemoverVogais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CharSequence[] replace = {"A","a","E","e","I","i","O","o","U","u"};
 
        System.out.println("Entre com um texto:");
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        
        for(CharSequence vogal : replace){
            texto = texto.replace(vogal, "");
        }
       
        System.out.println(texto);
    }
    
}
