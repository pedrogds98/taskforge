package src.exercicios.modulo01.aula02;

public class exercicio03 {
    void main() {

        String senha;

        do {
            senha = IO.readln("Senha: ");

        } while (!senha.equals("java123"));
        IO.println("ACESSO LIBERADO");

    }
}
