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
public abstract class Conta implements ContaI{
    private double saldo;
    private double depositoInicial;
    private Cliente dono;
    private String numero;

    public Conta(double depositoInicial, Cliente dono, String numero) {
        this.depositoInicial = depositoInicial;
        this.dono = dono;
        this.numero = numero;
        this.saldo = depositoInicial;
    }
    
    @Override
    public boolean deposita(double valor) {
        if (valor>=0){
            this.saldo+=valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean saca(double valor) {
        if (valor>=0){
            this.saldo-=valor;
            return true;
        }
        return false;
    }

    @Override
    public Cliente getDono() {
        return dono;
    }

    @Override
    public final int getNumero() {
        return this.getNumero();
    }

    @Override
    public final double getSaldo() {
        return this.saldo;
    }

    public double getDepositoInicial() {
        return this.depositoInicial;
    }

    public void setDepositoInicial(double depositoInicial) {
        this.depositoInicial = depositoInicial;
    }
    
     
}
