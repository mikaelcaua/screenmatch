package com.br.screenmatch.model;

import java.time.LocalDate;
import java.util.Date;

public class Episodio {
    private String titulo;
    private Integer numero;
    private LocalDate data;
    private Float avaliacao;
    private int temporada;
    public Episodio(Integer temporada, DadosEpisodio dados){
        this.temporada = temporada;
        this.titulo = dados.titulo();
        this.numero = Integer.parseInt(dados.numero());

        try{
            this.data = LocalDate.parse(dados.data());
        }
        catch (Exception e){
            this.data = null;
        }

        try{
            this.avaliacao = Float.parseFloat(dados.avaliacao());
        }
        catch (Exception e){
            this.avaliacao = 0f;
        }

    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "titulo='" + titulo + '\'' +
                ", numero=" + numero +
                ", data=" + data +
                ", avaliacao='" + avaliacao + '\'' +
                ", temporada=" + temporada +
                '}';
    }
}
