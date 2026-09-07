package src.exercicios.modulo02.aula02.exercicio04;

public class Animal {
    String nome;

    public Animal(String nome){
        this.nome = nome;
    }

    void fazerSom (){
        IO.println(nome + ":");
    }
}
