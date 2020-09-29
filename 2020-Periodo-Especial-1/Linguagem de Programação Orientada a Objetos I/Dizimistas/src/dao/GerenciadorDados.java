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

    public void setDizimistaIgreja(Igreja igreja, Dizimista dizimista) {
        int index = igrejaList.indexOf(igreja);
        igrejaList.get(index).getDizimistas().add(dizimista);
        System.out.println(igreja);
    }

    public void removeDizimistaIgreja(List<Dizimista> dizimistas, Igreja igreja) {
        int index = igrejaList.indexOf(igreja);

        for (Dizimista d : dizimistas) {
            Iterator<Dizimista> iterator = igrejaList.get(index).getDizimistas().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(d)) {
                    iterator.remove();
                }
            }
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

    public void setDizimoNoDizimista(Igreja igreja, Dizimista dizimista, Dizimo dizimo) {
        int indexIgreja = igrejaList.indexOf(igreja);
        
        int indexDizimista = igrejaList.get(indexIgreja).getDizimistas().indexOf(dizimista);
        
        igrejaList.get(indexIgreja).getDizimistas().get(indexDizimista).getDizimos().add(dizimo);
        
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
