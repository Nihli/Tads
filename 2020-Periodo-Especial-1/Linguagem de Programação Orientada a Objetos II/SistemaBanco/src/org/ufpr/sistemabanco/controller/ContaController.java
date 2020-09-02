/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.controller;

import java.util.List;
import org.ufpr.sistemabanco.model.ContaI;
import org.ufpr.sistemabanco.model.dao.ClienteDao;
import org.ufpr.sistemabanco.model.dao.ContaDao;
import org.ufpr.sistemabanco.view.manipulaconta.JanelaManipulaContaView;

/**
 *
 * @author Lia
 */
public class ContaController {
    private JanelaManipulaContaView view;
    private ClienteDao clienteDao;
    private ContaDao contaDao;

    public ContaController(JanelaManipulaContaView view, ClienteDao clienteDao, ContaDao contaDao) {
        this.view = view;
        this.clienteDao = clienteDao;
        this.contaDao = contaDao;
        
       initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void sacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void depositar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void saldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remunerar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buscarConta(int selectedIndex) {
        if (selectedIndex == 0) {
            String busca = view.getBusca();
            
            List<ContaI> listaContas = contaDao.buscaContaPorCPF(busca);
            
            view.mostrarListaContas(listaContas);
        }
    }
    
}
