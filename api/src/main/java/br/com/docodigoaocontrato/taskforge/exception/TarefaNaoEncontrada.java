package br.com.docodigoaocontrato.taskforge.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaNaoEncontrada extends RuntimeException{
    private Long id;

    public TarefaNaoEncontrada(Long id){
        super("Tarefa" + id + "não encontrada");
    }
}
