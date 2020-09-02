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
import java.util.ArrayList;
import java.util.List;
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.ContaCorrente;
import org.ufpr.sistemabanco.model.ContaI;
import org.ufpr.sistemabanco.model.ContaInvestimento;

/**
 *
 * @author Lia
 */
public class ContaDao {
    private final String stmtInserirCorrente = "INSERT INTO conta(idCliente, saldo, depositoInicial, limite, numero,tipo) VALUES (?,?,?,?,?,?)";
    private final String stmtAtualizarContaNumero = "UPDATE conta SET numero=? WHERE idConta=?";
    private final String stmtInserirInvestimento = "INSERT INTO conta(idCliente, saldo, depositoInicial, montanteMinimo, depositoMinimo, numero, tipo) VALUES (?,?,?,?,?,?,?)";
    private final String stmtContaPorCpf = "SELECT * FROM cliente as c INNER JOIN conta as co ON c.id = co.idCliente WHERE c.cpf LIKE ?";
    private final String stmtAtualizarSaldo = "UPDATE conta SET saldo=? WHERE idConta=?";

    
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
            stmt.setString(++x,"cc");
            
            stmt.execute();
            
            rs = stmt.getGeneratedKeys();
            rs.next();
            conta.setId(rs.getInt(1));
            
            int num = 10000+conta.getId();
            
            atualizaNumeroConta(stmtAtualizarContaNumero, conn, conta.getId(), num);
            conta.setNumero(num);

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
    
    public void insere(ContaInvestimento conta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(stmtInserirInvestimento, Statement.RETURN_GENERATED_KEYS);
            
            int x = 0;

            stmt.setInt(++x, conta.getDono().getId());
            stmt.setDouble(++x, conta.getSaldo());
            stmt.setDouble(++x, conta.getDepositoInicial());
            stmt.setDouble(++x, conta.getMontanteMinimo());
            stmt.setDouble(++x, conta.getDepositoMinimo());
            stmt.setInt(++x,0);
            stmt.setString(++x,"ci");
            
            stmt.execute();
            
            rs = stmt.getGeneratedKeys();
            rs.next();
            conta.setId(rs.getInt(1));
            
            int num = 10000+conta.getId();
            
            atualizaNumeroConta(stmtAtualizarContaNumero, conn, conta.getId(), num);
            conta.setNumero(num);

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

    public List<ContaI> buscaContaPorCPF(String busca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtContaPorCpf);
            
            int x = 0;
            
            stmt.setString(++x, "%"+busca+"%");

            rs = stmt.executeQuery();
            
            List<ContaI> contas = new ArrayList();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setSalario(rs.getDouble("salario"));
                c.setPossuiConta(true);

                if (rs.getString("tipo").equals("cc")){
                    ContaCorrente cc = new ContaCorrente(rs.getDouble("limite"),c, rs.getDouble("depositoInicial"), rs.getInt("numero"), rs.getDouble("saldo"));
                    cc.setId(rs.getInt("idConta"));
                    contas.add(cc);
                }else if (rs.getString("tipo").equals("ci")){
                    ContaInvestimento ci = new ContaInvestimento(rs.getDouble("montanteMinimo"), rs.getDouble("depositoMinimo"), c, rs.getDouble("depositoInicial"), rs.getInt("numero"), rs.getDouble("saldo"));
                    ci.setId(rs.getInt("idConta"));
                    contas.add(ci);
                }
            }
            
            return contas;
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

    public void atualizaSaldo(double valor, int id) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtAtualizarSaldo);
            
            int x = 0;
            
            stmt.setDouble(++x, valor);
            stmt.setInt(++x, id);
            
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
}
