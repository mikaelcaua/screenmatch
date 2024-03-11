package com.br.screenmatch.model;

import java.time.LocalDate;
import java.util.Date;

public class Episodio {
    private String titulo;
    private Integer numero;
    private LocalDate data;
    private Double avaliacao;
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
            this.avaliacao = Double.parseDouble(dados.avaliacao());
        }
        catch (Exception e){
            this.avaliacao = 0.0;
        }

    }

    public LocalDate getData() {
        return data;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTemporada() {
        return temporada;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getAvaliacao() {
        return avaliacao;
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
