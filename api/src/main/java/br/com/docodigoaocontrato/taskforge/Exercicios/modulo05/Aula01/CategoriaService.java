package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01;

import br.com.docodigoaocontrato.taskforge.Repository.CategoriaRepository;
import br.com.docodigoaocontrato.taskforge.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;


import static java.util.Locale.filter;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria CriarCategoria(Categoria CriarCategoria) {
        Categoria CriarCategorias = categoriaRepository.save (CriarCategoria);
        return CriarCategorias;
    }


    public List<Categoria> ListarCategorias() {
        return categoriaRepository.findAll();
    }

    public List<Categoria> ListarCategoriaAtiva() {
        List<Categoria> ListaCategoriasAtivas = categoriaRepository.findAll().stream()
                .filter(Categoria::isAtiva).toList();
        return ListaCategoriasAtivas;

    }
}
