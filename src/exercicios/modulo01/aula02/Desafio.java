void main() {
    IO.println("=== TaskForge v0 ===");

    int option;
    int quantidadeTarefas = 0;
    do {
        IO.println("MENU PRINCIPAL");
        IO.println(" 1 - Criar Tarefa");
        IO.println("2 - Ver Resumo");
        IO.println("3 - Sair");
        option = Integer.parseInt(IO.readln("DIGITE UMA OPÇÂO: "));

        switch (option){
            case 1:
                criarTarefa();
                quantidadeTarefas ++;
                break;

            case 2:
                IO.println("Quabtidade de tarefas: " + quantidadeTarefas);
                break;

            case 3:
                IO.println("Fim do programa!");
                break;

            default:
                IO.println("opção inválida");

        }

    } while (option != 3);
        IO.println("Fim do programa!!");

    }

//    String statusNome = "";
//    switch (status) {
//        case 1 -> statusNome = "Pendente";
//        case 2 -> statusNome = "Em Andamento";
//        case 3 -> statusNome = "Concluída";
//        case 4 -> statusNome = "Cancelada";
//        default -> statusNome = "Status Inválido";
//    }
//
//        IO.println("Status:    " + statusNome);
//        IO.println("---------------------------");

    void criarTarefa(){
        String nome = IO.readln("Nome da tarefa: ");
        String descricao = IO.readln("Descrição: ");
        int prioridade = 0;
        do {
            prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
            if (prioridade < 1 || prioridade > 5) {
                IO.println("Prioridade inválida.");
            }
        } while (prioridade < 1 || prioridade > 5);

        IO.println();
        String responsavel = IO.readln("Responsável: ");
        double horasEstimadas = Double.parseDouble(IO.readln("Horas estimadas: "));

        int status;
        do {
            IO.println("Escolha uma opção: ");
            IO.println("1 - Pendente");
            IO.println("2 - Em Andamento");
            IO.println("3 - Concluída");
            IO.println("4 - Cancelada");
            status = Integer.parseInt(IO.readln());
            if (status < 1 || status > 4) {
                IO.println("Status inválido.");
            }
        } while (status < 1 || status > 4);

        IO.println("");
        IO.println("------ TAREFA CRIADA ------");
        IO.println("Tarefa:     " + nome);
        IO.println("Descrição:  " + descricao);
        IO.print("Prioridade: ");
        for (int aux = 0; aux < prioridade; aux++) {
            IO.print("*");
    }
}