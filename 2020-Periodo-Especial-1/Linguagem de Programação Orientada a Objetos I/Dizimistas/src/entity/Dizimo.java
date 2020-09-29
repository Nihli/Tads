/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Lia
 */
public class Dizimo {
   private double valor;
   private double valorMinimo;
   private String mes;
   private String ano;

    public Dizimo(double valor, double valorMinimo, String mes, String ano) {
        this.valor=valor;
        this.valorMinimo = valorMinimo;
        this.mes = mes;
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public boolean setValor(double valor) {
        if (valor<valorMinimo){
            return false;
        }
        this.valor = valor;
        return true;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.mes);
        hash = 23 * hash + Objects.hashCode(this.ano);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dizimo other = (Dizimo) obj;
        if (!Objects.equals(this.mes, other.mes)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        return true;
    }
}
