/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dizimistas;

import dao.GerenciadorDados;
import dao.IODadosXML;
import entity.Igreja;
import java.io.FileNotFoundException;
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
        GerenciadorDados bd = GerenciadorDados.getInstance();
        try {
            IODadosXML.carregar("./dados.xml", bd);
        } catch (Exception e) {
            criaIgrejas();
            
            IODadosXML.salvar("./dados.xml", bd);
        }
        
        for (Igreja i : bd.getIgrejaList()) {
                System.out.println(i);
            }

            FrameInicial view = new FrameInicial();

        view.show();
    }

    private static void criaIgrejas() {
        GerenciadorDados bd = GerenciadorDados.getInstance();
        bd.getIgrejaList().add(
                new Igreja(1, "Igreja Cristo Ressuscitado", new ArrayList()));
        bd.getIgrejaList().add(
                new Igreja(2, "Menino Jesus", new ArrayList()));
        bd.getIgrejaList().add(
                new Igreja(3, "São Daniel Camboni", new ArrayList()));
        bd.getIgrejaList().add(
                new Igreja(4, "Nossa senhora da Visitação", new ArrayList()));
    }
}
