package com.br.screenmatch.main;
import com.br.screenmatch.model.DadosEpisodio;
import com.br.screenmatch.model.DadosSerie;
import com.br.screenmatch.model.DadosTemporada;
import com.br.screenmatch.model.Episodio;
import com.br.screenmatch.service.ConsumoApi;
import com.br.screenmatch.service.ConverterDados;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private Scanner scanner = new Scanner(System.in);
    private String URL = "https://www.omdbapi.com/?t=";
    private String API_KEY="&apikey=6585022c";
    private ConsumoApi consumo = new ConsumoApi();
        private ConverterDados conversor = new ConverterDados();

    public void exibeMenu() {
        System.out.println("Digite a série que vocÊ deseja buscar os dados:");
        String nomeSerie = scanner.nextLine();
        String endereco = URL + nomeSerie.toLowerCase().replace(" ","+")+API_KEY;

        String json = consumo.obterDados(endereco);
        var dadosSerie = conversor.obterDadosConvertidos(json, DadosSerie.class);

        ArrayList<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(dadosSerie.totalTemporadas());i++) {
            json = consumo.obterDados(URL + nomeSerie.toLowerCase().replace(" ","+")+"&season=" + i + API_KEY);
            var dadoTemporada = conversor.obterDadosConvertidos(json, DadosTemporada.class);
            temporadas.add(dadoTemporada);
        }

        List<Episodio> episodios = temporadas.stream().
                                        flatMap(t-> t.episodios().stream().
                                                    map(d -> new Episodio(t.numero(), d))).
                                                            collect(Collectors.toList());

        System.out.println("Você quer ver os episódios a partir de qual ano?");
        Integer ano = scanner.nextInt();
        episodios.stream().
                filter(e->e.getData().getYear()>=ano && e.getData()!=null)
                .forEach(System.out::println);
    }
}
