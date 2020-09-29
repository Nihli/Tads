/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Dizimista;
import entity.Dizimo;
import entity.Igreja;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lia
 */
public class GerenciadorDados {

    private static GerenciadorDados INSTANCE = null;

    private GerenciadorDados() {
    }

    public static GerenciadorDados getInstance() {
        if (INSTANCE == null) {
            synchronized (GerenciadorDados.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GerenciadorDados();
                }
            }
        }
        return INSTANCE;
    }

    private List<Igreja> igrejaList = null;

    public List<Igreja> getIgrejaList() {
        if (igrejaList == null) {
            igrejaList = new ArrayList();
        }
        return igrejaList;
    }

    public boolean setDizimistaIgreja(Igreja igreja, Dizimista dizimista) {
        List<Igreja> igrejas = new ArrayList();
        
//        for (Igreja i: igrejaList){
//            if (i.getDizimistas().contains(dizimista)){
//                if (i.equals(igreja)){     
//                    return false;
//                }else{
//                   igrejas.add(i);
////                   int indexDiz = i.getDizimistas().indexOf(dizimista);
////                   i.getDizimistas().get(indexDiz).getIgrejas().add(igreja);
//                }
//            }
//        }
//        
        int index = igrejaList.indexOf(igreja);
        
        igrejas.add(igreja);
        
        dizimista.setIgrejas(igrejas);
        
        igrejaList.get(index).getDizimistas().add(dizimista);
        return true;
    }

    public void removeDizimistaIgreja(List<Dizimista> dizimistas, Igreja igreja) {
        int index = igrejaList.indexOf(igreja);

        for (Dizimista dizimistaExcluir : dizimistas) {
            Iterator<Dizimista> iterator = igrejaList.get(index).getDizimistas().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(dizimistaExcluir)) {
                    dizimistaExcluir.setDizimos(null);
                    iterator.remove();
                }
            }
            
            for(Dizimista dizimistaListagem : igrejaList.get(index).getDizimistas()){
                if (dizimistaListagem.getEntregadorDizimo()!=null&&dizimistaListagem.getEntregadorDizimo().equals(dizimistaExcluir)){
                    dizimistaListagem.setEntregadorDizimo(null);
                }
            }
         
//            if (dizimistaExcluir.getIgrejas().size()>1){
//                for (Igreja i: igrejaList){
//                    if (i.getDizimistas().contains(dizimistaExcluir)){
//                   
//                   int indexDiz = i.getDizimistas().indexOf(dizimistaExcluir);
//                   int indexIgr = i.getDizimistas().get(indexDiz).getIgrejas().indexOf(igreja);
//                   i.getDizimistas().get(indexDiz).getIgrejas().remove(indexIgr);
//                    }
//                }
//            }
        }
    }

    public void atualizaDizimista(Dizimista dizimista, Igreja igreja) {
        int index = igrejaList.indexOf(igreja);

        for (Dizimista d :igrejaList.get(index).getDizimistas()) {
            if (d.equals(dizimista)){
                d.setNome(dizimista.getNome());
                d.setEndereco(dizimista.getEndereco());
                d.setCPF(dizimista.getCPF());
                d.setEntregadorDizimo(dizimista.getEntregadorDizimo());
                d.setDizimos(dizimista.getDizimos());
                break;
            }
        }
    }

    public boolean setDizimoNoDizimista(Igreja igreja, Dizimista dizimista, Dizimo dizimo) {
        int indexIgreja = igrejaList.indexOf(igreja);
        
        int indexDizimista = igrejaList.get(indexIgreja).getDizimistas().indexOf(dizimista);
        
        if (igrejaList.get(indexIgreja).getDizimistas().get(indexDizimista).getDizimos().contains(dizimo)){
            return false;
        }
        
        igrejaList.get(indexIgreja).getDizimistas().get(indexDizimista).getDizimos().add(dizimo);
        return true;
        
    }

    public void removeDizimo(Igreja igreja, Dizimista dizimista, List<Dizimo> listaParaExcluir) {
        int indexIgreja = igrejaList.indexOf(igreja);
        
        int indexDizimista = igrejaList.get(indexIgreja).getDizimistas().indexOf(dizimista);
        
        for (Dizimo d : listaParaExcluir) {
            Iterator<Dizimo> iterator = igrejaList.get(indexIgreja).getDizimistas().get(indexDizimista).getDizimos().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(d)) {
                    iterator.remove();
                }
            }
        }
        
    }

    public List<Dizimo> getDizimos(Igreja igreja, Dizimista dizimista) {
        int indexIgreja = igrejaList.indexOf(igreja);
        
        int indexDizimista = igrejaList.get(indexIgreja).getDizimistas().indexOf(dizimista);
        
        return igrejaList.get(indexIgreja).getDizimistas().get(indexDizimista).getDizimos();
    }


}
