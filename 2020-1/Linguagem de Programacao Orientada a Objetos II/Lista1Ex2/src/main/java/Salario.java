public class Salario {

    public static double calculaSalarioBruto(double valorHora, double horasTrabalhadas){
        try{

            if (valorHora<0||horasTrabalhadas<0){
                throw new RuntimeException("Essa função não aceita parâmetros negativos.");
            }

            return valorHora*horasTrabalhadas;
        }catch(RuntimeException e){
            return -1;
        }
    }

    public static double calculaSalarioLiquido(double salarioBruto, double percentualInss){
        try{

            if (salarioBruto<0||percentualInss<0){
                throw new RuntimeException("Essa função não aceita parâmetros negativos.");
            }

            double valorDecimaldoPercentual = percentualInss/100;
            double valorRetiradoInss = salarioBruto * valorDecimaldoPercentual;

            return salarioBruto-valorRetiradoInss;
        }catch(RuntimeException e){
            return -1;
        }
    }
}
