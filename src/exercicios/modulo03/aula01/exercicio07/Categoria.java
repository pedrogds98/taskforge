package src.exercicios.modulo03.aula01.exercicio07;

public class Categoria {
    enum categoria {
        ELETRONICO("Eletrônico"),
        ALIMENTO("Alimento"),
        LIVRO("Livro");
        private final String descricao;

        categoria(String descricao) {
            this.descricao = descricao;
        }

        String getDescricao() {
            return descricao;
        }
    }
}






