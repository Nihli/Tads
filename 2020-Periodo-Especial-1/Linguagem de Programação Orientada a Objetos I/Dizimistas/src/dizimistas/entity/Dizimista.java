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
public class Dizimista extends Pessoa{
    private int matricula;
    private Dizimista entregadorDizimo;
    List<Dizimo> dizimos;
    List<Igreja> igrejas;
}
