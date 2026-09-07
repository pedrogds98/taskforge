package src.exercicios.modulo02.aula02.exercicio07;

public class Livro implements Descontavel {
    String nome = "OnePiece";

    @Override
    public double desconto() {
        return 0.10;
    }
}
