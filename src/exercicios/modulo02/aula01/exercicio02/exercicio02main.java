package src.exercicios.modulo02.aula01.exercicio02;

public class exercicio02main {
    void main(){
        Livro livro1 = new Livro("Java fácil", 200);

        IO.println(" O " + livro1.titulo + " tem " +  livro1.paginas + " páginas " );
    }
}
