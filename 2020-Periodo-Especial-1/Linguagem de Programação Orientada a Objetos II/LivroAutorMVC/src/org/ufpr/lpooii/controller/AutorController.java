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
    private LivroDAO daoLivro = new LivroDAO();

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

            autor.setListaLivros();
            
            view.inserirAutorView(autor);
        }catch(Exception e) {
            view.apresentaErro("Erro ao criar autor.");
             e.printStackTrace();
        }
    }

    public void atualizarAutor() {
        try{
            Autor autor = view.getAutorParaAtualizar();
            
            if (autor==null) {
                view.apresentaInfo("Selecione um autor na tabela para atualizar.");
                return;
            }
            
            dao.atualizar(autor);
            autor.setListaLivros();
            
            view.atualizarAutor(autor);
        }catch(Exception e) {
            view.apresentaErro("Erro ao atualizar autor.");
             e.printStackTrace();
        }
    }

    public void excluirAutor() {
        try{
            List<Autor> listaParaExcluir = view.getAutoresParaExcluir();
            
            dao.excluirLista(listaParaExcluir);
            view.excluirAutorView(listaParaExcluir);
        }catch(Exception e) {
            view.apresentaErro("Erro ao deletar autor.");
             e.printStackTrace();
        }
    }

    public void listarAutor() {
        try{
            List<Autor> lista = this.dao.listarAutores();
            
            for (Autor a : lista ){
                a.setListaLivros();
            }
            
            view.mostrarListaAutores(lista);
        }catch(Exception e) {
                view.apresentaErro("Erro ao listar autores.");
                e.printStackTrace();
            }
    }
    
    public Livro consultarLivro(int id){
//        System.out.println(id);
        return daoLivro.consultarLivro(id);
    }
}
