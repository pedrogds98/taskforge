package src.exercicios.modulo03.aula01.exercicio01;

public class Turno {
    enum Turnos {
        MANHA("Manhã"),
        TARDE("Tarde"),
        NOITE("Noite");
        private final String descricao;


        Turnos(String descricao) {
            this.descricao = descricao;
        }

        String getDescricao() {
            return descricao;
        }
    }

    void main() {
        Turnos t = Turnos.NOITE;
        IO.println("Turno: " + t);
        IO.println("Sem o getter: " + t.getDescricao());
//addddd

    }

}
