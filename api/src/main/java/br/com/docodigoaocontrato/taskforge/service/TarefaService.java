package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.Repository.TarefaRepository;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private static TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public boolean deletartarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            return false;
        }
        tarefaRepository.deleteById(id);
        return true;
    }

    public List<TarefaDTO> buscarTodos() {
        return tarefaRepository.findAll()
                .stream()
                .map(tarefa -> toDto(tarefa))
                .toList();
    }

    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = toEntity(tarefaDTO);
        return toDto(tarefaRepository.save(tarefa));
    }

    public Optional buscarTarefa(Long id) {
        return tarefaRepository.findById(id)
                .map(Tarefa -> toDto(Tarefa));
    }

    public Optional<TarefaDTO> atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        Optional<Tarefa> tarefaRecuperada = tarefaRepository.findById(id);
        if (tarefaRecuperada.isPresent()) {
            Tarefa tarefa = tarefaRecuperada.get();
            tarefa.setNome(tarefaDTO.getNome());
            tarefa.setConcluida(tarefaDTO.isConcluida());
            tarefa.setPrioridade(tarefaDTO.getPrioridade());
            return Optional.of(toDto(tarefaRepository.save(tarefa)));
        }
        return Optional.empty();
    }

//    public List<TarefaDTO> buscarTodos(boolean concluidas) {
//        return
//    }

    private TarefaDTO toDto(Tarefa tarefa) {
        TarefaDTO dto = new TarefaDTO();
        dto.setId(tarefa.getId());
        dto.setNome(tarefa.getNome());
        dto.setPrioridade(tarefa.getPrioridade());
        dto.setConcluida(tarefa.isConcluida());

        return new TarefaDTO(tarefa.getId(), tarefa.getNome(), tarefa.getPrioridade(),
                tarefa.isConcluida());
    }

    private Tarefa toEntity(TarefaDTO tarefaDTO) {
        return new Tarefa((tarefaDTO.getNome()), tarefaDTO.getPrioridade(), tarefaDTO.isConcluida());
    }

    public List<Tarefa> buscarPendentes() {
        return tarefaRepository.findAll()
                .stream()
                .filter(tarefa -> !tarefa.isConcluida())
                .toList();

    }
// A resposta para o exercício 6b da Aula 5.2: Só muda o filtro do buscarUrgentes, ele só retorna as prioridades 1.
//  Só é necessário abrir o metodo dentro da service para adicionar o 2 como prioridade. o resto só mater.
    public List<Tarefa> buscarUrgentes() {
        return tarefaRepository.findAll()
                .stream()
                .filter(tarefa -> !tarefa.isConcluida())
                .filter(tarefa -> tarefa.getPrioridade() == 1)
                .toList();
    }

    public Optional<TarefaDTO> buscarPorId(Long id){
        Optional<Tarefa> tarefaComId = tarefaRepository.findById(id);
        if (tarefaComId.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(toDto(tarefaComId.get()));
    }

}
