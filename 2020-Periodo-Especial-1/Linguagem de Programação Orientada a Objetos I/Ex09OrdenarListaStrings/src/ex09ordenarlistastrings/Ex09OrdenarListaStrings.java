/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex09ordenarlistastrings;

import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */
public class Ex09OrdenarListaStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] nomes = new String[5];
        String aux;
        
        for(int i=0;i<nomes.length;i++) {
            System.out.println("Entre com um nome:");
            Scanner sc = new Scanner(System.in);
            nomes[i]= sc.nextLine();
        }
        
        boolean troquei = true;
        
        while (troquei) {
            troquei = false;
                for (int i = 0; i < nomes.length-1; i++) {
                    if (nomes[i].compareToIgnoreCase(nomes[i+1])>0) {
                        aux = nomes[i];
                        nomes[i] = nomes[i + 1];
                        nomes[i + 1] = aux;
                        troquei = true;
                    }
                }
        }
        
        System.out.println("Nomes ordenados:");
        for(String i : nomes){
            System.out.println(i);
        }
    }
    
}
