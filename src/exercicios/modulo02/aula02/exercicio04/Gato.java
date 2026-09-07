package src.exercicios.modulo02.aula02.exercicio04;

public class Gato extends Animal {

    public Gato(String nome) {
        super(nome);
    }

    @Override
    void fazerSom(){
        IO.println(nome + ":" + "miau");
    }
}
