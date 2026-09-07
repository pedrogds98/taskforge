package src.exercicios.modulo03.aula01.exercicio05;

import java.util.ArrayList;
import java.util.List;

public class exercicio05 {
    void main(){
        List <String> manha = new ArrayList<>();
        List <String> tarde = new ArrayList<>();

        manha.add("Ana");
        manha.add("Bruno");

        tarde.add("Carla");
        tarde.add("Diego");
        tarde.add("Elis");

        IO.println("Manhã: " + manha.size());
        IO.println("Tarde: " + tarde.size());

        manha.addAll(tarde);

        IO.println("Depois do addAll Manhã com: " + manha.size());

        for (String item : manha) {
            IO.println(item);
        }

        IO.println("Tarde continua com: " + tarde.size());

    }
}
