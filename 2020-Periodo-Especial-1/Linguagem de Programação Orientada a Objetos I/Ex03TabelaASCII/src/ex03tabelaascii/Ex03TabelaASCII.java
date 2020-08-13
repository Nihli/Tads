/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03tabelaascii;

/**
 *
 * @author Lia Alflen
 */
public class Ex03TabelaASCII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 255; i++){
            System.out.println("Hex    Dec     Oct     Caracter");
            if (i<32){
                System.out.println(String.valueOf(Integer.toHexString(i).toUpperCase()) +"      "+(i-1)+"    "+Integer.toOctalString(i) +"      "+(char)32);
            }else{
                System.out.println(String.valueOf(Integer.toHexString(i).toUpperCase())+"       "+(i-1)+"    "+Integer.toOctalString(i) +"      "+(char) i);
            }
            
        }
    }
    
}
