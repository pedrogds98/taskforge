package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.dto.Tarefa2DTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> buscarTarefa(@PathVariable Long id){
        Optional<TarefaDTO> tarefaDTO = tarefaService.buscarTarefa(id);
        if(tarefaDTO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(tarefaDTO.get());
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        Optional<TarefaDTO> tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        if (tarefaAtualizada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(tarefaAtualizada.get());
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> deletarTarefa (@PathVariable Long id) {
        if (!tarefaService.deletartarefa(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/tarefas/pendentes")
    public List<Tarefa> buscarPendentes(){
        return tarefaService.buscarPendentes();
    }

    @GetMapping("/tarefas/urgentes")
    public List<Tarefa> buscarUrgentes(){
        return tarefaService.buscarUrgentes();
    }
}
