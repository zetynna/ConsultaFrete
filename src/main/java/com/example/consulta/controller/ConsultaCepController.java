package com.example.consulta.controller;

import com.example.consulta.dto.TarifaDTO;
import com.example.consulta.service.ConsultaCepService;
import com.example.consulta.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class ConsultaCepController {

    @Autowired
    public ConsultaCepService consultaCepService;

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public TarifaDTO consultaCep(@RequestBody @Valid Endereco endereco){
        var responseJson = consultaCepService.consultaCep(endereco.getCep().replaceAll("\\p{Punct}",""));
        return responseJson;

    }
}
