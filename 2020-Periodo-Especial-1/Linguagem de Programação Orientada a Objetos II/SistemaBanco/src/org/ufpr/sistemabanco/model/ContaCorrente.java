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
public class ContaCorrente extends Conta{
    private int id;
    private double limite;

    public ContaCorrente(double limite, Cliente cliente, double depositoInicial, int numero) {
        super(depositoInicial, cliente, numero);
        this.limite = limite;
    }

    @Override
    public boolean saca(double valor) {
        // Antes de efetuar o saque deve-se verificar se o
//    valor sacado não ultrapassa o limite da conta. Ou seja, a conta poderá ficar negativa até o limite
//    estipulado na sua criação. Mostrar mensagem na tela informando o usuário.
        if (valor <= getSaldo()+limite){
            return(super.saca(valor));
        }
        return false;
    }

    @Override
    public void remunera() {
        super.deposita(getSaldo()*0.01);
    }

    public double getLimite() {
        return limite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
