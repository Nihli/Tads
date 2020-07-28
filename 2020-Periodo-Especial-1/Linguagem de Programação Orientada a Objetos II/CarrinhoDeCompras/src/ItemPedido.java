/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
public class ItemPedido {
    private String nome;
    private double preco;
    private int quantidade;
    
    public ItemPedido(String nome, double preco, int quantidade) {
        try{
            setNome(nome);
            setPreco(preco);
            setQuantidade(quantidade);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    void setNome(String nome) {
        try{
            if (nome.isEmpty()){
                throw new RuntimeException("Nome não pode ser vazio.");
            }else{
                this.nome = nome;
            }
        }catch(NullPointerException e){
            throw new RuntimeException("Nome não pode ser nulo.");
        }
    }

    void setPreco(double preco) {
        if (preco<0){
            throw new RuntimeException("Preco não pode ser negativo.");
        }else{
            this.preco = preco; 
        }
    }

    void setQuantidade(int quantidade) {
        if (quantidade<=0){
            throw new RuntimeException("Quantidade não pode ser zero ou negativa.");
        }else{
            this.quantidade = quantidade;
        }
        
    }
    
}
