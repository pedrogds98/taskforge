package br.com.docodigoaocontrato.taskforge.Controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:testes")
@AutoConfigureMockMvc
public class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;  // SIMULA um POSTMAN

    @Test
    void deveRetornarStatus401QuandoNaoTemToken() throws Exception {
        mockMvc.perform(get("/tarefas"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deveRetornar400DetalhandoOCampoQuandoForInvalidoNoCadastro() throws Exception {
        String token = login();

        mockMvc.perform(post("/tarefas")
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "nome": "",
                                    "prioridade": 5,
                                    "concluida": false
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.campos.nome").value("O nome é obrigatório"));
    }

    @Test
    void deveRetornar201QuandoUsuarioCriadoComSucesso() throws Exception {
        String usuario = """
                {
                    "nome": "TesteUsuario",
                    "email": "testeUsuario@teste.com",
                    "senha": "teste123"
                }
                """;
        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuario)).andExpect(status().isCreated());
    }


    private String login() throws Exception {
        String usuarioCadastroDTO = """
                {
                    "nome": "Teste",
                    "email": "teste@teste.com",
                    "senha": "teste123"
                }
                """;

        String loginDTO = """
                {
                    "email": "teste@teste.com",
                    "senha": "teste123"
                }
                """;
        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioCadastroDTO));

        String resposta = mockMvc.perform(post("/usuarios/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginDTO))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        return "Bearer " + JsonPath.read(resposta, "$.token");
    }

    @Test
    void deveDevolver400QuandoJsonQuebrado() throws Exception {
        String token = login();

        String tarefa = """
                {
                    "nome" : "x",                  
                }
                """;

        mockMvc.perform(post("/tarefas")
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tarefa))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deveExecutarCaminhoCompletoDaTarefa() throws Exception {
        String token = login();

        String tarefa = """
                {
                
                "nome" : "Estudar",
                "prioridade" : 3,
                "concluida" : false
                
                }
                """;
        mockMvc.perform(post("/tarefas")
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tarefa))
                .andExpect(status().isCreated());

        String resposta = mockMvc.perform(post("/tarefas")
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tarefa))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Integer id = JsonPath.read(resposta, "$.id");

        mockMvc.perform(get("/tarefas/{id}", id)
                        .header("Authorization", token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Estudar"));


        mockMvc.perform(delete("/tarefas/{id}", id)
                        .header("Authorization", token))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/tarefas{id}", id)
                        .header("Authorization", token))
                .andExpect(status().isNotFound());
    }
}
