package src.exercicios.modulo03.aula02.Desafio;

public class TarefaComPrazo extends Tarefa implements Notificavel{


    public TarefaComPrazo( String nome, String descricao, String responsavel,
                          double horas, String status){
        super(nome, descricao, responsavel, horas, status);
    }

    @Override
    public String tipo() {
        return "Tarefa com Prazo";
    }

    @Override
    public String lembrete() {
        return "Prazo de x dias";
    }
}


