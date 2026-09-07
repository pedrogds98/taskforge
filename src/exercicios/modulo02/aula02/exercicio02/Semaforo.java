package src.exercicios.modulo02.aula02.exercicio02;

public class Semaforo {
    enum Semaforo1 {
        VERMELHO,
        AMARELO,
        VERDE
    }

    public String acao(Semaforo1 s) {
        switch (s) {
            case VERMELHO:
                return "PARE";

            case AMARELO:
                return "atenção";

            case VERDE:
                return "SIGA";


        }
        return "";
    }

    }
