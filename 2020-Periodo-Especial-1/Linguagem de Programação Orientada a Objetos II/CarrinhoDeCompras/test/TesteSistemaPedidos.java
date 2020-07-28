/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class TesteSistemaPedidos {
    
    public TesteSistemaPedidos() {
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
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testaConstrutorItemPedido() {
         ItemPedido item = new ItemPedido("Nome do item", 10.0, 1);
         
         assertEquals("Nome do item", item.getNome());
         assertEquals(10.0, item.getPreco(), 0.0);
         assertEquals(1, item.getQuantidade());
     }
     
     @Test
     public void testaConstrutorItemPedidoNomeVazio() {
         try{
            ItemPedido item = new ItemPedido("", 10.0, 1);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Nome não pode ser vazio.", e.getMessage());
         }   
     }
     
     @Test
     public void testaConstrutorItemPedidoNomeNulo() {
         try{
            ItemPedido item = new ItemPedido(null, 10.0, 1);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Nome não pode ser nulo.", e.getMessage());
         }   
     }
     
     @Test
     public void testaConstrutorItemPedidoPrecoNegativo() {
         try{
            ItemPedido item = new ItemPedido("Nome", -2, 1);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Preco não pode ser negativo.", e.getMessage());
         }   
     }
     
     @Test
     public void testaConstrutorItemPedidoQuantidadeInvalida() {
         try{
            ItemPedido item = new ItemPedido("Nome", 2.5, 0);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Quantidade não pode ser zero ou negativa.", e.getMessage());
         }   
     }
     
     @Test
     public void testaSetNomeItemPedido() {
         ItemPedido item = new ItemPedido("Nome do item", 10.0, 1);
         
         item.setNome("Nome alternativo");
         item.setPreco(12.0);
         item.setQuantidade(2);
         
         assertEquals("Nome alternativo", item.getNome());
         assertEquals(12.0, item.getPreco(), 0.0);
         assertEquals(2, item.getQuantidade());
     }
     
     @Test
     public void testaSetNomeItemPedidoVazio() {
         try{
            ItemPedido item = new ItemPedido("Nome", 2.5, 1);
            
            item.setNome("");
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Nome não pode ser vazio.", e.getMessage());
         }   
     }
     
     @Test
     public void testaSetNomeItemPedidoNulo() {
         try{
            ItemPedido item = new ItemPedido("Nome", 2.5, 1);
            
            item.setNome(null);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Nome não pode ser nulo.", e.getMessage());
         }   
     }
     
     @Test
     public void testaSetPrecoItemPedidoNegativo() {
         try{
            ItemPedido item = new ItemPedido("Nome", 2.5, 1);
            
            item.setPreco(-3.0);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Preco não pode ser negativo.", e.getMessage());
         }   
     }
     
     @Test
     public void testaSetQuantidadeItemPedidoInvalida() {
         try{
            ItemPedido item = new ItemPedido("Nome", 2.5, 1);
            
            item.setQuantidade(0);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Quantidade não pode ser zero ou negativa.", e.getMessage());
         }   
     }
}
