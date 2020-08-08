/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrinhodecompras;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lia
 */
public class SistemaPedidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Pedido> listaPedidos = new ArrayList();
        
        String opt = "0", nome;
        
        
        try{
            while(!opt.equals("7")){
                System.out.println("\nBem-vindo ao seu carrinho de compras! \nEscolha uma opção:\n");
                System.out.println("1 – Incluir Pedido");
                System.out.println("2 – Excluir pedido por nome do cliente");
                System.out.println("3 – Listar Pedidos");
                System.out.println("4 – Incluir Item de Pedido em Pedido");
                System.out.println("5 – Excluir Item de Pedido em Pedido");
                System.out.println("6 – Imprimir a lista de Pedidos");
                System.out.println("7 – Encerrar.");

                Scanner sc = new Scanner(System.in);
                opt = sc.next();
                switch(opt){
                    case "1":
                        System.out.println("Entre com o nome do cliente");
                        sc = new Scanner(System.in);
                        nome = sc.next();

                        System.out.println("Entre com o valor total permitido do pedido");
                        sc = new Scanner(System.in); 
                        double valorTotal = sc.nextDouble();

                        Pedido pedido = new Pedido(valorTotal, nome);
                        listaPedidos.add(pedido);
                        break;
                    case "2":
                        System.out.println("Entre com o nome do cliente");
                        sc = new Scanner(System.in);
                        nome = sc.next();
                        
                        for (Pedido p : listaPedidos) {
                            if(p.getNomeCliente().equals(nome)){
                                listaPedidos.remove(p);
                                break;
                            }
                        }
                        
                        break;
                    case "3":
                        System.out.println("Entre com o nome do cliente do pedido");
                        sc = new Scanner(System.in);
                        nome = sc.next();
                        
                        boolean imprimido=false;
                        
                        for (Pedido p : listaPedidos) {
                             if(p.getNomeCliente().equals(nome)){
                                System.out.println("\n" + p + "\n");
                                imprimido=true;
                                break;
                            }
                        }
                        
                        if(!imprimido){
                            System.out.println("Nome do cliente inserido não pertence a nenhum pedido.");
                        }
                        
                        break;
                    case "4":
                        System.out.println("Entre com o nome do cliente do pedido");
                        sc = new Scanner(System.in);
                        nome = sc.next();
                        
                        boolean inserido=false;
                        
                        for (Pedido p : listaPedidos) {
                             if(p.getNomeCliente().equals(nome)){
                                System.out.println("Entre com o nome do item: ");
                                sc = new Scanner(System.in);
                                String nomeItem = sc.next();
                                
                                System.out.println("Entre com o preço do item: ");
                                sc = new Scanner(System.in);
                                double precoItem = sc.nextDouble();
                                
                                System.out.println("Entre com a quantidade do item: ");
                                sc = new Scanner(System.in);
                                int qtdItem = sc.nextInt();
                                
                                ItemPedido item = new ItemPedido(nomeItem, precoItem, qtdItem);
                                
                                p.acrescentaItem(item);
                                inserido=true;
                                break;
                            }
                        }
                        
                        if(!inserido){
                            System.out.println("Nome do cliente inserido não pertence a nenhum pedido.");
                        }
                        
                        break;
                    case "5":
                        System.out.println("Entre com o nome do cliente do pedido");
                        sc = new Scanner(System.in);
                        nome = sc.next();
                        
                        boolean removido=false;
                        
                        for (Pedido p : listaPedidos) {
                             if(p.getNomeCliente().equals(nome)){
                                System.out.println("Entre com o nome do item: ");
                                sc = new Scanner(System.in);
                                String nomeItem = sc.next();
                                
                                p.retiraItem(nomeItem);
                                
                                break;
                            }
                        }
                        
                        break;
                    case "6":
                        for (Pedido p : listaPedidos) {
                            System.out.println("\n" + p + "\n");
                        }
                        
                        break;
                    case "7":
                        break;
                    default:
                        System.out.println("Por favor, entre com um valor válido.");
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Por favor, entre com um valor válido.");
        }
    }
    
}
