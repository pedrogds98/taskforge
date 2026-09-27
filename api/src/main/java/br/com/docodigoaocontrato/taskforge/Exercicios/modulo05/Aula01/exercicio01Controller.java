package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exercicio01Controller {

    @GetMapping("/ping")
    public String ping(){
        return "Primeira APi da vidassss";
    }
}
