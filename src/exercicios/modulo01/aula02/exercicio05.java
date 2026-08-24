package src.exercicios.modulo01.aula02;

public class exercicio05 {
    void main (){
        float nota;

        IO.println("== AVALIADOR DE NOTAS ==");
        nota = Float.parseFloat(IO.readln("Digite a nota do aluno: "));

        if (nota >= 7) {
            IO.println("APROVADO");
        }else if (nota > 5 && nota < 7) {
            IO.println("RECUPERAÇÃO");
        } else {
            IO.println("REPROVADO");

        };

    }

}
