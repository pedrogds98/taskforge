package br.com.docodigoaocontrato.taskforge.exception;

public class TarefaNaoEncontrada extends RuntimeException{
    private Long id;

    public TarefaNaoEncontrada(Long id){
        super("Tarefa" + id + "não encontrada");
    }
}
