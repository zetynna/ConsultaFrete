package com.example.consulta.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class Endereco {
    @NotEmpty
    public String cep;

}
