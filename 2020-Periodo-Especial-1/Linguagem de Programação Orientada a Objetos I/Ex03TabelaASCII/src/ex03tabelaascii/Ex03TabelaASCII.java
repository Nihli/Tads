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
            System.out.println("Caracter    Dec     Oct     Hex");
            if (i<32){
                System.out.println((char) 32+"           "+(i-1)+"     "+Integer.toOctalString(i) +"      "+String.valueOf(Integer.toHexString(i).toUpperCase()));
            }else{
                System.out.println((char) i+"           "+(i-1)+"      "+Integer.toOctalString(i) +"      "+String.valueOf(Integer.toHexString(i).toUpperCase()));
            }
            
        }
    }
    
}
