/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lia
 */
public class Livro {
    private int id;
    private String titulo;
    private String assunto;
    private String codigoIsbn;
    private LocalDate dataPublicacao;
    private List<Autor> autores;
    private String listaAutores;
    
    public Livro(String titulo, String assunto, String codigoIsbn, LocalDate dataPublicacao, List<Autor> autores) {
        this.titulo = titulo;
        this.assunto = assunto;
        this.codigoIsbn = codigoIsbn;
        this.dataPublicacao = dataPublicacao;
        this.autores = autores;
    }

    public Livro() {
    }

    public Livro(String titulo, List<Autor> autores) {
        this.titulo = titulo;
        this.autores = autores;
    }

    
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutores(List<Autor> autores) {
        Iterator iterator = autores.iterator();
        while (iterator.hasNext()) {
            Autor autor = (Autor) iterator.next();
            this.adicionarAutor(autor);
        }
    }

    public List<Autor> getAutores() {
        return this.autores;
    }

   public void adicionarAutor(Autor autor) {
       if (this.autores==null) {
           this.autores = new ArrayList();
       }
       
        if (!this.getAutores().contains(autor)) {
            this.autores.add(autor);
            autor.adicionarLivro(this);
        }
    }

    public void removerAutor(Autor autor) {
        if (!this.getAutores().contains(autor)) {
            this.autores.remove(autor);
            autor.removerLivro(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCodigoIsbn() {
        return codigoIsbn;
    }

    public void setCodigoIsbn(String codigoIsbn) {
        this.codigoIsbn = codigoIsbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getListaAutores() {
        return listaAutores;
    } 
    
    public void setListaAutores() {
        listaAutores = "";
        for (Autor a : autores) {
            listaAutores = listaAutores + a.getId()+ "; ";
        }
//        System.out.println(getId() + "-" + livros.size() +"-" +listaLivros);
    }
    
    public void setListaAutores(String listaAutores) {
        this.listaAutores = listaAutores;
    }

}
