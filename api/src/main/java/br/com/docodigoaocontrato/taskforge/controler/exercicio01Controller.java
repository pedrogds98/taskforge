package br.com.docodigoaocontrato.taskforge.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exercicio01Controller {

    @GetMapping("/ping")

    public String ping(){
        return "PrimeiraAPi da vidassss";
    }
}
