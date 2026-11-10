package br.com.docodigoaocontrato.taskforge.Controller;

import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import org.antlr.v4.runtime.Token;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:testes")
@AutoConfigureMockMvc

public class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornar400QuandoEmailInvalido() throws Exception {
        String usuario = """
                {
                    "nome": "TesteUsuario",
                    "email": "abc",
                    "senha": "teste123"
                }
                """;
        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuario))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.campos.email")
                        .value("O email está inválido"));
    }
}