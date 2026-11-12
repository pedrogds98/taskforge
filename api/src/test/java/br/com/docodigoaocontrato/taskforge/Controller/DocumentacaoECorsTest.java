package br.com.docodigoaocontrato.taskforge.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.datasource.url:jdbc:h2:mem:test")
@AutoConfigureMockMvc
public class DocumentacaoECorsTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void DocumentacaoDeveSerPublica() throws Exception {
        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.info.title").value("TaskForge API"));
    }

    @Test
    void documentaçaoDeveSerPublicaPorta5173() throws Exception {
        mockMvc.perform(options("/tarefas")
                        .header("Origin", "http://localhost:5173")
                        .header("Access-Control-Request-Method", "GET"));
    }
}
