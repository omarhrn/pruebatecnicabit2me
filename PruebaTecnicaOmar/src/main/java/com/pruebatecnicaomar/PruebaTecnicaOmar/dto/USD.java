package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import java.util.Date;

@lombok.Data
public class USD{
    public double price;
    public double volume_24h;
    public double percent_change_1h;
    public double percent_change_24h;
    public double percent_change_7d;
    public double market_cap;
    public Date last_updated;
}
