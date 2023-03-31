package com.example.consulta;

import com.example.consulta.controller.ConsultaCepController;
import com.example.consulta.domain.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@Slf4j
public class ConsultaCepControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private ConsultaCepController consultaCepController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.consultaCepController = new ConsultaCepController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(consultaCepController).build();
    }

    @Test
    public void consultaEnderecoTest() throws Exception {
        this.mockMvc.perform(post("/v1/consulta-endereco")
                        .content("{\n" +
                                "    \"cep\":\"81720-240\"\n" +
                                "}"))
                .andExpect(status().is4xxClientError());
    }
}