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
}

// Respotas do exercicio 07 da aula 5.2:
//Parte A:
// 1-Controller e service
// 2- Controller
// 3- Repository
// 4- Service
// 5- Controller
// 6- Service
// 7- Serice
// 8- Service


//Parte B:
// O erro está no: "private final CategoriaRepository repository;"
// E aqui também: "return repository.findAll().stream()"

// O correto seria: "private final CategoriaRepository categoriaRepository;"
// "return categoriaRepository.findAll().stream()"


//Exercicio 08:
//A: A dependecy esta incorreta
//B:Só falta importar as classes, o próprio Intellij ajuda nisso.
//C: o @Getter precisa ser com G maiúsculo
//D: Faltou rodar a aplicação no Intellij
//E: Em aplicationProperties tem que mexer na url e trocar mem por file
//F: Não faz sentido colocar @service na camada controller.