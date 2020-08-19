/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lia
 */
public class TesteCRUDContatos {

    public TesteCRUDContatos() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Connection con=null;
        PreparedStatement stmt=null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("DELETE FROM contatos");
            stmt.executeUpdate();	
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {ConnectionFactory.close(con, stmt);} catch (SQLException ex) {throw new RuntimeException("Falha ao fechar conexão.");}
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testaConexao() {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            
        } catch (Exception e) {
            fail(e.toString());
        } finally {
            try {con.close();} catch (SQLException ex) {throw new RuntimeException("Falha ao fechar conexão.");}
        }
    }

    @Test
    public void testaConexao2() {        
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM contatos");
            rs = stmt.executeQuery();

            rs.next();
            
            ConnectionFactory.close(con, stmt,rs);
            
        } catch (Exception e) {
            fail(e.toString());
        } finally {
            try {ConnectionFactory.close(con, stmt,rs);} catch (SQLException ex) {throw new RuntimeException("Falha ao fechar conexão.");}
        }
    }

    @Test
    public void testaDaoInserir() {
        try {
            ContatoDao dao = new ContatoDao();

            Contato contato = new Contato(-2L, "Nome", "email", "endereco", LocalDate.of(1999, 06, 05));

            dao.insere(contato);

            long id = contato.getId();

            assertEquals(true, id != -2L);

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void testaDaoAlterar() {
        try {

            ContatoDao dao = new ContatoDao();

            Contato contato = new Contato(-2L, "Nome", "email", "endereco", LocalDate.of(1999, 06, 05));

            dao.insere(contato);
            
            contato.setNome("Nome 2");
            contato.setEmail("email 2");
            contato.setEndereco("endereco 2");
            contato.setDataNascimento(LocalDate.of(1999, 06, 06));
            
            dao.altera(contato);

        } catch (Exception e) {
            fail(e.toString());
        }
    }
    
    @Test
    public void testaDaoRemover() {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try {

            ContatoDao dao = new ContatoDao();

            Contato contato = new Contato(-2L, "Nome deletar", "email", "endereco", LocalDate.of(1999, 06, 05));

            dao.insere(contato);

            long id = contato.getId();
            
            dao.remove(contato);
            
            con = ConnectionFactory.getConnection();
            
            stmt = con.prepareStatement("SELECT nome FROM contatos WHERE id = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()){
                fail("Não removeu o contato.");
            }
            
        } catch (Exception e) {
            fail(e.toString());
        } finally {
            try {ConnectionFactory.close(con, stmt,rs);} catch (SQLException ex) {throw new RuntimeException("Falha ao fechar conexão.");}
        }
    }
    
    @Test
    public void testaDaoListar() {
        try {

            ContatoDao dao = new ContatoDao();

            Contato contato = new Contato(-2L, "Nome listar 01", "email", "endereco", LocalDate.of(1999, 06, 05));
            Contato contato2 = new Contato(-3L, "Nome listar 02", "email", "endereco", LocalDate.of(1999, 06, 05));
            
            dao.insere(contato);
            dao.insere(contato2);

            List<Contato> lista = dao.lista();
            
            if(lista.isEmpty()){
                fail("Lista retornou vazia.");
            }else{
                for(Contato c : lista) {
                    System.out.println(c);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testaDaoObterContato() {
        try {

            ContatoDao dao = new ContatoDao();

            Contato contato = new Contato(-2L, "Nome 01", "email", "endereco", LocalDate.of(1999, 06, 05));       
            
            dao.insere(contato);

            Contato c = dao.obterContato(contato.getId());
            
            if(!contato.equals(c)){
                fail("Não retornou o contato.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
