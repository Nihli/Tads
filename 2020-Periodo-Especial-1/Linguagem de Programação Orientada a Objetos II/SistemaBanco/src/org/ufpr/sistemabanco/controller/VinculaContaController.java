/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.controller;

import java.util.List;
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.dao.ClienteDao;
import org.ufpr.sistemabanco.view.vinculaconta.JanelaVinculaContaView;

/**
 *
 * @author Lia
 */
public class VinculaContaController {
    private JanelaVinculaContaView view;
    private ClienteDao clienteDao;

    public VinculaContaController(JanelaVinculaContaView view, ClienteDao clienteDao) {
        this.view = view;
        this.clienteDao = clienteDao;
        
        initController();
    }

     private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void buscarCliente(int atributo) {
        try{
            String busca = view.getBusca();
            List<Cliente> lista = clienteDao.buscaClientes(busca.trim(), atributo);

            view.mostrarListaClientes(lista);
        }catch(Exception e) {
            view.apresentaErro("Erro ao listar clientes.");
            e.printStackTrace();
        }
    }
    
    public void listarCliente() {
        try{
            List<Cliente> lista = clienteDao.listaClientes();

            view.mostrarListaClientes(lista);
        }catch(Exception e) {
            view.apresentaErro("Erro ao listar clientes.");
            e.printStackTrace();
        }
    }
}
