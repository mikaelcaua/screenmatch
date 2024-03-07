package com.br.screenmatch;

import com.br.screenmatch.model.DadosSerie;
import com.br.screenmatch.service.ConsumoApi;
import com.br.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c URL GERAL
		//https://www.omdbapi.com/?t=gilmore+girls&season=1&apikey=6585022c URL TEMPORADA ESPECIFICA

		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		var conversor = new ConverterDados();
		var dadosSerie = conversor.obterDadosConvertidos(json, DadosSerie.class);
		System.out.println(dadosSerie);


	}
}
