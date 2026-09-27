package src.exercicios.modulo03.aula02.exercicio06;

public class Menu {
    void main() {
        int opcao = 0;

        do {
            IO.println("==== MENU PRINCIPAL ====");
            IO.println("1 - Criar Tarefa");
            IO.println("2 - Listar Tarefa");
            IO.println("3 - Sair");

            try {
                opcao = Integer.parseInt(IO.readln("Digite uma opção: "));

            } catch (NumberFormatException e) {
                IO.println("Não é um numero, tente de novo");
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    IO.println("opção 1 escolhida");
                    break;

                case 2:
                    IO.println("Listar tarefa!");
                    break;

                default:
                    IO.println("Opção inválida!");
                    break;
            }

        } while (opcao != 3);
        IO.println("FIM DO PROGRAMA!");

    }
}
