package src.exercicios.modulo01.aula02;

public class exercicio06 {
    void main (){
        int numero = Integer.parseInt(IO.readln("Digite um número: "));
    int soma = 0;


    for (int i = 1; i <= 5; i++){
        soma = i + soma;

    }
    IO.println(soma);
    }
}
