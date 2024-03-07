package com.br.screenmatch.service;

public interface IConverterDados {
    <T> T obterDadosConvertidos(String json, Class<T> classe);
}
