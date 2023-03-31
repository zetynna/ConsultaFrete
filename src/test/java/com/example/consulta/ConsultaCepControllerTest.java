package com.example.consulta;

import com.example.consulta.controller.ConsultaCepController;
import com.example.consulta.domain.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ConsultaCepControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ConsultaCepController consultaCepController;



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.consultaCepController = new ConsultaCepController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(consultaCepController).build();
    }

    @Test
    public void consultaEnderecoTest() throws Exception {
        Endereco endereco = new Endereco();
        endereco.setCep("81720-240");
        log.info(asJsonString(endereco));
        this.mockMvc.perform(post("/v1/consulta-endereco")
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"cep\":\"81720-240\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
