package br.com.docodigoaocontrato.taskforge.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SobreController {

    @GetMapping ("/sobre")
    public String sobres() {
        return "Pedro - aprendendo Java e Spring no do Código ao contrato";
    }
}
