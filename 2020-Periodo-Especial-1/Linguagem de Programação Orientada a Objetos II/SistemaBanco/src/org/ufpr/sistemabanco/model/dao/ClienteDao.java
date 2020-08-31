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
    private final String stmtInserir = "INSERT INTO cliente(nome, sobrenome, rg, cpf, endereco, salario) VALUES (?,?,?,?,?,?)";
    private final String stmtListar = "SELECT * FROM cliente";
    private final String stmtBuscarPorNome = "SELECT * FROM cliente WHERE nome LIKE ?";
    private final String stmtBuscarPorSobrenome = "SELECT * FROM cliente WHERE sobrenome LIKE ?";
    private final String stmtBuscarPorRg = "SELECT * FROM cliente WHERE rg LIKE ?";
    private final String stmtBuscarPorCpf = "SELECT * FROM cliente WHERE cpf LIKE ?";
    private final String stmtExcluir = "DELETE FROM cliente WHERE id=?";
    private final String stmtAtualizar = "UPDATE cliente SET nome=?, sobrenome=?, rg=?, cpf=?, endereco=?, salario=? WHERE id=?";
    
    public void insere(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtInserir, Statement.RETURN_GENERATED_KEYS);
            
            int x = 0;
            
            stmt.setString(++x, cliente.getNome());
            stmt.setString(++x, cliente.getSobrenome());
            stmt.setString(++x, cliente.getRg());
            stmt.setString(++x, cliente.getCpf());
            stmt.setString(++x, cliente.getEndereco());
            stmt.setDouble(++x, cliente.getSalario());
            
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
                c.setSalario(rs.getDouble("salario"));
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
       
    public void atualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtAtualizar);
            
            int x = 0;
            
            stmt.setString(++x, cliente.getNome());
            stmt.setString(++x, cliente.getSobrenome());
            stmt.setString(++x, cliente.getRg());
            stmt.setString(++x, cliente.getCpf());
            stmt.setString(++x, cliente.getEndereco());
            stmt.setDouble(++x, cliente.getSalario());
            stmt.setInt(++x, cliente.getId());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                ConnectionFactory.close(conn, stmt);
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

    public List<Cliente> buscaClientes(String busca, int opcao) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            
            switch(opcao) {
                case 0:
                    stmt = conn.prepareStatement(stmtBuscarPorNome);
                    break;
                case 1:
                    stmt = conn.prepareStatement(stmtBuscarPorSobrenome);
                    break;
                case 2:
                    stmt = conn.prepareStatement(stmtBuscarPorRg);
                    break;
                case 3:
                    stmt = conn.prepareStatement(stmtBuscarPorCpf);
                    break;
            }
            
            int x = 0;

            stmt.setString(++x, "%"+busca+"%");

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
                c.setSalario(rs.getDouble("salario"));
                
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
}
