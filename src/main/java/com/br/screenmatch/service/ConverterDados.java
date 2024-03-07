package com.br.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterDados implements IConverterDados{
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDadosConvertidos(String json, Class<T> classe) {
        try{
            return mapper.readValue(json, classe);
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

    }
}
