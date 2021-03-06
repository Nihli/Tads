/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lia
 */
public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String documento;
    private String nacionalidade;
    private List<Livro> livros;
    private String listaLivros="";
    
    public Autor(String nome) {
        this.nome = nome;
        this.livros = new ArrayList();
    }

    public Autor(String nome, LocalDate dataNascimento, String documento, String nacionalidade, List<Livro> livros) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.nacionalidade = nacionalidade;
        this.livros = livros;
    }

    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setLivros(List<Livro> livros, int flag) {
        if (flag==1) {
           for(Livro livro: livros){
                this.adicionarLivro(livro);
           }
        }else{
            this.livros = livros;
        }
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public void adicionarLivro(Livro livro) {
        if (!this.getLivros().contains(livro)) {
            this.livros.add(livro);
            livro.adicionarAutor(this);
        }
    }

    public void removerLivro(Livro livro) {
        if (this.getLivros().contains(livro)) {
            this.livros.remove(livro);
            livro.removerAutor(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros() {
        listaLivros = "";
        for (Livro l : livros) {
            listaLivros = listaLivros + l.getId()+ "; ";
        }
//        System.out.println(getId() + "-" + livros.size() +"-" +listaLivros);
    }
    
    public void setListaLivros(String listaLivros) {
        this.listaLivros = listaLivros;
    }
    
    
    
    /**
     * Método que produz um hashCode igual para bicicletas iguais.
     * @return Inteiro que representa o hashCode do objeto
     */
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }
    /**
     * Método que compara duas bicicletas pelo seu conteúdo
     * @return booleano: Verndadeiro se igual, falso, caso contrário.
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!obj.getClass().equals(this.getClass()) )
            return false;

        Autor objAutor = (Autor)obj;

        if(objAutor.getId()!=this.getId())
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", documento=" + documento + ", nacionalidade=" + nacionalidade + ", livros=" + livros + ", listaLivros=" + listaLivros + '}';
    }


}
