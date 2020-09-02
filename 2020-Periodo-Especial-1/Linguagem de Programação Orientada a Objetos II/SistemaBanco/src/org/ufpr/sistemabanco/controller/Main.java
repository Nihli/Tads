/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.controller;

import java.util.ArrayList;
import java.util.List;
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.Conta;
import org.ufpr.sistemabanco.model.ContaCorrente;
import org.ufpr.sistemabanco.model.ContaI;
import org.ufpr.sistemabanco.model.ContaInvestimento;
import org.ufpr.sistemabanco.view.menuinicial.JanelaMenuView;

/**
 *
 * @author Lia
 */
public class Main {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JanelaMenuView view = new JanelaMenuView();
        
        view.show();
//        Cliente c = new Cliente("Lia", "Alflen", "rg","cpf", "enderec", 100);
//        ContaCorrente cc = new ContaCorrente(100,c, 50, "1");
//        cc.deposita(20);
//        cc.saca(171);
//        System.out.println(cc.getSaldo());
//        cc.remunera();
//        System.out.println(cc.getSaldo());

//        ContaInvestimento ci = new ContaInvestimento(100, 50,c, 105, "1");
////        ci.deposita(120);
//        ci.saca(6);
//        System.out.println(ci.getSaldo());
//        ci.remunera();
//        System.out.println(ci.getSaldo());

//        List<ContaI> list = new ArrayList();
//        Cliente c = new Cliente("Lia", "Alflen", "rg","cpf", "enderec", 100);
//        ContaInvestimento ci = new ContaInvestimento(100, 50,c, 105, 1);
//        ContaCorrente cc = new ContaCorrente(100,c, 50, 1);
//        
//        list.add(ci);
//        list.add(cc);
//        
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i) instanceof ContaInvestimento);
//            System.out.println(list.get(i) instanceof ContaCorrente);
//        }
        
        
        
    
    }
}
