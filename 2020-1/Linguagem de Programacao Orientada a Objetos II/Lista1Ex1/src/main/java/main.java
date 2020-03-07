import java.util.Scanner;

public class main {
    public static void main(String[] args){
        try {

            System.out.println("Olá!");
            System.out.println("Qual a figura que você gostaria de calcular a área?");
            System.out.println("1 - Retângulo;");
            System.out.println("2 - Circunferência;");
            System.out.println("3 - Triângulo;");

            System.out.println("Digite o número da opção desejada: ");

            Scanner s = new Scanner(System.in);
            int opcao = s.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("Entre com o valor do lado 1 do retângulo: ");

                    s = new Scanner(System.in);
                    double lado1 =  Double.parseDouble(s.next());

                    System.out.println("Entre com o valor do lado 2 do retângulo: ");

                    s = new Scanner(System.in);
                    double lado2 =  Double.parseDouble(s.next());

                    System.out.println(AreaFiguras.calculaAreaRetangulo(lado1, lado2));

                    break;
                case 2:
                    System.out.println("Entre com o valor do raio da circunferência: ");

                    s = new Scanner(System.in);
                    double raio =  Double.parseDouble(s.next());

                    System.out.println(AreaFiguras.calculaAreaCircunferencia(raio));

                    break;
                case 3:
                    System.out.println("Entre com o valor da base do triângulo: ");

                    s = new Scanner(System.in);
                    double base =  Double.parseDouble(s.next());

                    System.out.println("Entre com o valor da altura do triângulo: ");

                    s = new Scanner(System.in);
                    double altura =  Double.parseDouble(s.next());

                    System.out.println(AreaFiguras.calculaAreaTriangulo(base, altura));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Por favor, entre com um valor numérico válido!");
        }
    }
}
