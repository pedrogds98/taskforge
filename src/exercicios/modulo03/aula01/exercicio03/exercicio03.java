package src.exercicios.modulo03.aula01.exercicio03;

import java.util.ArrayList;
import java.util.List;

public class exercicio03 {
    void main(){
        List<String> compras = new ArrayList<>();

        compras.add("Arroz");
        compras.add("Feijão");
        compras.add("Carne");
        compras.add("ovo");

        IO.println("Total de itens na lista: " + compras.size());
        IO.println("O primeiro item da lista: " + compras.get(0));
        IO.println("O terceiro item da lista: " + compras.get(2));

        for (String item : compras ) {

            IO.println(item);
        }
//        compras.get(5)}

    }

}
