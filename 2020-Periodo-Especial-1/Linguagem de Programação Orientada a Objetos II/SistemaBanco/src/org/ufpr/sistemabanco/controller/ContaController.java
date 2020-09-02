/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.controller;

import java.util.List;
import org.ufpr.sistemabanco.model.ContaCorrente;
import org.ufpr.sistemabanco.model.ContaI;
import org.ufpr.sistemabanco.model.ContaInvestimento;
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
        ContaI conta = view.getContaParaManipular();
        double valor = view.getValorSacar();
        
        if (conta instanceof ContaCorrente){
            ContaCorrente contaCorrente = (ContaCorrente)conta;
            System.out.println(contaCorrente.getSaldo());
            boolean ok = contaCorrente.saca(valor);
            System.out.println(contaCorrente.getSaldo());

            if(ok){
                //dao
                view.apresentaInfo("Foi sacado R$" + valor + " da conta.");
            }else{
                if (valor<0){
                     view.apresentaErro("O valor a ser sacado era negativo.\nA operação foi cancelada.");
                     return;
                }
                view.apresentaErro("O valor a ser sacado ultrapassava o limite disponível.\nA operação foi cancelada.");
            }
            
        }else if (conta instanceof ContaInvestimento){
            ContaInvestimento contaInvestimento = (ContaInvestimento)conta;
            System.out.println(contaInvestimento.getSaldo());
            boolean ok = contaInvestimento.saca(valor);
            System.out.println(contaInvestimento.getSaldo());

            if(ok){
                //dao
                view.apresentaInfo("Foi sacado R$" + valor + " da conta.");
            }else{
                if (valor<0){
                     view.apresentaErro("O valor a ser sacado era negativo.\nA operação foi cancelada.");
                     return;
                }
                view.apresentaErro("O valor a ser sacado deixava o saldo abaixo do montante mínimo da conta.\nA operação foi cancelada.");
            }
        }
    }

    public void depositar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void saldo() {
        ContaI conta = view.getContaParaManipular();
        view.apresentaInfo("O saldo na conta é de R$ "+conta.getSaldo());
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
