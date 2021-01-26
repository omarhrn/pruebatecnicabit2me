package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import java.util.Date;

@lombok.Data
public class Status{
    public Date timestamp;
    public int error_code;
    public Object error_message;
    public int elapsed;
    public int credit_count;
    public Object notice;
}