/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasgeometricas;

import java.util.Scanner;

/**
 *
 * @author Lia
 */
public class UsaFormas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bem-vindo! Quantas formas geométricas gostaria de criar?");
        Scanner scanner = new Scanner(System.in);
        
        int qtdFormas = scanner.nextInt();
        FormaGeometrica[] f = new FormaGeometrica[qtdFormas];
        boolean exit = false;
        
        for (int i=0;i<qtdFormas;i++){
            System.out.println("Entre com o tipo da forma geométrica " + i + ":\n");
            System.out.println("1 - Retangulo;\n2 - Circunferência;\n3 - Triangulo.\n");
            System.out.println("Caso queira sair, entre com -1.");
            scanner = new Scanner(System.in);
            
            String opt = scanner.next();

            switch(opt){
                case "1":
                    System.out.println("\nEntre com o valor do lado 1:");
                    scanner = new Scanner(System.in);
                    double lado1 = scanner.nextDouble();

                    System.out.println("\nEntre com o valor do lado 2:");
                    scanner = new Scanner(System.in);
                    double lado2 = scanner.nextDouble();

                    f[i] = new Retangulo(lado1, lado2);
                    break;
                case "2":
                    System.out.println("\nEntre com o valor do raio:");
                    scanner = new Scanner(System.in);
                    double raio = scanner.nextDouble();

                    f[i] = new Circunferencia(raio);
                    break;
                case "3":
                    System.out.println("\nEntre com o valor da base:");
                    scanner = new Scanner(System.in);
                    double base = scanner.nextDouble();

                    System.out.println("\nEntre com o valor da altura:");
                    scanner = new Scanner(System.in);
                    double altura = scanner.nextDouble();

                    f[i] = new Triangulo(base,altura);
                    break;
                case "-1":
                    exit=true;
                    break;
                default:
                    System.out.println("Por favor, entre com um valor válido.");
            }
            if (exit==true){
                break;
            }
        }
        
        for(int j=0;j<f.length;j++){
            System.out.println("Área da figura " + j + ": " + f[j].area());
        }
        
    }
    
}