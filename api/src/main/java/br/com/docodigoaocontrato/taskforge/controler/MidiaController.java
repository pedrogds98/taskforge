package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.dto.MidiaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.docodigoaocontrato.taskforge.dto.MidiaDTO.Genero.COMEDIA;


@RestController
public class MidiaController {

    @GetMapping("/midia")
    public MidiaDTO MidiaDTO (){
        return (new MidiaDTO("Duna", 8.7, COMEDIA, 155));
    }
}
