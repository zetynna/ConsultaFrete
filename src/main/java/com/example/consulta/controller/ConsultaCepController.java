package com.example.consulta.controller;

import com.example.consulta.domain.Endereco;
import com.example.consulta.dto.TarifaDTO;
import com.example.consulta.service.ConsultaCepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.http.HttpResponse;

@RestController
@Slf4j
@RequestMapping("/v1/consulta-endereco")
public class ConsultaCepController {

    @Autowired
    public ConsultaCepService consultaCepService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TarifaDTO consultaCep(@RequestBody @Valid Endereco endereco){
        log.info("CEP: " + endereco.getCep().replaceAll("\\p{Punct}",""));

        var responseJson = consultaCepService.consultaCep(endereco.getCep().replaceAll("\\p{Punct}",""));
        return responseJson;

    }
}
