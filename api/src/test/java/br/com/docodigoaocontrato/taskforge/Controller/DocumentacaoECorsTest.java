package br.com.docodigoaocontrato.taskforge.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.datasource.url:jdbc:h2:file:./data/taskforge:test")
@AutoConfigureMockMvc
public class DocumentacaoECorsTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void DocumentacaoDeveSerPublica() throws Exception{
        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk());

    }
}
