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
public class Igreja {
    private int id;
    private String nome;
    List<Dizimista> dizimistas;

    public Igreja(int id, String nome, List<Dizimista> dizimistas) {
        this.id = id;
        this.nome = nome;
        this.dizimistas = dizimistas;
    }

    public String getNome() {
        return nome;
    }

    public List<Dizimista> getDizimistas() {
        return dizimistas;
    }

    public void setDizimistas(List<Dizimista> dizimistas) {
        this.dizimistas = dizimistas;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.id;
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
        final Igreja other = (Igreja) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
