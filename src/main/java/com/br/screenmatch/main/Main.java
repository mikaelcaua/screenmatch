package com.br.screenmatch.main;
import com.br.screenmatch.model.DadosEpisodio;
import com.br.screenmatch.model.DadosSerie;
import com.br.screenmatch.model.DadosTemporada;
import com.br.screenmatch.service.ConsumoApi;
import com.br.screenmatch.service.ConverterDados;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private Scanner scanner = new Scanner(System.in);
    private String URL = "https://www.omdbapi.com/?t=";
    private String API_KEY="&apikey=6585022c";
    private ConsumoApi consumo = new ConsumoApi();
        private ConverterDados conversor = new ConverterDados();
    private ArrayList<DadosTemporada> temporadas = new ArrayList<>();

    public void exibeMenu() {
        System.out.println("Digite a série que vocÊ deseja buscar os dados:");
        String nomeSerie = scanner.nextLine();
        String endereco = URL + nomeSerie.toLowerCase().replace(" ","+")+API_KEY;

        String json = consumo.obterDados(endereco);
        var dadosSerie = conversor.obterDadosConvertidos(json, DadosSerie.class);

        for (int i = 1; i <= Integer.parseInt(dadosSerie.totalTemporadas());i++) {
            json = consumo.obterDados(URL + nomeSerie.toLowerCase().replace(" ","+")+"&season=" + i + API_KEY);
            var dadoTemporada = conversor.obterDadosConvertidos(json, DadosTemporada.class);
            temporadas.add(dadoTemporada);
        }

        temporadas.forEach(System.out::println);
//        temporadas.forEach(temporada -> {
//            System.out.println(temporada);
//        });
    }
}
