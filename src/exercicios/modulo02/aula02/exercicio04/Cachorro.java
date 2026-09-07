package src.exercicios.modulo02.aula02.exercicio04;

public class Cachorro extends Animal {


    public Cachorro(String nome) {
        super(nome);
    }

    void fazerSom (){
        IO.println(nome + ":" + "au au");
    }

}
