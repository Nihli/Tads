/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Lia
 */
public class Dizimista extends Pessoa{
    private int matricula;
    private Dizimista entregadorDizimo;
    List<Dizimo> dizimos;
    List<Igreja> igrejas;

    public Dizimista(String nome, String endereco, String cpf, Dizimista entregadorDizimo) {
        super(nome, endereco, cpf);
        this.entregadorDizimo = entregadorDizimo;
    }
    
    @Override
    public String toString() {
        return super.getNome();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Dizimista getEntregadorDizimo() {
        return entregadorDizimo;
    }

    public void setEntregadorDizimo(Dizimista entregadorDizimo) {
        this.entregadorDizimo = entregadorDizimo;
    }

    public List<Dizimo> getDizimos() {
        return dizimos;
    }

    public void setDizimos(List<Dizimo> dizimos) {
        this.dizimos = dizimos;
    }

    public List<Igreja> getIgrejas() {
        return igrejas;
    }

    public void setIgrejas(List<Igreja> igrejas) {
        this.igrejas = igrejas;
    }
    
    
}
