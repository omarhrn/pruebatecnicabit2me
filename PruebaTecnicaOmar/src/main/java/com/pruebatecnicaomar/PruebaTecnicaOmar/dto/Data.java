package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
@lombok.Data
public class Data{
    @JsonProperty("ADA") 
    public ADA aDA;
    @JsonProperty("BTC") 
    public BTC bTC;
    @JsonProperty("LRC") 
    public LRC lRC;
}