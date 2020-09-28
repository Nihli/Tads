/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dizimistas;

import dao.GerenciadorDados;
import dizimistas.entity.Igreja;
import java.util.ArrayList;
import view.FrameInicial;

/**
 *
 * @author Lia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       criaIgrejas();
        
        FrameInicial view = new FrameInicial();
        
        view.show();
    }
    
     private static void criaIgrejas() {
        GerenciadorDados bd = GerenciadorDados.getInstance();
        bd.getIgrejaList().add(
                new Igreja(1,"Igreja Cristo Ressuscitado", new ArrayList()));
        bd.getIgrejaList().add(
                new Igreja(2,"Menino Jesus", new ArrayList()));
        bd.getIgrejaList().add(
                new Igreja(3,"São Daniel Camboni", new ArrayList()));
        bd.getIgrejaList().add(
                new Igreja(4,"Nossa senhora da Visitação", new ArrayList()));
    }
}
