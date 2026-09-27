package src.exercicios.modulo03.aula02.exercicio04;

public class exercicio04 {
    void main(){
        Integer.parseInt(IO.readln("Sua idade: "));

        try { Integer.parseInt(IO.readln("Sua idade: "));

        } catch (NumberFormatException e){
            IO.println("Resposta inválida");
            e.getMessage();
        }
    }
}

//NumberFormatException