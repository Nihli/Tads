/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.controller;

import org.ufpr.lpooii.model.dao.LivroDAO;
import org.ufpr.lpooii.view.livro.JanelaLivroView;

/**
 *
 * @author Lia
 */
public class LivroController {
    private JanelaLivroView view;
    private LivroDAO dao;

    public LivroController(JanelaLivroView view, LivroDAO dao) {
        this.view = view;
        this.dao = dao;
        
        initController();
    }

    private void initController() {
        this.view.setController(this);
        
        this.view.initView();
    }

    public void criarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluirLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void listarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
