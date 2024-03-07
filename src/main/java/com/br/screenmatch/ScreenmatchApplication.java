package com.br.screenmatch;

import com.br.screenmatch.model.DadosSerie;
import com.br.screenmatch.service.ConsumoApi;
import com.br.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		var conversor = new ConverterDados();
		var dadosSerie = conversor.obterDadosConvertidos(json, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
