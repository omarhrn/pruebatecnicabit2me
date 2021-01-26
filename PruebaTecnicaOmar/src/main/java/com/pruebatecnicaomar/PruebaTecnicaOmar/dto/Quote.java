package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
@lombok.Data
public class Quote{
    @JsonProperty("USD") 
    public USD uSD;
}