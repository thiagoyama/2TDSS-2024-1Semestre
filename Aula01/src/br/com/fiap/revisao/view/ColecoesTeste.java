package br.com.fiap.revisao.view;

import java.util.*;

public class ColecoesTeste {

    public static void main(String[] args) {
        //Instanciar uma Lista de nome de carro (String)
        List<String> carros = new ArrayList<>();

        //Adicionar três carros na lista
        carros.add("Gol");
        carros.add("Celta");
        carros.add("Uno");
        carros.add("Uno");

        //Exibir os carros da lista
        for (String item : carros){
            System.out.println(item);
        }

        //Instanciar um set de nome de banda
        Set<String> bandas = new HashSet<String>();

        //Adicionar três bandas no conjuto
        bandas.add("Metalica");
        bandas.add("Calipso");
        bandas.add("Turma do Pagode");
        bandas.add("Turma do Pagode");

        //Exibir as bandas do conjunto
        for (String item : bandas){
            System.out.println(item);
        }

        //Criar um Mapa de frutas com chaves numéricas
        Map<Integer, String> frutas = new HashMap<>();

        //Adicionar 3 frutas
        frutas.put(10, "Pera");
        frutas.put(2, "Mamão");
        frutas.put(3, "Uva");
        frutas.put(99999, "Abacaxi");
        frutas.put(9, "Abacaxi");

        System.out.println(frutas.get(2));

        //Obter todas as chaves do mapeamento
        Set<Integer> chaves = frutas.keySet(); //10, 2, 3, 99999

        //Percorrer o set de chaves para exibir a chave e a fruta
        for (Integer item : chaves){
            System.out.println(item + " - " + frutas.get(item));
        }

    }
}
