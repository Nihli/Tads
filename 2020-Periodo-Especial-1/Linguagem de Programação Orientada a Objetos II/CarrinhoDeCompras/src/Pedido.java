
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
public class Pedido {
    private String nomeCliente;
    private double valorTotalPermitido;
    private List<ItemPedido> itens;
    private static double VALORATUAL;

    public Pedido(double valorTotal, String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.valorTotalPermitido = valorTotal;
        this.itens = new ArrayList();
        this.VALORATUAL = 0;
    }

    double getTotal() {
        return this.valorTotalPermitido;
    }

    Object getNomeCliente() {
        return this.nomeCliente;
    }

    void acrescentaItem(ItemPedido item) {
        if (item == null) {
            throw new RuntimeException("Item do pedido não pode ser nulo.");
        }
        
        if(this.valorTotalPermitido==0.0){
            throw new RuntimeException("Cliente não tem nenhum crédito.");
        }
        
        double valorTotalItem = item.getPreco()*item.getQuantidade();
        double valorTemporarioPedido = this.VALORATUAL + valorTotalItem;
        
        System.out.println(valorTotalItem > this.valorTotalPermitido);
        System.out.println(valorTemporarioPedido>this.valorTotalPermitido);
        
        if (valorTotalItem > this.valorTotalPermitido || valorTemporarioPedido>this.valorTotalPermitido){
            throw new RuntimeException("Item de Pedido não incluído. Valor do pedido excedido.");
        }
        
        boolean foiInserido = false;
        
        for (ItemPedido i : this.itens){
            if (i.equals(item)){
                System.out.println("aaaa");
                i.setQuantidade(i.getQuantidade()+1);
                this.VALORATUAL += item.getPreco();
                foiInserido =true;
                System.out.println(this.VALORATUAL);
            }
        }
        
        if(!foiInserido){
            this.itens.add(item);
            this.VALORATUAL += valorTotalItem;
            System.out.println(this.VALORATUAL);
        }
    }

    List<ItemPedido> getItens() {
        return this.itens;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nomeCliente=" + nomeCliente + ", valorTotalPermitido=" + valorTotalPermitido + ", itens=" + itens + '}';
    }
    
    
    
}
