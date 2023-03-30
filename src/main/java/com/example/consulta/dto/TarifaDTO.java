package com.example.consulta.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class TarifaDTO {
    public String cep;
    public String rua;
    public String complemento;
    public String bairro;
    public String cidade;
    public String estado;
    public BigDecimal frete;

}
