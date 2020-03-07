import java.util.Scanner;

public class main {
    public static void main(String[] args){
        try{
            double[] valores = receberParametros();

            if(valores == null){
                throw new RuntimeException("Por favor, entre com um valor numérico válido!");
            }

            double salarioBruto = Salario.calculaSalarioBruto(valores[0], valores[1]);
            double salarioLiquido = Salario.calculaSalarioLiquido(salarioBruto,valores[2]);

            if (salarioBruto==-1||salarioLiquido==-1){
                throw new RuntimeException("Entre com valores positivos, por favor.");
            }

            mostraResultado(valores, salarioBruto, salarioLiquido);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }

    private static double[] receberParametros(){
        try {

            double[] valores = new double[3];

            System.out.println("Bem-vindo ao programa para calcular salario bruto e liquido!");
            System.out.println("Entre com o valor recebido por hora: ");

            Scanner s = new Scanner(System.in);
            valores[0] = Double.parseDouble(s.next()); //valorHora

            System.out.println("Entre com o total de horas trabalhadas por mês: ");

            s = new Scanner(System.in);
            valores[1] = Double.parseDouble(s.next()); //horasTrabalhadas

            System.out.println("Entre com o percentual do INSS: ");

            s = new Scanner(System.in);
            valores[2] = Double.parseDouble(s.next()); //percentualInss

            return valores;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static void mostraResultado(double[] valores, double salarioBruto, double salarioLiquido){
        System.out.println("Extrato de salário");
        System.out.println("Valor Hora: R$ " + String.valueOf(valores[0]).replace(".",","));
        System.out.println("Horas trabalhadas: " + (int) valores[1] + " horas");
        System.out.println("Salário Bruto: R$ " + String.valueOf(salarioBruto).replace(".",","));
        System.out.println("Salário Líquido: R$ " + String.valueOf(salarioLiquido).replace(".",","));
    }
}
