package src.exercicios.modulo01.aula02;

import static java.lang.Integer.parseInt;

public class exercicio04 {

    void main (){
        IO.println("== OPÇÕES ==");
        IO.println(" 1 - BOM DIA ");
        IO.println(" 2 - BOA TARDE ");
        IO.println(" 3 - BOA NOITE");

        int opcao = Integer.parseInt(IO.readln("Digite uma opção: "));

        switch (opcao){
            case 1:
                IO.println(" 1 - BOM DIA ");
                break;

            case 2:
                IO.println(" BOA TARDE ");
                break;

            case 3:
                IO.println(" BOA NOITE");

            default:
                IO.println("OPÇÃO INVÁLIDA");

        }

    }

}

