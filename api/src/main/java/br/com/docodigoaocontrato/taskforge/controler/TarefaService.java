package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.Repository.TarefaRepository;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private static TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaDTO> buscarTodos() {
        return tarefaRepository.findAll()
                .stream()
                .map(tarefa -> toDto(tarefa))
                .toList();
    }

    private TarefaDTO toDto(Tarefa tarefa) {
        TarefaDTO dto = new TarefaDTO();
        dto.setId(tarefa.getId());
        dto.setNome(tarefa.getNome());
        dto.setPrioridade(tarefa.getPrioridade());
        dto.setConcluida(tarefa.isConcluida());

        return new TarefaDTO(tarefa.getId(), tarefa.getNome(), tarefa.getPrioridade(),
                tarefa.isConcluida());
    }

    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = toEntity(tarefaDTO);
        return toDto(tarefaRepository.save(tarefa));
    }

    private Tarefa toEntity(TarefaDTO tarefaDTO) {
        return new Tarefa((tarefaDTO.getNome()), tarefaDTO.getPrioridade(), tarefaDTO.isConcluida());
    }
}
