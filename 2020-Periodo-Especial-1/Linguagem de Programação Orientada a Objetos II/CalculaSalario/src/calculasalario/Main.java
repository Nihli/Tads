/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculasalario;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Lia
 */
public class Main {

    private static double salarioHora;
    private static double horasTrabalhadas;
    private static double percentualINSS;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
       try{
           parametrosUsuario();
       
            double salarioBruto = CalculaSalario.salarioBruto(salarioHora, horasTrabalhadas);
            double salarioLiquido = CalculaSalario.salarioLiquido(salarioHora, horasTrabalhadas, percentualINSS);

            imprimeResultado(salarioHora,horasTrabalhadas,salarioBruto,salarioLiquido);
       }catch(Exception e){
            System.out.println("Houve um erro na execução do programa.");
            System.out.println(e.getMessage());
       }
    }
    
    private static void parametrosUsuario(){
        try{
            System.out.println("Para calcular o salário, entre com o salário recebido por hora: ");
            Scanner scanner = new Scanner(System.in);
            salarioHora = scanner.nextDouble();

            System.out.println("Entre também com as horas trabalhadas no mês: ");
            scanner = new Scanner(System.in);
            horasTrabalhadas = scanner.nextDouble();

            System.out.println("Por último, entre com o percentual de desconto do INSS: ");
            scanner = new Scanner(System.in);
            percentualINSS = scanner.nextDouble();
        }catch(Exception e){
            throw new InputMismatchException("Valor incorreto detectado. Por favor, entre com um valor positivo e decimal.");
        }
    }
    
    private static void imprimeResultado(double salarioHora, double horasTrabalhadas, double salarioBruto, double salarioLiquido) {
        System.out.println(
                            "Extrato de salário\n" +
                            "Valor Hora: R$ " + String.valueOf(salarioHora).replace(".",",") + " \n" +
                            "Horas trabalhadas: " + String.valueOf(horasTrabalhadas).replace(".",",") + " horas \n" +
                            "Salário Bruto: R$ " + String.valueOf(salarioBruto).replace(".",",") + " \n" +
                            "Salário Líquido: R$ " + String.valueOf(salarioLiquido).replace(".",",")
                        );
    }
}
