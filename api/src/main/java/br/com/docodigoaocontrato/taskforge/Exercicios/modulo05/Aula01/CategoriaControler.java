package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01;

import br.com.docodigoaocontrato.taskforge.Exercicios2.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.model.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaControler {
    private final CategoriaService categoriaService;
    public CategoriaControler(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
        Optional<CategoriaDTO> categoriaDT = categoriaService.buscarPorId(id);
        if (categoriaDT.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDT.get());
    }

    @GetMapping("/{id}")
    public List<Categoria> ListarCategorias() {
        return categoriaService.ListarCategorias();
    }

    @GetMapping("/ativas")
    public List<Categoria> ListarCategoriaAtiva() {
        return categoriaService.ListarCategoriaAtiva();
    }

    @GetMapping("/categoriasDTO")
    public List<CategoriaDTO> ListarCategoriaDTO() {
        return categoriaService.ListarCategoriaDTO();
    }

    @PostMapping()
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO categoriaCriada = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Optional<CategoriaDTO> categoriaAtualizada = categoriaService.atualizarCategoria(categoriaDTO, id);

        if (categoriaAtualizada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarCategoria(@PathVariable Long id) {
        if (!categoriaService.deletarCategoria(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/ativas")
    public List<CategoriaDTO> listarAtivas() {
        return categoriaService.ListarAtivas();
    }
}