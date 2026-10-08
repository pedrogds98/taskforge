package br.com.docodigoaocontrato.taskforge.Exercicios.modulo06.Aula01;

import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Getter
@Setter
@AllArgsConstructor

public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    @GetMapping("/etiquetas")
    public List<Etiqueta> listarEtiqueta(){
        return etiquetaService.listarEtiqueta();
    }

    @GetMapping("/etiquetas/{id}")
    public ResponseEntity<Etiqueta> listarEtiquetaId(@PathVariable Long id){
        Optional<Etiqueta> listaEtiquetas = etiquetaService.listarEtiquetaId(id);
        if (listaEtiquetas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(listaEtiquetas.get());
    }

    @PostMapping("/etiquetas")
    public Etiqueta criarEtiqueta (@RequestBody Etiqueta etiqueta){
        Etiqueta etiquetaNew = etiquetaService.criarEtiqueta(etiqueta);
        return etiquetaNew;
    }

    @PutMapping("/etiquetas/{id}")
    public ResponseEntity<Etiqueta> atualizarEtiqueta(@PathVariable Long id, @RequestBody Etiqueta etiqueta){
        Optional<Etiqueta> etiquetaNova = etiquetaService.atualizarEtiqueta(id, etiqueta);
        if(etiquetaNova.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(etiquetaNova.get());
    }

    @DeleteMapping("/etiquetas/{id}")
    public ResponseEntity<Void> deletarEtiqueta(@PathVariable Long id){
        if (!etiquetaService.deletarEtiqueta(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
