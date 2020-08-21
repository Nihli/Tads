/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

/**
 *
 * @author Lia
 */
public class Pilha<T> {
    private No topo = null; //o topo da pilha	
        
    public class No {
        public T elemento;
        public No prox;

        public No(T elemento){
            this.elemento = elemento;
            this.prox = null;
        }  
    }
	
    public void empilha(T elemento){
	No novo = new No(elemento);
	if(topo == null){
            topo = novo;
        }else{
            novo.prox = topo;
            topo = novo;
        }
    }
	
    public void desempilha(){
	topo = topo.prox;
    }

    @Override
    public String toString() {
        String retorno = "[ ";
        No aux = topo;
        
        while(aux.prox!=null){
            retorno +=aux.elemento+" , ";
            aux=aux.prox;
        }
        
        return retorno+aux.elemento+" ]";
    }
    
}
