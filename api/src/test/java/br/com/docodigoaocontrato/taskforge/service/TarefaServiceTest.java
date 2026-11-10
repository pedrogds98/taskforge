package br.com.docodigoaocontrato.taskforge.service;
import br.com.docodigoaocontrato.taskforge.Repository.TarefaRepository;
import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.exception.TarefaNaoEncontrada;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    void deveDevolverUmaTarefaQuandoOIdExiste() {
        // DADO que o banco "tem" a tarefa 1
        Tarefa tarefa = new Tarefa(10L, "estudar Java", 1, true);
        when(tarefaRepository.findById(10L)).thenReturn(Optional.of(tarefa));

        // QUANDO eu busco a tarefa
        TarefaDTO tarefaEncontrada = tarefaService.buscarPorId(10L);


        // ENTAO a tarefa é recuperada e convertida em DTO
        assertTrue(tarefaEncontrada.isPresent());
    }

    @Test
    void deveDevolverVazioQuandoOIdNaoExiste() {
        // DADO que o banco nao "tem" a tarefa 99
        when(tarefaRepository.findById(99L)).thenReturn(Optional.empty());

        // QUANDO eu busco a tarefa 99

        // ENTAO nao vem nenhum resultado
        assertThrows(
                TarefaNaoEncontrada.class, () -> tarefaService.buscarPorId(99L));
    }


    @Test
    void DeveApagarQuandoATarefaExiste() {
        // DADO que o banco "tem" a tarefa 1
        Tarefa tarefatest = new Tarefa();
        tarefatest.setId(1L);
        when (tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefatest));

        // QUANDO eu tento apagar
        tarefaService.deletarTarefa(1L);

        // ENTAO a service retorna false
        verify(tarefaRepository).deleteById(1L);
    }
}
