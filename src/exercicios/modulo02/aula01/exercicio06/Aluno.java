package src.exercicios.modulo02.aula01.exercicio06;

public class Aluno {
    Double nota;
    Double nota2;

    public Aluno(double nota, double nota2) {
        this.nota = nota;
        this.nota2 = nota2;

    }

    double media() {
        double media = (nota + nota2) / 2;
        return media;

    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }
}
