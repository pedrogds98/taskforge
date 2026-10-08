package src.exercicios.modulo03.aula02.exercicio07;

public class TarefaComPrazos extends Tarefa implements Notificar {


    public TarefaComPrazos(String nome){
        super(nome);
    }

    @Override
    public String lembrete() {
        return "O prazo esta acabando";
    }
}
