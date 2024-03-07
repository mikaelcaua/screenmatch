package com.br.screenmatch;

import com.br.screenmatch.main.Main;
import com.br.screenmatch.model.DadosEpisodio;
import com.br.screenmatch.model.DadosSerie;
import com.br.screenmatch.model.DadosTemporada;
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
		Main main = new Main();
		main.exibeMenu();
	}
}
