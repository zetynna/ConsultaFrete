package com.example.consulta;

import com.example.consulta.controller.ConsultaCepController;
import com.example.consulta.domain.Endereco;
import com.example.consulta.service.ConsultaCepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConsultaCepControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Mock
    private ConsultaCepService consultaCepService;

    @Mock
    private ConsultaCepController consultaCepController;

    @BeforeAll
    private void init() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(consultaCepController).build();
    }
    @Test
    public void consultaEnderecoTest() throws Exception {
        Endereco endereco = new Endereco();
        endereco.setCep("81720-240");
        mockMvc.perform(post("/v1/consulta-endereco")
                .content("{\n" +
                        "    \"cep\":\"81720-240\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

}
