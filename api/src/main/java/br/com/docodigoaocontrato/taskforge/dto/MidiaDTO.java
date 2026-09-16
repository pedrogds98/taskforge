package br.com.docodigoaocontrato.taskforge.dto;

public class MidiaDTO {
    private String titulo;
    private double nota;
    private Genero genero;
    private int duracaoMin;

    public MidiaDTO(String titulo, double nota, Genero genero, int duracaoMin){
        this.titulo = titulo;
        this.nota = nota;
        this.genero = genero;
        this.duracaoMin = duracaoMin;
    }

    public enum Genero {
        ACAO("Ação"),
        COMEDIA("Comédia"),
        DOCUMENTARIO("Documentário"),
        TECNOLOGIA("Tecnologia");

        private final String descricao;

        Genero(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return this.descricao;
        }
    }

    public int getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(int duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
