package src.exercicios.modulo02.aula01.exercicio06;

public class exercicio06 {
    void main (){
        Aluno Ana = new Aluno(7.8, 8.9);
        Aluno Bruno = new Aluno(4.5, 6.8);

        IO.println("Ana: " + Ana.media());
        IO.println("Bruno: " + Bruno.media());

    }

}
