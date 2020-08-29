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
        try{
            Livro livro = view.getLivroFormulario();
            dao.inserirLivro(livro);
            livro.setListaAutores();
            view.inserirLivroView(livro);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao criar um livro.");
            ex.printStackTrace();
        }
        
    }

    public void atualizarLivro() {
        try {
            Livro livro = view.getLivroParaAtualizar();
            
            if (livro==null) {
                view.apresentaInfo("Selecione um autor na tabela para atualizar.");
                return;
            }
            
            dao.atualizar(livro);
            livro.setListaAutores();
            view.atualizarLivro(livro);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao atualizar um livro.");
            ex.printStackTrace();
        }
    }

    public void excluirLivro() {
        try {
            List<Livro> listaParaExcluir = view.getLivrosParaExcluir();
            dao.excluirLista(listaParaExcluir);
            view.excluirLivroView(listaParaExcluir);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao excluir um livro.");
            ex.printStackTrace();
        }
    }

    public void listarLivro() {
        try{
            List<Livro> lista = this.dao.listarLivroComAutores();
            view.mostrarListaAutores(lista);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao Listar livros.");
            ex.printStackTrace();
        }
    }

    public Autor consultarAutor(int id) {
        return autorDao.consultarAutor(id);
    }
    
    
}
