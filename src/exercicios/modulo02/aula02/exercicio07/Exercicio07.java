package src.exercicios.modulo02.aula02.exercicio07;

public class Exercicio07 {
    void main() {
        Livro livro1 = new Livro();
        Eletronico eletronico1 = new Eletronico();

        Descontavel[] itens = {eletronico1, livro1};

        livro1.nome = "HarryPotter";

        for (Descontavel iten : itens) {
            IO.println(iten.desconto());
            if (iten instanceof Livro livro){
                IO.println(livro.nome);
            }
        }
    }
}
