/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculaarea;

import java.util.Scanner;

/**
 *
 * @author Lia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.println("Escolha a área de qual figura deseja calcular:\n1 - Retangulo;\n2 - Circunferência;\n3 - Triangulo.");
            Scanner scanner = new Scanner(System.in);
            String opt = scanner.next();
            double resultado;

            switch(opt){
                case "1":
                    System.out.println("\nEntre com o valor do lado 1:");
                    scanner = new Scanner(System.in);
                    double lado1 = scanner.nextDouble();

                    System.out.println("\nEntre com o valor do lado 2:");
                    scanner = new Scanner(System.in);
                    double lado2 = scanner.nextDouble();

                    resultado = CalculaArea.areaRetangulo(lado1, lado2);
                    System.out.println("A area é: " + resultado);
                    break;
                case "2":
                    System.out.println("\nEntre com o valor do raio:");
                    scanner = new Scanner(System.in);
                    double raio = scanner.nextDouble();


                    resultado = CalculaArea.areaCircunferencia(raio);
                    System.out.println("A area é: " + resultado);
                    break;
                case "3":
                    System.out.println("\nEntre com o valor da base:");
                    scanner = new Scanner(System.in);
                    double base = scanner.nextDouble();

                    System.out.println("\nEntre com o valor da altura:");
                    scanner = new Scanner(System.in);
                    double altura = scanner.nextDouble();


                    resultado = CalculaArea.areaTriangulo(base, altura);
                    System.out.println("A area é: " + resultado);
                    break;
                default:
                    System.out.println("Por favor, entre com um valor válido.");
            }
        }catch(Exception e){
            System.out.println("Houve um erro na execução do programa.");
            System.out.println(e.getMessage());
        }
    }
}
