/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadorcomthreads;

/**
 *
 * @author Lia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContadorThread c1 = new ContadorThread(10, "T10");
        ContadorThread c2 = new ContadorThread(20, "T20");
        
        c1.start();
        c2.start();
    }
    
}
