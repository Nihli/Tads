/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.ufpr.sistemabanco.model.Cliente;

/**
 *
 * @author Lia
 */
public class ClienteDao {
    private final String stmtInsere = "INSERT INTO cliente(nome, sobrenome, rg, cpf, endereco) VALUES (?,?,?,?,?)";
    private final String stmtListar = "SELECT * FROM cliente";
    private final String stmtExcluir = "DELETE FROM cliente WHERE id=?";
    
    public void insere(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtInsere, Statement.RETURN_GENERATED_KEYS);
            
            int x = 0;
            
            stmt.setString(++x, cliente.getNome());
            stmt.setString(++x, cliente.getSobrenome());
            stmt.setString(++x, cliente.getRg());
            stmt.setString(++x, cliente.getCpf());
            stmt.setString(++x, cliente.getEndereco());
            
            stmt.execute();
            
            rs = stmt.getGeneratedKeys();
            rs.next();
            cliente.setId(rs.getInt(1));
            
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                ConnectionFactory.close(conn, stmt, rs);
            }catch(SQLException e){
                throw new RuntimeException("Houve um erro ao fechar os atributos da conexão.");
            }
        }
    }
    
       public List<Cliente> listaClientes() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtListar);

            rs = stmt.executeQuery();
            
            List<Cliente> clientes = new ArrayList();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                
                clientes.add(c);
            }
            
            return clientes;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                ConnectionFactory.close(conn, stmt, rs);
            }catch(SQLException e){
                throw new RuntimeException("Houve um erro ao fechar os atributos da conexão.");
            }
        }
    }
       
    public void remove(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtExcluir);
            
            int x = 0;
            
            stmt.setLong(++x, cliente.getId());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        finally{
            try{
                ConnectionFactory.close(conn, stmt);
            }catch(SQLException e){
                throw new RuntimeException("Houve um erro ao fechar os atributos da conexão.");
            }
        }
    }

    public void excluirLista(List<Cliente> listaParaExcluir) {
        for (Cliente cliente: listaParaExcluir) {
            remove(cliente);
        }
    }
}
