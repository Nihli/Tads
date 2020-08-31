/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.controller;

import java.util.List;
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.dao.ClienteDao;
import org.ufpr.sistemabanco.view.cliente.JanelaClienteView;

/**
 *
 * @author Lia
 */
public class ClienteController {
    private JanelaClienteView view;
    private ClienteDao dao;

    public ClienteController(JanelaClienteView view, ClienteDao dao) {
        this.view = view;
        this.dao = dao;
        
        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void criarCliente() {
        try{
            Cliente cliente = view.getClienteFormulario();
            dao.insere(cliente);

            view.inserirClienteView(cliente);
        }catch(Exception e) {
            view.apresentaErro("Erro ao criar cliente.");
            e.printStackTrace();
        }
    }

    public void atualizarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluirCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void listarCliente() {
        try{
            List<Cliente> lista = dao.listaClientes();

            view.mostrarListaClientes(lista);
        }catch(Exception e) {
            view.apresentaErro("Erro ao listar clientes.");
            e.printStackTrace();
        }
    }
    
    
}
