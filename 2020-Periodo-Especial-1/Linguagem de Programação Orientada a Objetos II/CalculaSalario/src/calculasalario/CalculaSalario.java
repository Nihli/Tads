package calculasalario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
public class CalculaSalario {

    public static double salarioBruto(double salarioHora, double horasTrabalhadas) {
        if(salarioHora<=0 || horasTrabalhadas<=0){
            throw new RuntimeException("Não é possível calcular o salário com valores menores ou iguais a zero.");
        }else{
           return (salarioHora*horasTrabalhadas);
        }
    }

    public static double salarioLiquido(double salarioHora, double horasTrabalhadas, double percentualINSS) {
        if (percentualINSS <=0){
            throw new RuntimeException("Não é possível calcular o salário com valores menores ou iguais a zero.");
        }else{
            double salarioBruto = salarioBruto(salarioHora, horasTrabalhadas);
            double desconto = salarioBruto*percentualINSS;
            return (salarioBruto-desconto);
        }
    }
    
}
