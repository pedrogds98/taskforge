// TaskForge v0 - projeto do curso "Do Código ao Contrato"
// Aula 01.1: Java, a JVM e as primeiras variáveis.
//
// Este é o ponto de partida. Durante a aula você constrói este código,
// e no desafio você evolui ele (veja COMO-ENTREGAR.md).
//
// Como rodar:
//   - No IntelliJ: abra este arquivo e clique em Run.
//   - No terminal: java TaskForge.java

void main() {
    int option = 0;

    String name = "";
    String descritor = "";
    int priority = 0;

    while (option !=3) {
        IO.println("=== MENU PRINCIPAL ===");
        IO.println("OPÇÂO 1 CRIAR TAREFA");
        IO.println("OPÇÂO 2 VER RESUMO");
        IO.println("OPÇÃO 3 SAIR");
        option = Integer.parseInt(IO.readln("DIGITE UMA OPÇÃO: "));


        switch (option) {

            case 1:
                IO.println("CRAR TAREFA: ");
                name = IO.readln("Nome: ");
                descritor = IO.readln("Descrição: ");
                priority = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
                IO.println("TAREFA CRIADA COM SUCESSO!");
                break;

            case 2:
                IO.println("Nome da Tarefa" + name);
                IO.println("Descrição da Tarefa:" + descritor);
                for (int i = 1; priority <= i; i++;);
                IO.print("*");
                    IO.println("Prioridade da Tarefa:" + priority);
                break;


            case 3:
                IO.println("FIM! ATÈ A PRÓXIMA!");
                break;

            default:
                IO.println("OPÇÂO INVÁLIDA");
        }
    }
}
