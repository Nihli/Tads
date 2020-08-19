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
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM contats");
            stmt.executeUpdate();	
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testaConexao() {
        try {
            Connection con = ConnectionFactory.getConnection();

        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void testaConexao2() {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM contatos");
            ResultSet rs = stmt.executeQuery();

            rs.next();

        } catch (Exception e) {
            fail(e.toString());
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

            long id = contato.getId();
            
            contato.setNome("Nome 2");
            contato.setEmail("email 2");
            contato.setEndereco("endereco 2");
            contato.setDataNascimento(LocalDate.of(1999, 06, 06));
            
            dao.altera(contato);

        } catch (Exception e) {
            fail(e.toString());
        }
    }
}
