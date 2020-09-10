/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadorcomthreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lia
 */
public class ContadorThread extends Thread{
    private int numMax;
    private String nome;

    public ContadorThread(int numMax, String nome) {
        this.numMax = numMax;
        this.nome = nome;
    }
    
    public void run(){
        for (int i=0;i<=numMax;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread interrompida!");
            }
            System.out.println(nome + ": " + i);
        }
    }
}
