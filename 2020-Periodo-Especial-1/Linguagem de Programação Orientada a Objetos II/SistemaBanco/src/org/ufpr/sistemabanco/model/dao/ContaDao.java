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
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.ContaCorrente;

/**
 *
 * @author Lia
 */
public class ContaDao {
    private final String stmtInserirCorrente = "INSERT INTO conta(idCliente, saldo, depositoInicial, limite, numero) VALUES (?,?,?,?,?)";
    private final String stmtAtualizarCorrenteNumero = "UPDATE conta SET numero=? WHERE idConta=?";

    
    public void insere(ContaCorrente conta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(stmtInserirCorrente, Statement.RETURN_GENERATED_KEYS);
            
            int x = 0;
            
            stmt.setInt(++x, conta.getDono().getId());
            stmt.setDouble(++x, conta.getSaldo());
            stmt.setDouble(++x, conta.getDepositoInicial());
            stmt.setDouble(++x, conta.getLimite());
            stmt.setInt(++x,0);
            
            stmt.execute();
            
            rs = stmt.getGeneratedKeys();
            rs.next();
            conta.setId(rs.getInt(1));
            
            int num = 10000+conta.getId();
            
            atualizaNumeroConta(stmtAtualizarCorrenteNumero, conn, conta.getId(), num);
            conta.setNumero(num);
            System.out.println("Bom dia");
            conn.commit();
        }catch(SQLException e){
            try{conn.rollback();}catch(SQLException ex1){throw new RuntimeException(e.getMessage());};
            throw new RuntimeException(e.getMessage());
        }finally{
            try{
                ConnectionFactory.close(conn, stmt, rs);
            }catch(SQLException e){
                throw new RuntimeException("Houve um erro ao fechar os atributos da conexão.");
            }
        }
    }
    
    public void atualizaNumeroConta(String sql, Connection conn, int id, int num) {
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            
            int x = 0;
            
            stmt.setInt(++x, num);
            stmt.setInt(++x,id);
            
            stmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
