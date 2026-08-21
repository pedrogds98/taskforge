package src.exercicios.modulo01.aula02;

public class exercicio07 {
    void main (){
        int numero = 7;
        do {
            numero = Integer.parseInt(IO.readln("Digite o palpite: "));

            if (numero > 7){
                IO.println("É MENOR");
            }
            else if(numero < 7){
                IO.println("É MAIOR");
            }

        } while(numero != 7);{
            IO.println("PARÁBENS, VOCÊ ACERTOU!!");
        };
    }
}
