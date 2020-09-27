/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacaoalunos;

import java.util.List;

/**
 *
 * @author Lia
 */
public class Avaliacao {
    private String nome;
    private double media;
    private List<Double> moda;
    private double mediana;

    public Avaliacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public List<Double> getModa() {
        return moda;
    }

    public void setModa(List<Double> moda) {
        this.moda = moda;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }
    
    
}
