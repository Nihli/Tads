/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import entity.Igreja;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lia
 */
public class IODadosXML {
        static class DadosInternos implements Serializable {
        List<Igreja> igrejas = null;
    }

    public static void salvar(String filename, GerenciadorDados dados) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("DadosInternos", DadosInternos.class);
        xstream.alias("Igreja", Igreja.class);
        //xstream.alias("List", ArrayList.class);
        java.io.PrintWriter out = null;
        try {
            out = new java.io.PrintWriter(filename);
            DadosInternos salvos = new DadosInternos();
            salvos.igrejas = dados.getIgrejaList();
            xstream.toXML(salvos, out);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            out.close();
        }
    }

    public static void carregar(String dadosxml, GerenciadorDados dados) {
        FileReader in = null;
        try {
            in = new java.io.FileReader(dadosxml);
            XStream xstream = new XStream(new StaxDriver());
            xstream.alias("DadosInternos", DadosInternos.class);
            xstream.alias("Igreja", Igreja.class);
            DadosInternos aux = (DadosInternos) xstream.fromXML(in);
            dados.getIgrejaList().clear();
            dados.getIgrejaList().addAll(aux.igrejas);
        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
        }

    }
}
