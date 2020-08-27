/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.controller;

import org.ufpr.lpooii.model.dao.AutorDAO;
import org.ufpr.lpooii.view.autor.JanelaAutorView;

/**
 *
 * @author Lia
 */
public class AutorController {
    private JanelaAutorView view;
    private AutorDAO dao;

    public AutorController(JanelaAutorView view, AutorDAO dao) {
        this.view = view;
        this.dao = dao;
        
        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void criarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluirAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void listarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
