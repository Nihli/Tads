/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dizimistas.entity.Igreja;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lia
 */
public class GerenciadorDados {
    private static GerenciadorDados INSTANCE = null;
    private GerenciadorDados() {}
    public static GerenciadorDados getInstance() {
        if( INSTANCE == null ) {
            synchronized(GerenciadorDados.class) {
                if( INSTANCE == null ) {
                    INSTANCE = new GerenciadorDados();
                }
            }
        }
        return INSTANCE;
    }
    //
    //
    private List<Igreja> igrejaList = null;
    
    public List<Igreja> getIgrejaList() {
        if( igrejaList == null ) {
            igrejaList = new ArrayList();
        }
        return igrejaList;
    }
}
