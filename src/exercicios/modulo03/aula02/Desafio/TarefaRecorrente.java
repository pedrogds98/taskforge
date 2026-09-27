package src.exercicios.modulo03.aula02.Desafio;

public class TarefaRecorrente extends Tarefa {
    int diasIntervalo;

    public TarefaRecorrente(String nome, String descricao,
                            String responsavel, double horas, String status, int diasIntervalo){
        super(nome, descricao, responsavel, horas, status);
        this.diasIntervalo = diasIntervalo;
    }

    @Override
    public String tipo(){
        return "Tarefa Recorrente";
    }

    @Override
    public String resumo() {
        return "Tarefa: " + " | Nome: " + nome + " | Descrição:" + descricao +
                " | Responsavel" + responsavel + " | Horas: " + horas + " | Status: "
                + status + "Dias intervalo: " + diasIntervalo;
    }
}
