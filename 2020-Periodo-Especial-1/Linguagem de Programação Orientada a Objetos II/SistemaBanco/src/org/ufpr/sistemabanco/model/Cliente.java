/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.model;

/**
 *
 * @author Lia
 */
public class Cliente implements Comparable<Cliente>{
    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private String endereco;
    private double salario;
    private boolean possuiConta;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String rg, String cpf, String endereco, double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isPossuiConta() {
        return possuiConta;
    }

    public void setPossuiConta(boolean possuiConta) {
        this.possuiConta = possuiConta;
    }
    
    @Override
    public int compareTo(Cliente o) {
        return this.getNome().compareTo(o.getNome());
    }
    
}
