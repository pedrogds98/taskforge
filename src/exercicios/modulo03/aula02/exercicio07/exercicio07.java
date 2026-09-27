package src.exercicios.modulo03.aula02.exercicio07;

import java.util.List;
import java.util.ArrayList;

public class exercicio07 {
    void main(){
        Tarefa tarefaSimpples = new TarefaSimples("tarefinha");
        Tarefa tarefaSimples2 = new TarefaSimples("Tarefazona");

        List<Tarefa> listaTarefas = new ArrayList<>();

        listaTarefas.add(tarefaSimpples);
        listaTarefas.add(tarefaSimples2);


        for (Tarefa item : listaTarefas){
            IO.println(item.nome);

            if (item instanceof Notificar){
                IO.print(item);
            }
        }

    }
}
