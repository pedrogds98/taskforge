package src.exercicios.modulo03.aula02.exercicio02;

import java.util.List;
import java.util.ArrayList;

public class exercicio02 {
    void main(){
        List<Object> item = new ArrayList<>();

        item.add(new Radio());
        item.add(new TV());
        item.add(new Cadeira());

        for (Object i : item){
            if (i instanceof Ligavel) {
                IO.println(((Ligavel) i).ligar());
            }
        }
    }
}
