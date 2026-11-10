package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.Exercicios2.Tarefa2DTO;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(
        name = "Tarefas",
        description = "Gerenciamento de Tarefas"
)
public class TarefaControler {

    private final TarefaService tarefaService;

    public TarefaControler(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Operation(summary = "Criar uma tarefa")
    @PostMapping("/tarefas")
    public ResponseEntity<TarefaDTO> criarTarefa(@Valid @RequestBody TarefaDTO TarefaDTO) {
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(TarefaDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tarefaCriada);
    }

    @Operation(summary = "Listar todas as tarefas")
    @GetMapping("/tarefas")
    public List<TarefaDTO> listar() {
        return tarefaService.buscarTodos();
    }

    @Operation(summary = "quantidade de tarefas")
    @GetMapping("/tarefas/total")
    public String tarefas() {
        return "Você tem 5 tarefas";
    }


    @GetMapping("/tarefas/exemplo")
    public Tarefa2DTO tarefasExemplo() {
        return (new Tarefa2DTO(3, "Estudar Java", 1, false));
    }

    @Operation(summary = "Buscar tarefa por id")
    @GetMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        TarefaDTO tarefaDTO = tarefaService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaDTO);
    }

    @Operation(summary = "Atualizar uma tarefa")
    @PutMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaAtualizada);
    }

    @Operation(summary = "Deletar uma tarefa")
    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/tarefas/pendentes")
    public List<Tarefa> buscarPendentes() {
        return tarefaService.buscarPendentes();
    }

    @GetMapping("/tarefas/urgentes")
    public List<Tarefa> buscarUrgentes() {
        return tarefaService.buscarUrgentes();
    }
}
