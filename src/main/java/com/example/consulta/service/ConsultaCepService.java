package com.example.consulta.service;

import com.example.consulta.dto.ResultConsultaDTO;
import com.example.consulta.dto.TarifaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@Slf4j
public class ConsultaCepService {

    public TarifaDTO consultaCep(String cep) {
        String uri = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        ResultConsultaDTO result = restTemplate.getForObject(uri,ResultConsultaDTO.class);
        TarifaDTO tarifaDTO = new TarifaDTO();
        tarifaDTO.setCep(result.getCep());
        tarifaDTO.setBairro(result.getBairro());
        tarifaDTO.setEstado(result.getUf());
        tarifaDTO.setCidade(result.getLocalidade());
        tarifaDTO.setRua(result.getLogradouro());
        tarifaDTO.setComplemento(result.getComplemento());
        //pega o numero do ibge e o primeiro digito é a região, consultando na api do IBGE
        switch (result.getIbge().substring(0,1)) {
            case "1":
                tarifaDTO.setFrete(BigDecimal.valueOf(Double.valueOf(20.83)));
                break;
            case "2":
                tarifaDTO.setFrete(BigDecimal.valueOf(Double.valueOf(15.98)));
                break;
            case "3":
                tarifaDTO.setFrete(BigDecimal.valueOf(Double.valueOf(7.85)));
                break;
            case "4":
                tarifaDTO.setFrete(BigDecimal.valueOf(Double.valueOf(17.30)));
                break;
            case "5":
                tarifaDTO.setFrete(BigDecimal.valueOf(Double.valueOf(12.50)));
                break;
        }
        return tarifaDTO;
    }
}
