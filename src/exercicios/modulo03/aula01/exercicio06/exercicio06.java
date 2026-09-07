package src.exercicios.modulo03.aula01.exercicio06;

import java.util.ArrayList;
import java.util.List;

public class exercicio06 {
    void main(){
        List<String> turma = new ArrayList<>();
        List<String> desistentes = new ArrayList<>();

        turma.add("Pedro");
        turma.add("Paulo");
        turma.add("Ricardo");
        turma.add("Bruna");
        turma.add("João");
        desistentes.add("Pedro");
        desistentes.add("Paulo");

        IO.println("Turma antes: " + turma.size());

        turma.removeAll(desistentes);

        IO.println("Turma depois: " + turma.size());

        for (String i : turma) {
            IO.println("- " + i);
        }
    }
}
