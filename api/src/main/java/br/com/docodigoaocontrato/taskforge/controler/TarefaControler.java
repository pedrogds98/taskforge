package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.dto.Tarefa2DTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefaControler {

    @GetMapping ("/tarefas")
    public TarefaDTO listar(){
        return (new TarefaDTO(10, "Tarefa1", 1, true));
    }

    @GetMapping ("/tarefastotal")
    public String tarefas(){
        return "Você tem 5 tarefas";
    }


    @GetMapping("/tarefas/exemplo")
    public Tarefa2DTO tarefasExemplo(){
        return (new Tarefa2DTO(3, "Estudar Java", 1, false));
    }
}
