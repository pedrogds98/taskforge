package src.exercicios.modulo03.aula02.Desafio;


import java.util.ArrayList;
import java.util.List;

public class Desafio {
    void main(){
        Tarefa tarefaSimples = new TarefaSimples("Estudar Java",
                "Estudar o dia todo", "eu", 5, "FAzendo");
        Tarefa tarefaComPrazo = new TarefaComPrazo("Estudar Java e python",
                "Estudar sempre", "ele", 1, "FAzendo");
        Tarefa tarefaRecorrente1 = new TarefaRecorrente("Estudar Java de manha",
                "Estudar o dia todo", "todos", 7,
                "Feito", 10);

        List<Tarefa> ListaTarefas = new ArrayList<>();

        ListaTarefas.add(tarefaRecorrente1);
        ListaTarefas.add(tarefaComPrazo);
        ListaTarefas.add(tarefaSimples);


        for (Tarefa item : ListaTarefas){
            IO.println(item.resumo());
            if (item instanceof Notificavel) {
                IO.print(((Notificavel) item).lembrete());

            }
        }
    }

}
