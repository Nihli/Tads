/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

/**
 *
 * @author Lia
 */
public class UsaPilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Pilha <Integer> p1 = new Pilha <Integer>();
        p1.empilha(10);
        p1.empilha(20);
        p1.empilha(30);
        System.out.println(p1.toString());
        p1.desempilha();
        p1.desempilha();
        System.out.println(p1.toString());
        Pilha <String> p2 = new Pilha <String>();
        p2.empilha("Isto");
        p2.empilha("é");
        p2.empilha("uma");
        p2.empilha("pilha");
        p2.empilha("FILO");
        System.out.println(p2.toString());
        p2.desempilha();
        p2.desempilha();
        p2.desempilha();
        System.out.println(p2.toString());
    }
    
}
