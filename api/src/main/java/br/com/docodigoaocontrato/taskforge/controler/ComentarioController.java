package br.com.docodigoaocontrato.taskforge.controler;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Comentario;
import br.com.docodigoaocontrato.taskforge.service.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @GetMapping
    public List<ComentarioDTO> listarComentarios(@RequestParam(required = false) String autor) {
        return comentarioService.listarComentarios(autor);
    }

    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        Comentario novoComentario = comentarioService.criarComentario(comentarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> listarComentarioId(@PathVariable Long id) {
        Optional<ComentarioDTO> comentarioDTO = comentarioService.listarComentarioId(id);
        if (comentarioDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(comentarioDTO.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> atualizarComentario(@PathVariable Long id, @RequestBody ComentarioDTO comentarioDTO) {
        Optional<ComentarioDTO> comentarioAtualizado = comentarioService.atualizarComentario(id, comentarioDTO);
        if (comentarioAtualizado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(comentarioAtualizado.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {
        if (!comentarioService.deletarComentario(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
