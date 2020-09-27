/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacaoalunos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lia Alflen
 */
public class AvaliacaoAlunos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            List<Avaliacao> avaliacoes = leAvaliacoes();

            List<Aluno> alunos = leNotasAlunos(avaliacoes);

            printaNotasAlunos(alunos, avaliacoes);

            calculaEPrintaValoresAvaliacoes(alunos, avaliacoes);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void calculaEPrintaValoresAvaliacoes(List<Aluno> alunos, List<Avaliacao> avaliacoes) {
        List<List<Double>> notas = new ArrayList();

        System.out.println("Nome da avaliação\tMedia\tMenor nota\tMaior nota\tMediana\tModa");

        for (int i = 0; i < avaliacoes.size(); i++) {
            double media = 0;
            double mediana = 0;

            List<Double> notaAvaliacao = new ArrayList();
            for (Aluno aluno : alunos) {
                notaAvaliacao.add(aluno.getAvaliacoes().get(i));
                media += aluno.getAvaliacoes().get(i);
            }

            Collections.sort(notaAvaliacao);

            mediana = calculaMediana(notaAvaliacao);

            avaliacoes.get(i).setMedia(media / alunos.size());
            avaliacoes.get(i).setMediana(mediana);
            avaliacoes.get(i).setModa(calculaModa(notaAvaliacao));

            System.out.print(avaliacoes.get(i).getNome() + "\t\t" + String.format("%.2f", avaliacoes.get(i).getMedia()) + "\t" + notaAvaliacao.get(0)
                    + "\t\t" + notaAvaliacao.get(notaAvaliacao.size() - 1) + "\t\t" + avaliacoes.get(i).getMediana() + "\t");

            for (Double d : avaliacoes.get(i).getModa()) {
                System.out.print(d + " ");
            }

            System.out.print("\n");
        }

    }

    private static List<Avaliacao> leAvaliacoes() {
        boolean continuaLeitura = true;
        List<Avaliacao> avaliacoes = new ArrayList();

        while (continuaLeitura) {
            System.out.println("Entre com a avaliação: ");
            Scanner s = new Scanner(System.in);
            String avaliacao = s.nextLine();

            if (avaliacao.isEmpty()) {
                continuaLeitura = false;
            } else {
                avaliacoes.add(new Avaliacao(avaliacao));
            }
        }
        return avaliacoes;
    }

    private static List<Aluno> leNotasAlunos(List<Avaliacao> avaliacoes) {
        boolean continuaLeitura = true;

        List<Aluno> alunos = new ArrayList();

        while (continuaLeitura) {
            System.out.println("Entre com o nome do aluno:");
            Scanner s = new Scanner(System.in);
            String nome = s.nextLine();

            if (nome.isEmpty()) {
                continuaLeitura = false;
            } else {
                List<Double> notas = new ArrayList();
                double somaNotas = 0;
                for (int i = 0; i < avaliacoes.size(); i++) {
                    try {
                        System.out.println("Entre com a nota " + (i + 1));
                        s = new Scanner(System.in);

                        double nota = s.nextDouble();

                        somaNotas += nota;

                        notas.add(nota);
                    } catch (InputMismatchException e) {
                        throw new RuntimeException("Você entrou com um valor não numérico.");
                    }
                }

                alunos.add(new Aluno(nome, notas, (somaNotas / avaliacoes.size())));
            }
        }

        return alunos;
    }

    private static void printaNotasAlunos(List<Aluno> alunos, List<Avaliacao> avaliacoes) {

        System.out.print("Nome\t");
        for (Avaliacao avaliacao : avaliacoes) {
            System.out.print("\t" + avaliacao.getNome());
        }
        System.out.println("\n");

        for (Aluno aluno : alunos) {
            System.out.print(aluno.getNome());

            for (Double nota : aluno.getAvaliacoes()) {
                System.out.print("\t" + nota + "\t");
            }

            System.out.println("\n");
        }
    }

    private static double calculaMediana(List<Double> notaAvaliacao) {
        double mediana = 0;

        if (notaAvaliacao.size() % 2 == 0) {
            mediana = notaAvaliacao.get(((notaAvaliacao.size() / 2) + ((notaAvaliacao.size() / 2) - 1)) / 2);
        } else {
            int valor = notaAvaliacao.size() / 2;
            mediana = notaAvaliacao.get(valor + 1);
        }
        return mediana;
    }

    private static List<Double> calculaModa(List<Double> notaAvaliacao) {
        Map<Double, Integer> qtde = new HashMap<>();

        for (Double item : notaAvaliacao) {
            if (qtde.containsKey(item)) { // se existe
                Integer n = qtde.get(item);
                qtde.put(item, n + 1); // incrementa
            } else {
                qtde.put(item, 1); // senao é 1
            }
        }

        List<Double> indices = new ArrayList();
        int qtd = -1;

        for (Map.Entry<Double, Integer> entry : qtde.entrySet()) {
            if (qtd < entry.getValue()) { //se for menor, seta nos indices o maior
                indices = new ArrayList();
                indices.add(entry.getKey());
                qtd = entry.getValue();
            } else if (qtd == entry.getValue()) { //se a qtd for igual, coloca também nos indices.
                indices.add(entry.getKey());
            }
        }
        
        return indices;
    }
}
