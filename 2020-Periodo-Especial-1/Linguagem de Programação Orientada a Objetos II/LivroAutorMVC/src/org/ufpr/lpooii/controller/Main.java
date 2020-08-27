/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.controller;

import org.ufpr.lpooii.model.dao.AutorDAO;
import org.ufpr.lpooii.view.autor.JanelaAutorView;
import org.ufpr.lpooii.view.menu.JanelaMenuView;

/**
 *
 * @author Lia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JanelaMenuView view = new JanelaMenuView();
        
        view.show();
        
//        JanelaAutorView view = new JanelaAutorView();
//        AutorDAO autorDao = new AutorDAO();
//        
//        AutorController controller = new AutorController(view, autorDao);
        
    }
    
}
