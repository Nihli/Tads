/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import carrinhodecompras.Pedido;
import carrinhodecompras.ItemPedido;
import java.util.ArrayList;
import java.util.List;
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
     
     @Test
     public void testaConstrutorPedido() {
         Pedido pedido = new Pedido(100.0, "Nome do pedido");
         
         assertEquals("Nome do pedido", pedido.getNomeCliente());
     }
     
     @Test
     public void testaGetListaItemDePedido() {
         Pedido pedido = new Pedido(100.0, "Nome do pedido");
         
         ItemPedido item = new ItemPedido("Nome do item", 10.0, 1);
         
         pedido.acrescentaItem(item);
         
         List<ItemPedido> itensPedido = pedido.getItens();
         
         List<ItemPedido> itens = new ArrayList();
         itens.add(item);
         
         assertEquals(itens, itensPedido);
     }
     
     @Test
     public void testaAcrescentarItemDePedido() {
         try{
             
            Pedido pedido = new Pedido(100.0, "Nome do pedido");

            ItemPedido item = new ItemPedido("Nome do item", 10.0, 1);

            pedido.acrescentaItem(null);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Item do pedido não pode ser nulo.", e.getMessage());
         }   
     }
     
     @Test
     public void testaAcrescentarItemDePedidoExcedendoTotal() {
         try{
             
            Pedido pedido = new Pedido(100.0, "Nome do pedido");

            ItemPedido item = new ItemPedido("Nome do item", 110.0, 1);

            pedido.acrescentaItem(item);
         
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Item de Pedido não incluído. Valor do pedido excedido.", e.getMessage());
         }   
     }
     
     @Test
     public void testaAcrescentarItemDePedidoExcedendoTotal2() {
         try{
            Pedido pedido = new Pedido(100.0, "Nome do pedido");
            
            ItemPedido item = new ItemPedido("Nome do item", 50, 1);

            pedido.acrescentaItem(item);
            
            ItemPedido item2 = new ItemPedido("Nome do item 2", 52, 1);
         
            pedido.acrescentaItem(item2);
            
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Item de Pedido não incluído. Valor do pedido excedido.", e.getMessage());
         }   
     }
     
     @Test
     public void testaAcrescentarItemDePedidoTotalSendoZero() { 
         try{
            Pedido pedido = new Pedido(0.0, "Nome do pedido");
            
            ItemPedido item = new ItemPedido("Nome do item", 50, 1);

            pedido.acrescentaItem(item);
           
            fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Cliente não tem nenhum crédito.", e.getMessage());
         }   
     }
     
     @Test
     public void testaAcrescentarItemJaExistenteDePedido() {

        Pedido pedido = new Pedido(100.0, "Nome do pedido");
            
        ItemPedido item = new ItemPedido("Nome do item", 50, 1);

        pedido.acrescentaItem(item);
        pedido.acrescentaItem(item);
            
        List<ItemPedido> itens = pedido.getItens();
        assertEquals(2, itens.get(0).getQuantidade());
     }
     
     @Test
     public void testaRetiraItemDePedido() {

        Pedido pedido = new Pedido(100.0, "Nome do pedido");
            
        ItemPedido item = new ItemPedido("Nome do item", 50, 1);

        pedido.acrescentaItem(item);
        pedido.retiraItem("Nome do item");
            
        List<ItemPedido> itens = pedido.getItens();
        assertEquals(false, itens.contains(item));
     }
     
     @Test
     public void testaRetiraItemQtdMaiorQueUmDePedido() {

        Pedido pedido = new Pedido(100.0, "Nome do pedido");
            
        ItemPedido item = new ItemPedido("Nome do item", 50, 1);

        pedido.acrescentaItem(item);
        pedido.acrescentaItem(item);
        pedido.retiraItem("Nome do item");
            
        List<ItemPedido> itens = pedido.getItens();
        assertEquals(1, itens.get(0).getQuantidade());
     }
     
     @Test
     public void testaRetiraItemInexistenteDePedido() {
        try{
            Pedido pedido = new Pedido(100.0, "Nome do pedido");

            ItemPedido item = new ItemPedido("Nome do item", 50, 1);

            pedido.acrescentaItem(item);
            pedido.acrescentaItem(item);
            pedido.retiraItem("Nome qualquer");
            
           fail("Não levantou exceção");
         }catch(Exception e){
            assertEquals("Item não encontrado no pedido.", e.getMessage());
         }
     }
}
