package src.exercicios.modulo02.aula01.exercicio07;

public class exercicio07 {

    void main (){
        ContaBancaria contaAna = new ContaBancaria("Ana", 0);

        contaAna.depositar(100);

        contaAna.depositar(50);

        contaAna.mostrarSaldo();

    }
}
