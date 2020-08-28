/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.controller;

import java.util.List;
import org.ufpr.lpooii.model.Autor;
import org.ufpr.lpooii.model.Livro;
import org.ufpr.lpooii.model.dao.AutorDAO;
import org.ufpr.lpooii.model.dao.LivroDAO;
import org.ufpr.lpooii.view.autor.JanelaAutorView;

/**
 *
 * @author Lia
 */
public class AutorController {
    private JanelaAutorView view;
    private AutorDAO dao;
    private LivroDAO daoLivro;

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
        try{
            Autor autor = view.getAutorFormulario();

            dao.inserirAutor(autor);

            view.inserirAutorView(autor);
        }catch(Exception e) {
            view.apresentaErro("Erro ao criar autor.");
        }
    }

    public void atualizarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluirAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void listarAutor() {
        try{
            List<Autor> lista = this.dao.listarAutores();
            view.mostrarListaAutores(lista);
        }catch(Exception e) {
                view.apresentaErro("Erro ao listar autores.");
                e.printStackTrace();
            }
    }
    
    public Livro consultarLivro(int id){
        return daoLivro.consultarLivro(id);
    }
}
