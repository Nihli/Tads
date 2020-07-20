/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import calculasalario.CalculaSalario;
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
public class TesteCalculaSalario {
    
    public TesteCalculaSalario() {
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
     public void testaSalarioBruto() {
         double salarioHora = 12.0;
         double horasTrabalhadas = 160;
         
         double resultado = CalculaSalario.salarioBruto(salarioHora, horasTrabalhadas);
         
         assertEquals(1920.0, resultado, 0.0);
     }

     @Test
     public void testaSalarioBruto2() {
         double salarioHora = 25.0;
         double horasTrabalhadas = 160;
         
         double resultado = CalculaSalario.salarioBruto(salarioHora, horasTrabalhadas);
         
         assertEquals(4000.0, resultado, 0.0);
     }
     
     @Test
     public void testaSalarioBruto3() {
         try{
            double salarioHora = 22.0;
            double horasTrabalhadas = 0;

            double resultado = CalculaSalario.salarioBruto(salarioHora, horasTrabalhadas);
            fail("Não levantou exceção.");
          }catch(Exception e){
             assertEquals("Não é possível calcular o salário com valores menores ou iguais a zero.", e.getMessage());
         }
     }
     
     @Test
     public void testaSalarioLiquido() {
         double salarioHora = 12.0;
         double horasTrabalhadas = 160;
         double percentualINSS = 0.05;
         
         double resultado = CalculaSalario.salarioLiquido(salarioHora, horasTrabalhadas, percentualINSS);
         
         assertEquals(1824.0, resultado, 0.0);
     }
     
     @Test
     public void testaSalarioLiquido2() {
         double salarioHora = 12.0;
         double horasTrabalhadas = 160;
         double percentualINSS = 0.025;
         
         double resultado = CalculaSalario.salarioLiquido(salarioHora, horasTrabalhadas, percentualINSS);
         
         assertEquals(1872.0, resultado, 0.0);
     }
     
      @Test
     public void testaSalarioLiquido3() {
         try{
            double salarioHora = 12.0;
            double horasTrabalhadas = 160;
            double percentualINSS = -0.025;

            double resultado = CalculaSalario.salarioLiquido(salarioHora, horasTrabalhadas, percentualINSS);
            
            fail("Não levantou exceção.");
          }catch(Exception e){
             assertEquals("Não é possível calcular o salário com valores menores ou iguais a zero.", e.getMessage());
         }
     }
}
