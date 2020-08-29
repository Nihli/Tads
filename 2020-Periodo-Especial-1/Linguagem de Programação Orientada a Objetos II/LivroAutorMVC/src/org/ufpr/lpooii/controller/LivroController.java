/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ufpr.lpooii.model.Autor;
import org.ufpr.lpooii.model.Livro;
import org.ufpr.lpooii.model.dao.AutorDAO;
import org.ufpr.lpooii.model.dao.LivroDAO;
import org.ufpr.lpooii.view.livro.JanelaLivroView;

/**
 *
 * @author Lia
 */
public class LivroController {
    private JanelaLivroView view;
    private LivroDAO dao;
    private AutorDAO autorDao = new AutorDAO();

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
        Livro livro = view.getLivroFormulario();
        dao.inserirLivro(livro);
        livro.setListaAutores();
        view.inserirLivroView(livro);
    }

    public void atualizarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluirLivro() {
        try {
            List<Livro> listaParaExcluir = view.getLivrosParaExcluir();
            dao.excluirLista(listaParaExcluir);
            view.excluirLivroView(listaParaExcluir);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarLivro() {
        List<Livro> lista = this.dao.listarLivroComAutores();
        view.mostrarListaAutores(lista);
    }

    public Autor consultarAutor(int id) {
        return autorDao.consultarAutor(id);
    }
    
    
}
