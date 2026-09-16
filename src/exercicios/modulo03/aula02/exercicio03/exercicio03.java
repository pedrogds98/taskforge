package src.exercicios.modulo03.aula02.exercicio03;

public class exercicio03 {
    void main (){
        int a = 10;
        int b = 0;

      try {IO.println(a / b);

      } catch (ArithmeticException e){
          IO.println("Não dá para dividir por zero");

        }
    }
}


//ArithmeticException