package src.exercicios.modulo02.aula02.exercicio01;

public class exercicio01 {
    void main() {
        Conta conta1 = new Conta();

        conta1.incrementar();
        conta1.incrementar();
        conta1.incrementar();

        IO.println(conta1.getValor());


    }
}
