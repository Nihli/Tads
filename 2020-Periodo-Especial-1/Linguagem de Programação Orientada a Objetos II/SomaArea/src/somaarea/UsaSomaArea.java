/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somaarea;

/**
 *
 * @author Lia
 */
public class UsaSomaArea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quadrado quad[] = {new Quadrado(2.0), new Quadrado(5.0)};
        Circunferencia circ[] = {new Circunferencia(3.0), new Circunferencia(2.0)};
        Superficie superf[] = new Superficie[quad.length + circ.length];
        superf[0] = quad[0];
        superf[1] = quad[1];
        superf[2] = circ[0];
        superf[3] = circ[1];
        SomaAreas soma = new SomaAreas();
        System.out.println("Area dos quadradados = " + soma.calculaArea(quad));
        System.out.println("Area das circunferencias = " +
        soma.calculaArea(circ));
        System.out.println("Soma de todas as áreas = " +
        soma.calculaArea(superf));
    }
    
}
