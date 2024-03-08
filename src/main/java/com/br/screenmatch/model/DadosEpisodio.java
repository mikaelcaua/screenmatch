package com.br.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(
    @JsonAlias("Title") String titulo,
    @JsonAlias("Episode") String numero,
    @JsonAlias("Released") String data,
    @JsonAlias("imdbRating") String avaliacao) {
}
