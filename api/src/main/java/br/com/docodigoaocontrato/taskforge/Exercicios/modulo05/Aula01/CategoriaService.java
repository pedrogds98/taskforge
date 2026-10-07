package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01;


import br.com.docodigoaocontrato.taskforge.Exercicios2.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.Repository.CategoriaRepository;
import br.com.docodigoaocontrato.taskforge.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> ListarCategorias() {
        return categoriaRepository.findAll();
    }

    public List<Categoria> ListarCategoriaAtiva() {
        return categoriaRepository.findAll().stream()
                .filter(Categoria::isAtiva).toList();
    }

    public List<CategoriaDTO> ListarCategoriaDTO() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    private CategoriaDTO toDto(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        dto.setAtiva(categoria.isAtiva());
        return dto;
    }

    private Categoria toEntity(CategoriaDTO categoriaDTO) {
        return new Categoria(categoriaDTO.getNome(), categoriaDTO.isAtiva());
    }

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = toEntity(categoriaDTO);
        return toDto(categoriaRepository.save(categoria));
    }

    public Optional<CategoriaDTO> buscarPorId(Long id) {
        Optional<Categoria> categoriaId = categoriaRepository.findById(id);
        if (categoriaId.isEmpty()) {
            return Optional.empty();
        }
        return categoriaId.map(this::toDto);
    }

    public Optional<CategoriaDTO> atualizarCategoria(CategoriaDTO categoriaDTO, Long id) {
        Optional<Categoria> categoriaNew = categoriaRepository.findById(id);

        if (categoriaNew.isEmpty()) {
            return Optional.empty();
        }
        Categoria categoriaNova = categoriaNew.get();
        categoriaNova.setNome(categoriaDTO.getNome());
        categoriaNova.setAtiva(categoriaDTO.isAtiva());

        return Optional.of(toDto(categoriaRepository.save(categoriaNova)));
    }


    public Boolean deletarCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }

    public List<CategoriaDTO> ListarAtivas() {
        return categoriaRepository.findAll()
                .stream()
                .filter(categoria -> categoria.isAtiva())
                .map(this::toDto)
                .toList();
    }
}

