package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.Repository.ComentarioRepository;
import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Comentario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Setter
@Getter
@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public List<ComentarioDTO> listarComentarios(String autor) {
        List<Comentario> comentarios;
        if (autor == null || autor.isEmpty()) {
            comentarios = comentarioRepository.findAll();
        } else {
            comentarios = comentarioRepository.findByAutor(autor);
        }
        return comentarios
                .stream()
                .map(this::toDto)
                .toList();
    }

    public Comentario criarComentario(ComentarioDTO comentarioDTO) {
        Comentario novoComentario = toEntity(comentarioDTO);
        return comentarioRepository.save(novoComentario);
    }

    public Optional<ComentarioDTO> listarComentarioId(Long id) {
        return comentarioRepository.findById(id)
                .map(comentario -> toDto(comentario));

    }

    public Optional<ComentarioDTO> atualizarComentario(Long id, ComentarioDTO comentarioDTO) {
        Optional<Comentario> comentario = comentarioRepository.findById(id);

        if (comentario.isEmpty()) {
            return Optional.empty();
        }
        Comentario comentarioNovo = comentario.get();
        comentarioNovo.setAutor(comentarioDTO.getAutor());
        comentarioNovo.setDescricao(comentarioDTO.getDescricao());
        comentarioRepository.save(comentarioNovo);
        return Optional.of(toDto(comentarioNovo));
    }

    public boolean deletarComentario(Long id) {
        if (!comentarioRepository.existsById(id)) {
            return false;
        }
        comentarioRepository.deleteById(id);
        return true;
    }

    private ComentarioDTO toDto(Comentario comentario) {
        ComentarioDTO comentario1 = new ComentarioDTO();
        comentario1.setId(comentario.getId());
        comentario1.setAutor(comentario.getAutor());
        comentario1.setDescricao(comentario.getDescricao());
        return comentario1;
    }

    private Comentario toEntity(ComentarioDTO comentarioDTO) {
        return new Comentario((comentarioDTO.getId()),comentarioDTO.getDescricao(), comentarioDTO.getAutor());
    }
}
