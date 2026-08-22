package src.exercicios.modulo02.aula01.desafio;

public class Tarefa {
    private String nome;
    private String descricao;
    private int prioridade;
    private String responsavel;
    private double horas;
    private int status;

    public Tarefa(String nome, String descricao, int prioridade, String responsavel, double horas, int status){
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.horas = horas;
        this.status = status;

    }

    void imprimirCartao(){
        for (int i = 0; i < prioridade;  i++) {
            IO.print("*");
        }

        switch (status){
            case 1:
                IO.println("Pendente");
                break;

            case 2:
                IO.println("Em andamento");
                break;

            case 3:
                IO.println("Concluída");
                break;

            case 4:
                IO.println("Cancelada");
                break;

            default:
                IO.println("OPÇÃO INVÁLIDA!");
                break;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
