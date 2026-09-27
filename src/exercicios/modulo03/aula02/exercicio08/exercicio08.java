package src.exercicios.modulo03.aula02.exercicio08;

import java.util.ArrayList;
import java.util.List;

public class exercicio08 {
    Missao missao1 = new Missao("estudarJava1");
    Missao missao2 = new Missao("estudarJava2");
    Missao missao3 = new Missao("estudarJava3");
    Missao missao4 = new Missao("estudarJava4");
    Missao missao5 = new Missao("estudarJava5");
    Missao missao6 = new Missao("estudarJava 6");


    void main() {
        List<Missao> ListaMissao = new ArrayList<>();

        ListaMissao.add(missao1);
        ListaMissao.add(missao2);
        ListaMissao.add(missao3);
        ListaMissao.add(missao4);
        ListaMissao.add(missao5);
        ListaMissao.add(missao6);

        try{ IO.println(ListaMissao.get(6).nome);

        }catch(IndexOutOfBoundsException e){
            IO.println("Essa posição não existe. A lista tem 6 tarefas");
        }


    }
}





