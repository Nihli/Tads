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
    private final String stmtExcluir = "DELETE FROM autor WHERE ID = ?";
    private final String stmtExcluirRelacionamento = "DELETE FROM livro_autor WHERE idAutor = ?";
    private final String stmtAtualizar = "UPDATE autor set nome=?, dataNascimento=?, documento=?, nacionalidade=? WHERE id=?";


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

    public void atualizar(Autor autor) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            
            stmt = con.prepareStatement(stmtAtualizar);
 
            stmt.setString(1, autor.getNome());
            stmt.setDate(2, Date.valueOf(autor.getDataNascimento()));
            stmt.setString(3, autor.getDocumento());
            stmt.setString(4,autor.getNacionalidade());
            stmt.setLong(5, autor.getId());
            stmt.executeUpdate();
            
            excluirRelacionamento(autor.getId(),con);
            
            this.gravarLivros(autor, con);

            con.commit();
         } catch (SQLException ex) {
            con.rollback();
            throw new RuntimeException("Erro ao atualizar um autor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }

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
                
                autor.setLivros(lerLivros(autor.getId(), con), 1);
                autor.setListaLivros();
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
    
    public void excluirAutor(long id) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            con.setAutoCommit(false);
            excluirRelacionamento(id, con);
            stmt = con.prepareStatement(stmtExcluir);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            throw new RuntimeException("Erro ao inserir um autor no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }        
    }
    
    public void excluirRelacionamento(long id, Connection con){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(stmtExcluirRelacionamento);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir um relacionamento no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
        }        
    }
    
    public void excluirLista(List<Autor> autores) throws SQLException{
        for (Autor a: autores) {
            excluirAutor(a.getId());
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
                autor.setLivros(listLivros, 1);
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
        String sql = "SELECT livro.id,livro.titulo, livro.assunto, livro.codigoIsbn, livro.dataPublicacao"
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
            Livro livroLido = new Livro();
            livroLido.setTitulo(resultado.getString("titulo"));
//            livroLido.setAutores(listaAutores);
            livroLido.setId(resultado.getInt("id"));
            LocalDate dataPublicacao = resultado.getDate("dataPublicacao").toLocalDate();
            livroLido.setDataPublicacao(dataPublicacao);
            livroLido.setAssunto(resultado.getString("assunto"));
            livroLido.setCodigoIsbn(resultado.getString("codigoIsbn"));
//            System.out.println(livroLido);
            livros.add(livroLido);
        }

        return livros;
    }
    
}
