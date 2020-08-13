/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex05triangulopascal;

/**
 *
 * @author Lia Alflen
 */
public class Ex05TrianguloPascal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] n = new int[6];
        int linha=1;
        int numerosImpressosLinha = 0;
        int aux = 0;
        
        for (int i=1;i<22;i++){
            if (linha==numerosImpressosLinha){
                System.out.print("\n");
                numerosImpressosLinha=0;
                linha++;
            }
            
            if (numerosImpressosLinha==0||numerosImpressosLinha+1==linha){
                System.out.print("1 ");
                numerosImpressosLinha++;
                n[numerosImpressosLinha-1]=1;

            }else {
                int valor = n[numerosImpressosLinha-1]+n[numerosImpressosLinha];
                System.out.print(valor+" ");
                numerosImpressosLinha++;
                if(linha<=3){
                    n[numerosImpressosLinha-1]=valor;
                }else{
                    if (numerosImpressosLinha>2){
                        n[numerosImpressosLinha-2]=aux;
                    }
                    aux=valor;
                    if (numerosImpressosLinha+1==linha){
                        n[numerosImpressosLinha-1]=aux;
                    }
                }
            }
        }
    }
    
}
