package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.dto.CatalogoDTO;
import br.com.docodigoaocontrato.taskforge.dto.MidiaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static br.com.docodigoaocontrato.taskforge.dto.MidiaDTO.Genero.ACAO;
import static br.com.docodigoaocontrato.taskforge.dto.MidiaDTO.Genero.TECNOLOGIA;

@RestController
public class CatalogoController {
    MidiaDTO midia1 = new MidiaDTO("Duna", 8.7, ACAO, 155);
    MidiaDTO midia2 = new MidiaDTO("Café com código", 9.1, TECNOLOGIA, 28);
    MidiaDTO midia3 = new MidiaDTO("Tropa de Elite", 8.0, ACAO, 115);



    List<MidiaDTO> Catalogo = new ArrayList<>();
    @GetMapping("/catalogo")
    public CatalogoDTO Catalogo(){
        Catalogo.add(midia1);
        Catalogo.add(midia2);
        Catalogo.add(midia3);

        return new CatalogoDTO("StreamFlix", Catalogo.size(),Catalogo);
    }

}
