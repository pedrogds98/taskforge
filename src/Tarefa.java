package src;

public class Tarefa {
    private String nome;
    private String descricao;
    private int prioridade;
    private String responsavel;
    private double horasEstimadas;
    private int status;

    public void resumo(){
        IO.println(nome);
        IO.println(descricao);
        IO.println(prioridade);
        IO.println(responsavel);
        IO.println(horasEstimadas);
        IO.println(status);
    }

    public void imprimirCartao(){
        IO.println(prioridade);

        switch(status){
            case 1:
                IO.println("Pendente");
            case 2:
                IO.println("Em andamento");
            case 3:
                IO.println("Concluída");
            case 4:
                IO.println("Cancelada");
            default:
                IO.println("Status Inválido");

        }
    }

    public Tarefa(String nome, String descricao, int prioridade, String responsavel, int horasEstimadas, int status){
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.horasEstimadas = horasEstimadas;
        this.status = status;

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

    public double getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(double horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
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
