/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculaarea.CalculaArea;
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
public class TesteCalculaArea {
    
    public TesteCalculaArea() {
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
     public void testaAreaRetangulo() {
         double base = 2.0;
         double altura = 2.5;
         
         double resultado = CalculaArea.areaRetangulo(base, altura);
         
         assertEquals(5.0, resultado, 0.0);
     }
     
     @Test
     public void testaAreaRetangulo2() {
         double base = 2.0;
         double altura = 5.0;
         
         double resultado = CalculaArea.areaRetangulo(base, altura);
         
         assertEquals(10.0, resultado, 0.0);
     }

     @Test
     public void testaAreaRetangulo3() {
         try{
            double base = -2.0;
            double altura = 3.2;

            double resultado = CalculaArea.areaRetangulo(base, altura);

            fail("Não levantou exceção.");
         }catch(Exception e){
             assertEquals("Não é possível calcular a área com números negativos.", e.getMessage());
         }
     }
     
     @Test
     public void testaAreaCircunferencia() {
         double raio = 2.0;
         final double pi = 3.14;
         
         double resultado = CalculaArea.areaCircunferencia(raio);
         
         assertEquals(12.56, resultado, 0.0);
     }
     
     @Test
     public void testaAreaCircunferencia2() {
         double raio = 5.4;
         final double pi = 3.14;
         
         double resultado = CalculaArea.areaCircunferencia(raio);
         
         assertEquals(91.56, resultado, 0.005);
     }
     
     @Test
     public void testaAreaCircunferencia3() {
         try{
            double raio = -3.0;
            final double pi = 3.14;

            double resultado = CalculaArea.areaCircunferencia(raio);

            fail("Não levantou exceção.");
         }catch(Exception e){
             assertEquals("Não é possível calcular a área com números negativos.", e.getMessage());
         }
     }
     
     @Test
     public void testaAreaTriangulo() {
         double base = 7.0;
         double altura = 1.2;
         
         double resultado = CalculaArea.areaTriangulo(base, altura);
         
         assertEquals(4.2, resultado, 0.0);
     }
     
      @Test
     public void testaAreaTriangulo2() {
         double base = 0.5;
         double altura = 2;
         
         double resultado = CalculaArea.areaTriangulo(base, altura);
         
         assertEquals(0.5, resultado, 0.0);
     }
     
     @Test
     public void testaAreaTriangulo3() {
         try{
            double base = -1.0;
            double altura = 3.4;

            double resultado = CalculaArea.areaTriangulo(base,altura);

            fail("Não levantou exceção.");
         }catch(Exception e){
             assertEquals("Não é possível calcular a área com números negativos.", e.getMessage());
         }
     }
}
