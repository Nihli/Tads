/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.controller;

import java.util.Collections;
import java.util.List;
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.ContaCorrente;
import org.ufpr.sistemabanco.model.ContaInvestimento;
import org.ufpr.sistemabanco.model.dao.ClienteDao;
import org.ufpr.sistemabanco.model.dao.ContaDao;
import org.ufpr.sistemabanco.view.vinculaconta.JanelaVinculaContaView;

/**
 *
 * @author Lia
 */
public class VinculaContaController {
    private JanelaVinculaContaView view;
    private ClienteDao clienteDao;
    private ContaDao contaDao;

    public VinculaContaController(JanelaVinculaContaView view, ClienteDao clienteDao, ContaDao contaDao) {
        this.view = view;
        this.clienteDao = clienteDao;
        this.contaDao = contaDao;
        
        initController();
    }

     private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void buscarCliente(int atributo) {
        try{
            String busca = view.getBusca();
            
            List<Cliente> lista = clienteDao.listaClientesComConta(busca.trim(), atributo);

            view.mostrarListaClientes(lista);
        }catch(Exception e) {
            view.apresentaErro("Erro ao listar clientes.");
            e.printStackTrace();
        }
    }
    
    public void listarCliente() {
        try{
            List<Cliente> lista = clienteDao.listaClientesComConta();
            
            Collections.sort(lista);

            view.mostrarListaClientes(lista);
        }catch(Exception e) {
            view.apresentaErro("Erro ao listar clientes.");
            e.printStackTrace();
        }
    }

    public void criarContaCorrente() {
        try{
            Cliente cliente = view.getClienteParaVincular();

            if (cliente == null) {
                 view.apresentaInfo("Nenhum cliente selecionado para criar a conta.");
                 return;
            }
            
            ContaCorrente conta = view.getContaCorrente(cliente);
           
            if (conta!=null){
                contaDao.insere(conta);

//                view.mostraNumeroConta(conta.getNumero());
                view.apresentaInfo("Conta corrente criada!\nNúmero da conta: "+ conta.getNumero());
                view.limpaCampos();
            }
            
        }catch(Exception e){
            if (e.getMessage().contains("Duplicate entry")){
                view.apresentaErro("Erro ao criar a conta. Cliente já possui uma conta vinculada a ele.");
            }else{
                view.apresentaErro("Erro ao criar a conta.");
                e.printStackTrace();
            }
        }
    }
    
     public void criarContaInvestimento() {
        try{
            Cliente cliente = view.getClienteParaVincular();

            if (cliente == null) {
                 view.apresentaInfo("Nenhum cliente selecionado para criar a conta.");
                 return;
            }

            ContaInvestimento conta = view.ContaInvestimento(cliente);

            if (conta!=null){
                contaDao.insere(conta);

//                view.mostraNumeroConta(conta.getNumero());
                 view.apresentaInfo("Conta investimento criada!\nNúmero da conta: "+ conta.getNumero());

                view.limpaCampos();
            }
        }catch(Exception e){
            if (e.getMessage().contains("Duplicate entry")){
                view.apresentaErro("Erro ao criar a conta. Cliente já possui uma conta vinculada a ele.");
            }else{
                view.apresentaErro("Erro ao criar a conta.");
                e.printStackTrace();
            }
        }
    }
}
