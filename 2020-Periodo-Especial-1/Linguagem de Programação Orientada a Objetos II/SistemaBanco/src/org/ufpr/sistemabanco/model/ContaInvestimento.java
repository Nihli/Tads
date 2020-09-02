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
public class ContaInvestimento extends Conta{
    private int id;
    private double montanteMinimo;
    private double depositoMinimo;

    public ContaInvestimento(double montanteMinimo, double depositoMinimo, Cliente cliente, double depositoInicial, int numero) {
        super(depositoInicial, cliente, numero);
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
    }
    
    public ContaInvestimento(double montanteMinimo, double depositoMinimo, Cliente cliente, double depositoInicial, int numero, double saldo) {
        super(depositoInicial, cliente, numero, saldo);
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
    }

    @Override
    public boolean saca(double valor) {
        // Recebe como parâmetro o valor a ser
        //sacado. Se o novo valor do saldo (considerando o saque) for maior ou igual ao
        //montanteMinimo, o saque deve ser efetuado. Para isso invoque o método saque da classe
        //pai (Conta) e retorne true. Caso contrário, deve-se retornar false. Mostrar mensagem na
        //tela informando usuário
        if (getSaldo()-valor>=montanteMinimo){
            return(super.saca(valor));
        }
        return false;
    }
    
    @Override
    public boolean deposita(double valor) {
        //Recebe como parâmetro o valor a ser
        //depositado. Se o valor a ser depositado for maior ou igual ao depositoMinimo então, o
        //depósito deve ser efetuado. Para isso chame o método deposita da classe pai (Conta) e
        //retorne true. Caso contrário, deve-se retornar false. Mostrar mensagem na tela informando
        //usuário.
        if (valor>=depositoMinimo){
            return (super.deposita(valor));
        }
        
        return false;
    }

    @Override
    public void remunera() {
        System.out.println("Remunera da Investimento");
        super.deposita(getSaldo()*0.02);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontanteMinimo() {
        return montanteMinimo;
    }

    public double getDepositoMinimo() {
        return depositoMinimo;
    }
}
