package avaliacaoalunos;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia Alflen
 */
public class Aluno {
    private String nome;
    private List<Double> avaliacoes;
    private double media;

    public Aluno(String nome, List<Double> avaliacoes, double media) {
        this.nome = nome;
        this.avaliacoes = avaliacoes;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Double> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
    
}
