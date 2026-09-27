package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01;

import br.com.docodigoaocontrato.taskforge.service.LeitoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class LeitoController {

    private final LeitoService LeitoService;

    @GetMapping("/ConsultarLeitos")
    public String ConsultarLeitos() {
        return LeitoService.ConsultarLeitos();
    }
}
