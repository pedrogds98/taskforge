package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01.Desafio;

import br.com.docodigoaocontrato.taskforge.model.Midia;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MidiaController {

    private final MidiaService midiaService;

    @GetMapping("/midias")
    public List<Midia> buscarMidias(){
        return midiaService.buscarMidias();
    }

    @GetMapping("/midias/filmes")
    public List<Midia> buscarFilmes(){
        return midiaService.buscarFilmes();
    }

    @GetMapping("/midias/bem-avaliadas")
    public List<Midia> bemAvaliadas(){
        return midiaService.bemAvaliadas();
    }
}
