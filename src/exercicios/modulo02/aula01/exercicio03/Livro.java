package src.exercicios.modulo02.aula01.exercicio03;

public class Livro {
    String titulo;
    int paginas;

    public Livro (String titulo, int paginas) {
        this.titulo = titulo;
        this.paginas = paginas;
    }

    public void descrever(){
        IO.println(titulo + "(" + paginas + "pags"  + ")");


    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
