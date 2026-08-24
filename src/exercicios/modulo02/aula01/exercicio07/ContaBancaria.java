package src.exercicios.modulo02.aula01.exercicio07;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, float saldo){
        this.titular = titular;
        this.saldo = saldo;

    }

    void depositar(double valor){
        saldo =  (valor + saldo);

    }

    void mostrarSaldo(){
        IO.println("Saldo " + " de " + titular + ": " + saldo);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
