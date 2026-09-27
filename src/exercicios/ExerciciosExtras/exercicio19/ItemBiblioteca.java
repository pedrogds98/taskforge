package src.exercicios.ExerciciosExtras.exercicio19;

public abstract class ItemBiblioteca {
    String titulo;
    String autor;
    int anoPublicacao;
    String status;

    public ItemBiblioteca(String titulo, String autor,
                          int anoPublicacao, String status){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.status = status;
    }

    public abstract String tipo();

    public String resumo() {
        return titulo + autor + anoPublicacao + status;
    }

}
