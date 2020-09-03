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
            view.limpaCampos();
        }catch(Exception e) {
            if (e.getMessage().contains("Duplicate entry")){
                view.apresentaErro("Erro ao criar cliente. CPF ou RG já pertencem a outro cliente.");
                return;
            } else if (e.getMessage().contains("Data too long")){
                view.apresentaErro("Erro ao criar cliente. CPF deve ter apenas 11 caracteres e o RG no máximo 15.");
                return;
            }
            view.apresentaErro("Erro ao criar cliente.");
            e.printStackTrace();
        }
    }

    public void atualizarCliente() {
        try{
            Cliente cliente = view.getClienteParaAtualizar();
            
            if (cliente==null) {
                view.apresentaInfo("Selecione um cliente na tabela para atualizar.");
                return;
            }
            
            dao.atualizar(cliente);
            
            view.atualizarCliente(cliente);
        }catch(Exception e) {
            if (e.getMessage().contains("Duplicate entry")){
                view.apresentaErro("Erro ao criar cliente. CPF ou RG já pertencem a outro cliente.");
                return;
            }else if (e.getMessage().contains("Data too long")){
                view.apresentaErro("Erro ao criar cliente. CPF deve ter apenas 11 caracteres e o RG no máximo 15.");
                return;
            }
            view.apresentaErro("Erro ao atualizar cliente.");
            e.printStackTrace();
        }
    }

    public void excluirCliente() {
        try{
            List<Cliente> listaParaExcluir = view.getClientesParaExcluir();
            dao.excluirLista(listaParaExcluir);

            view.excluirClienteView(listaParaExcluir);
            view.limpaCampos();
        }catch(Exception e) {
            view.apresentaErro("Erro ao excluir o cliente.");
            e.printStackTrace();
        }
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

    public void buscarCliente(int atributo) {
        try{
            String busca = view.getBusca();
            List<Cliente> lista = dao.buscaClientes(busca.trim(), atributo);

            view.mostrarListaClientes(lista);
        }catch(Exception e) {
            view.apresentaErro("Erro ao listar clientes.");
            e.printStackTrace();
        }
    }
}
