/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import formasgeometricas.Circunferencia;
import formasgeometricas.Triangulo;
import formasgeometricas.Retangulo;
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
public class testeFormaGeometrica {
    
    public testeFormaGeometrica() {
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
     public void testaConstrutorCircunferencia() {
         Circunferencia circunferencia = new Circunferencia(2.5);
         
         assertEquals(2.5, circunferencia.getRaio(), 0.0);
     }
     
     @Test
     public void testaConstrutorCircunferencia2() {
         try{
            Circunferencia circunferencia = new Circunferencia(-4.0);
         
            fail("Não levantou exceção.");
         }catch(Exception e){
            assertEquals("Valores negativos não são permitidos para essa forma geométrica.", e.getMessage());
         }
     }
     
     @Test
     public void testaConstrutorRetangulo() {
         Retangulo retangulo = new Retangulo(5.0,6.2);
         
         assertEquals(5.0, retangulo.getLado1(), 0.0);
         assertEquals(6.2, retangulo.getLado2(), 0.0);
     }

     @Test
     public void testaConstrutorRetangulo2() {
         try{
            Retangulo retangulo = new Retangulo(2.0,-1.2);
         
            fail("Não levantou exceção.");
         }catch(Exception e){
            assertEquals("Valores negativos não são permitidos para essa forma geométrica.", e.getMessage());
         }
     }
     
     @Test
     public void testaConstrutorTriangulo() {
         Triangulo triangulo = new Triangulo(7.4,2.5);
         
         assertEquals(7.4, triangulo.getBase(), 0.0);
         assertEquals(2.5, triangulo.getAltura(), 0.0);
     }

     @Test
     public void testaConstrutorTriangulo2() {
         try{
            Triangulo triangulo = new Triangulo(10.0,-1.5);
         
            fail("Não levantou exceção.");
         }catch(Exception e){
            assertEquals("Valores negativos não são permitidos para essa forma geométrica.", e.getMessage());
         }
     }
     
     @Test
     public void testaAreaCircunferencia() {
         Circunferencia circunferencia = new Circunferencia(5.0);
         
         double resultado = circunferencia.area();
         
         assertEquals(78.5, resultado, 0.0);
     }
     
     @Test
     public void testaAreaCircunferencia2() {
         Circunferencia circunferencia = new Circunferencia(0.0);
         
         double resultado = circunferencia.area();
         
         assertEquals(0.0, resultado, 0.0);
     }
     
     @Test
     public void testaAreaRetangulo() {
         Retangulo retangulo = new Retangulo(3.0,4.0);
         
         double resultado = retangulo.area();
         
         assertEquals(12.0, resultado, 0.0);
     }
     
     @Test
     public void testaAreaRetangulo2() {
         Retangulo retangulo = new Retangulo(5.0,5.0);
         
         double resultado = retangulo.area();
         
         assertEquals(25.0, resultado, 0.0);
     }
     
     @Test
     public void testaAreaTriangulo() {
         Triangulo triangulo = new Triangulo(2.0,1.5);
         
         double resultado = triangulo.area();
         
         assertEquals(1.5, resultado, 0.0);
     }
     
     @Test
     public void testaAreaTriangulo2() {
         Triangulo triangulo = new Triangulo(10.0,1.5);
         
         double resultado = triangulo.area();
         
         assertEquals(7.5, resultado, 0.0);
     }
     
     @Test
     public void testaPerimetroRetangulo() {
         Retangulo retangulo = new Retangulo(3.0,4.0);
         
         double resultado = retangulo.perimetro();
         
         assertEquals(14.0, resultado, 0.0);
     }
     
     @Test
     public void testaPerimetroRetangulo2() {
         Retangulo retangulo = new Retangulo(0.0,7.0);
         
         double resultado = retangulo.perimetro();
         
         assertEquals(14.0, resultado, 0.0);
     }
}
