/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dizimistas.entity;

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

    
    
    @Override
    public String toString() {
        return nome;
    }
    
    
}
