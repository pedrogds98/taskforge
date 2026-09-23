package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.dto.Tarefa2DTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TarefaControler   {

    private final TarefaService tarefaService;

    public TarefaControler(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping ("/tarefas")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO TarefaDTO){
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(TarefaDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tarefaCriada);
    }

    @GetMapping ("/tarefas")
    public List<TarefaDTO> listar(){
        return tarefaService.buscarTodos();
    }

    @GetMapping ("/tarefas/total")
    public String tarefas(){
        return "Você tem 5 tarefas";
    }

    @GetMapping("/tarefas/exemplo")
    public Tarefa2DTO tarefasExemplo(){
        return (new Tarefa2DTO(3, "Estudar Java", 1, false));
    }
}
