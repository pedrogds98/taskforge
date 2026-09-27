package src.exercicios.modulo03.aula02.Desafio;

public abstract class Tarefa {
    String nome;
    String descricao;
    String responsavel;
    double horas;
    String status;

    public Tarefa(String nome, String descricao, String responsavel,
                  double horas, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.horas = horas;
        this.status = status;
    }


    public abstract String tipo();

   public String resumo() {
        return "Tarefa: " + " | Nome: " + nome + " | Descrição:" + descricao +
                " | Responsavel" + responsavel + " | Horas: " + horas + " | Status: " + status;
    }
}
