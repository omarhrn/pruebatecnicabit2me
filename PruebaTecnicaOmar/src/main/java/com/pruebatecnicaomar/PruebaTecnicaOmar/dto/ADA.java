package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import java.util.Date;
import java.util.List;
@lombok.Data
public class ADA{
    public int id;
    public String name;
    public String symbol;
    public String slug;
    public int num_market_pairs;
    public Date date_added;
    public List<String> tags;
    public long max_supply;
    public long circulating_supply;
    public long total_supply;
    public int is_active;
    public Object platform;
    public int cmc_rank;
    public int is_fiat;
    public Date last_updated;
    public Quote quote;
}