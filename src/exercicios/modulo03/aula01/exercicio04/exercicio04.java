package src.exercicios.modulo03.aula01.exercicio04;

import java.util.ArrayList;
import java.util.List;

public class exercicio04 {
    void main() {
        List<String> compras2 = new ArrayList<>();

        compras2.add("Arroz");
        compras2.add("Feijão");
        compras2.add("Carne");
        compras2.add("Ovo");

        IO.println("Total: " + compras2.size());
        IO.println("O primeiro: " + compras2.get(0));
        IO.println("Terceiro: " + compras2.get(2));

        for (String item : compras2) {
            IO.println(item);
        }

//        IO.println(compras2.get(4));

        compras2.remove(0);
        compras2.remove("Carne");
        IO.println("Total: " + compras2.size());

        for (String item : compras2){
            IO.println(item);
        }

    }
}
