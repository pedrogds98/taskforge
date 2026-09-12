package src.exercicios.modulo03.aula01.exercicio02;

public class Cofrinho {
    private double saldo;


    void depositar(double v) {
        if (v > 0) {
            saldo=saldo + v;
        }
        else if (v < 0) {
            IO.println("Depósito Inválido");
            IO.println("Saldo: " + saldo);

        }
    }


    double getSaldo() {
        return saldo;
    }
}
