package org.ufpr.lpooii.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.ufpr.lpooii.model.Autor;
import org.ufpr.lpooii.model.Livro;

public class AutorDAO {

    private final String stmtInserir = "INSERT INTO autor(nome, dataNascimento, documento, nacionalidade) VALUES(?,?,?,?)";
    private final String stmtConsultar = "SELECT * FROM autor WHERE id = ?";
    private final String stmtListar = "SELECT * FROM autor";
    private final String stmtExcluir = "DELETE FORM SELECT * FROM auAUTOR WHERE ID = ?";

    public void inserirAutor(Autor autor) {
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            stmt = con.prepareStatement(stmtInserir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, autor.getNome());
            stmt.setDate(2, Date.valueOf(autor.getDataNascimento()));
            stmt.setString(3, autor.getDocumento());
            stmt.setString(4, autor.getNacionalidade());
            stmt.executeUpdate();
            autor.setId(lerIdAutor(stmt));
            
            this.gravarLivros(autor, con);

            con.commit();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um autor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
     }
    
    private int lerIdAutor(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public Autor consultarAutor(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autor autorLido;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtConsultar);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                autorLido = new Autor(rs.getString("nome"));
                autorLido.setId(rs.getInt("id"));
                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
                autorLido.setDataNascimento(dataNascimento);
                autorLido.setDocumento(rs.getString("documento"));
                autorLido.setNacionalidade(rs.getString("nacionalidade"));
                return autorLido;
            }else{
                throw new RuntimeException("Não existe autor com este id. Id="+id);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar um autor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }

    }
    
    private void gravarLivros(Autor autor, Connection con) throws SQLException {
        String sql = "INSERT INTO livro_autor (idLivro, idAutor) VALUES ( ?, ?)";
        PreparedStatement stmt;
        stmt = con.prepareStatement(sql);
        stmt.setInt(2, autor.getId());
        List<Livro> livros = autor.getLivros();
        for (Livro livro : livros) {
            stmt.setLong(1, livro.getId());
            stmt.executeUpdate();
        }
    }

    public List<Autor> listarAutores() throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Autor> lista = new ArrayList();
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            while(rs.next()){
                Autor autor = new Autor(rs.getString("nome"));
                autor.setId(rs.getInt("id"));
                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
                autor.setDataNascimento(dataNascimento);
                autor.setDocumento(rs.getString("documento"));
                autor.setNacionalidade(rs.getString("nacionalidade"));
                lista.add(autor);
            }
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar uma lista de autores. Origem="+ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar result set. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};               
        }

    }
    
    public void excluirAutor(long id){
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtExcluir);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um autor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }        
    }
    
    public Autor listarLivrosDeUmAutor(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtConsultar);         
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Autor autor = null;
            if (rs.next()) {
                autor = new Autor(rs.getString("nome"));
                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
                autor.setDataNascimento(dataNascimento);
                autor.setDocumento(rs.getString("documento"));
                autor.setNacionalidade(rs.getString("nacionalidade"));
                List<Livro> listLivros = lerLivros(id,con);
                autor.setLivros(listLivros);
                autor.setId(id);
            }

            return autor;            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao listar um livro com autores no banco de dados. Origem="+ex.getMessage());            
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar rs. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};                
        }
    }
    
    

    private List<Livro> lerLivros(long idAutor, Connection con) throws SQLException{
        //Select para pegar os autores de um livro
        String sql = "SELECT livro.id,livro.titulo"
                + " FROM livro"
                + " INNER JOIN livro_autor"
                + " 	ON livro.id = livro_autor.idLivro"
                + " WHERE livro_autor.idAutor = ? ";
        PreparedStatement stmt = null;
        List<Livro> livros = null;
        stmt = con.prepareStatement(sql);
        stmt.setLong(1, idAutor);
        ResultSet resultado = stmt.executeQuery();
        livros = new ArrayList<Livro>();
        while (resultado.next()) {
            Livro livroLido = new Livro(resultado.getString("titulo"));
            livroLido.setId(resultado.getInt("id"));
            System.out.println(livroLido);
            livros.add(livroLido);
        }

        return livros;
    }
    
}
