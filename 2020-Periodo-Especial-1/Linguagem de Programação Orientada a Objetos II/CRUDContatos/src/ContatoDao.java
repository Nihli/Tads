
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
public class ContatoDao {

    public void insere(Contato contato) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("INSERT INTO contatos(nome,email,endereco,datanascimento) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            int x = 0;
            
            stmt.setString(++x, contato.getNome());
            stmt.setString(++x, contato.getEmail());
            stmt.setString(++x, contato.getEndereco());
            stmt.setString(++x, contato.getDataNascimento().toString());
            
            stmt.execute();
            
            rs = stmt.getGeneratedKeys();
            rs.next();
            contato.setId(rs.getLong(1));
            System.out.println(contato.getId());
            
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
    
    public void altera(Contato contato) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("UPDATE contatos SET nome=?, email=?, endereco=?, datanascimento=? WHERE id=?");
            
            int x = 0;
            
            stmt.setString(++x, contato.getNome());
            stmt.setString(++x, contato.getEmail());
            stmt.setString(++x, contato.getEndereco());
            stmt.setString(++x, contato.getDataNascimento().toString());
            stmt.setLong(++x, contato.getId());
            
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
