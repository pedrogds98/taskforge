package src.exercicios.modulo03.aula02.Desafio;

public class TarefaSimples extends Tarefa {
    String nome;
    String descricao;
    String responsavel;
    double horas;
    String status;

    public TarefaSimples( String nome, String descricao, String responsavel,
                           double horas, String status){
        super(nome, descricao, responsavel, horas, status);
    }

    @Override
    public String tipo() {
        return "";
    }

}
