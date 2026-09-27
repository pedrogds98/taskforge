//package src.exercicios.modulo03.aula01.desafio;
//
//import src.Tarefa;
//import src.TarefaStatus;
//
//import java.util.List;
//import java.util.ArrayList;
//
//
//class exercicio09 {
////    public Desafio(String nome, String descricao, int prioridade, String responsavel,
////                                     double horasEstimadas, TarefaStatus status) {
////    super(nome, descricao, prioridade, responsavel, horasEstimadas, status);
//
//    void main() {
//        Tarefa tarefa1 = new Tarefa("Doida", "estuda", 2, "eu", 5.5,
//                TarefaStatus.PENDENTE);
//        Tarefa tarefa2 = new Tarefa("Estudar python", "virar dev", 1, "eu",
//                4, TarefaStatus.PENDENTE);
//        Tarefa tarefa3 = new Tarefa("exercicio Lander", "complicado", 2, "Lander",
//                1, TarefaStatus.EM_ANDAMENTO);
//        Tarefa tarefa4 = new Tarefa("exercicios", "facíl", 3, "eu mesmo",
//                10, TarefaStatus.CONCLUIDA);
//
//        List<Tarefa> tarefas = new ArrayList<>();
//        List<Tarefa> tarefasConcluidas = new ArrayList<>();
//
//
//        tarefas.add(tarefa1);
//        tarefas.add(tarefa2);
//        tarefas.add(tarefa3);
//        tarefas.add(tarefa4);
//
//        IO.println("Total de tarefas: " + tarefas.size());
//
//        for (Tarefa item : tarefas) {
//            if (item.getStatus() == TarefaStatus.CONCLUIDA) {
//                tarefasConcluidas.add(item);
//            }
//        }
//
//        IO.println("Concluídas encontradas: " + tarefasConcluidas.size());
//
//
//        tarefas.removeAll(tarefasConcluidas);
//
//        IO.println("Sobraram: " + tarefas.size());
//
//        for (Tarefa item : tarefas) {
//            item.resumo();
//        }
//    }
//}
//
//
