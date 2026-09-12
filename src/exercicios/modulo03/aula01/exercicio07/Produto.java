package src.exercicios.modulo03.aula01.exercicio07;

public class Produto extends Categoria {
    private String nome;
    private categoria categoria;

    public Produto(String nome, categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }
}
