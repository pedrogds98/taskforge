package src.exercicios.modulo03.aula01.exercicio07;

import java.util.ArrayList;
import java.util.List;

public class exercicio07 extends Categoria {
    void main() {

        List<Produto> ListaProdutos = new ArrayList<>();

        Produto produto1 = new Produto("Notebook", categoria.ELETRONICO);
        Produto produto2 = new Produto("Arroz", categoria.ALIMENTO);
        Produto produto3 = new Produto("Java Fácil", categoria.LIVRO);

        ListaProdutos.add(produto1);
        ListaProdutos.add(produto2);
        ListaProdutos.add(produto3);

        for (Produto i : ListaProdutos) {
            IO.println(i.getNome() + " [" + i.getCategoria() + "]");
        }
    }
}

