package carrinhodecompras;


import carrinhodecompras.ItemPedido;
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
    private double valorAtual;

    public Pedido(double valorTotal, String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.valorTotalPermitido = valorTotal;
        this.itens = new ArrayList();
        this.valorAtual = 0;
    }

    public double getTotal() {
        return this.valorAtual;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void acrescentaItem(ItemPedido item) {
        if (item == null) {
            throw new RuntimeException("Item do pedido não pode ser nulo.");
        }
        
        if(this.valorTotalPermitido==0.0){
            throw new RuntimeException("Cliente não tem nenhum crédito.");
        }
        
        double valorTotalItem = item.getPreco()*item.getQuantidade();
        double valorTemporarioPedido = this.valorAtual + valorTotalItem;
        
        if (valorTotalItem > this.valorTotalPermitido || valorTemporarioPedido>this.valorTotalPermitido){
            throw new RuntimeException("Item de Pedido não incluído. Valor do pedido excedido.");
        }
        
        boolean foiInserido = false;
        
        for (ItemPedido i : this.itens){
            if (i.equals(item)){
                i.setQuantidade(i.getQuantidade()+1);
                this.valorAtual += item.getPreco();
                foiInserido =true;
                break;
            }
        }
        
        if(!foiInserido){
            this.itens.add(item);
            this.valorAtual += valorTotalItem;
        }
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }

    public void retiraItem(String nome) {
        boolean foiRetirado = false;
        
        for (ItemPedido i : this.itens){
            if (i.getNome().equals(nome)){
                if (i.getQuantidade()-1!=0){
                    i.setQuantidade(i.getQuantidade()-1);
                    this.valorAtual -= i.getPreco();
                    foiRetirado =true;
                    break;
                }else{
                    this.itens.remove(i);
                    this.valorAtual -= i.getPreco();
                    foiRetirado =true;
                    break;
                }
            }
        }
        
        if(!foiRetirado){
            throw new RuntimeException("Item não encontrado no pedido.");
        }
    }
    
        @Override
    public String toString() {
        String listaItens = "";
        
         for(ItemPedido i: itens){
             listaItens = listaItens + i.getNome() + "  |R$" + String.valueOf(i.getPreco()*i.getQuantidade()).replace(".",",") + "\n";
        }
        
        return "-----------------------------------\n" +
                "Nome do Cliente: " + nomeCliente + "\n" +
                "Total do Pedido: R$" + String.valueOf(valorAtual).replace(".",",") + "\n" +
                "Item    |Preço\n" +
                listaItens +
                "\n-----------------------------------";
    }
}
