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
        try{
            ContaI conta = view.getContaParaManipular();
            Double valor = view.getValorSacar();
            if (valor!=null){
                if (conta instanceof ContaCorrente){
                    ContaCorrente contaCorrente = (ContaCorrente)conta;
                    System.out.println(contaCorrente.getSaldo());
                    boolean ok = contaCorrente.saca(valor);


                    if(ok){
                        System.out.println(contaCorrente.getId());
                        contaDao.atualizaSaldo(contaCorrente.getSaldo(), contaCorrente.getId());
                        view.apresentaInfo("Foi sacado R$" + valor + " da conta.");
                        view.limpaCampos();
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
                        contaDao.atualizaSaldo(contaInvestimento.getSaldo(), contaInvestimento.getId());
                        view.apresentaInfo("Foi sacado R$" + valor + " da conta.");
                        view.limpaCampos();
                    }else{
                        if (valor<0){
                             view.apresentaErro("O valor a ser sacado era negativo.\nA operação foi cancelada.");
                             return;
                        }
                        view.apresentaErro("O valor a ser sacado deixava o saldo abaixo do montante mínimo da conta.\nA operação foi cancelada.");
                    }
                }
            }
        }catch(Exception e){
            view.apresentaErro("Erro ao sacar.");
            e.printStackTrace();
        }
    }

    public void depositar() {
        try{
            ContaI conta = view.getContaParaManipular();
            Double valor = view.getValorDepositar();

            if (valor!=null){

                if (conta instanceof ContaCorrente){
                    ContaCorrente contaCorrente = (ContaCorrente)conta;
                    System.out.println(contaCorrente.getSaldo());
                    boolean ok = contaCorrente.deposita(valor);
                    System.out.println(contaCorrente.getSaldo());

                    if(ok){
                        contaDao.atualizaSaldo(contaCorrente.getSaldo(), contaCorrente.getId());
                        view.apresentaInfo("Foi depositado R$" + valor + " na conta.");
                        view.limpaCampos();
                    }else{
                        view.apresentaErro("O valor a ser depositado era negativo.\nA operação foi cancelada.");
                    }    
                }else if (conta instanceof ContaInvestimento){
                    ContaInvestimento contaInvestimento = (ContaInvestimento)conta;
                    System.out.println(contaInvestimento.getSaldo());
                    boolean ok = contaInvestimento.deposita(valor);
                    System.out.println(contaInvestimento.getSaldo());

                    if(ok){
                        contaDao.atualizaSaldo(contaInvestimento.getSaldo(), contaInvestimento.getId());
                        view.apresentaInfo("Foi depositado R$" + valor + " na conta.");
                        view.limpaCampos();
                    }else{
                        if (valor<0){
                             view.apresentaErro("O valor a ser depositado era negativo.\nA operação foi cancelada.");
                             return;
                        }
                        view.apresentaErro("O valor a ser depositado não era maior ou igual que o depósito mínimo da conta.\nA operação foi cancelada.");
                    }
                }
            }
        }catch(Exception e){
            view.apresentaErro("Erro ao depositar.");
            e.printStackTrace();
        }
    }

    public void saldo() {
        ContaI conta = view.getContaParaManipular();
        view.apresentaInfo("O saldo na conta é de R$ "+conta.getSaldo());
        view.limpaCampos();
    }

    public void remunerar() {
        ContaI conta = view.getContaParaManipular();
        conta.remunera();
        
        contaDao.atualizaSaldo(conta.getSaldo(), conta instanceof ContaCorrente?((ContaCorrente)conta).getId():((ContaInvestimento)conta).getId());
        
        view.apresentaInfo("Remuneração aplicada.");
        view.limpaCampos();
    }

    public void buscarConta(int selectedIndex) {
        if (selectedIndex == 0) {
            
            String busca = view.getBusca();
            System.out.println("Buscando: "+busca);
            List<ContaI> listaContas = contaDao.buscaContaPorCPF(busca.trim());
            
            view.mostrarListaContas(listaContas);
        }
    }
    
}
