package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01;

import br.com.docodigoaocontrato.taskforge.model.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaControler {
    private final CategoriaService categoriaService;

    public CategoriaControler(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }


    @GetMapping("/Categoria")
    public List<Categoria> ListarCategorias(){
        return categoriaService.ListarCategorias();
    }

    @GetMapping("/categorias/ativas")
    public List<Categoria> ListarCategoriaAtiva(){
        return categoriaService.ListarCategoriaAtiva();
    }

}
