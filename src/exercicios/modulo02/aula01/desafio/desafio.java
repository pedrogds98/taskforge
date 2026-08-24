package src.exercicios.modulo02.aula01.desafio;

public class desafio {
    void main(){
        Tarefa tarefa1 = new Tarefa("Desafio de JAVA", "Criar uma Classe", 3,
                "Pedro Gabriel", 5, 2);

        Tarefa tarefa2 = new Tarefa("Segundo desafio de Java", "Estou pegando a prática", 4,
                "Pedro Gabriel", 4, 1);

        tarefa1.imprimirCartao();

        tarefa2.imprimirCartao();

        tarefa2.setStatus(2);

        tarefa2.imprimirCartao();
    }

}
