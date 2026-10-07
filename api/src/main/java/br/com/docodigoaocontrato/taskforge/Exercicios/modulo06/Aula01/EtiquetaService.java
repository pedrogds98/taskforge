package br.com.docodigoaocontrato.taskforge.Exercicios.modulo06.Aula01;

import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
@Setter

public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public List<Etiqueta> listarEtiqueta() {
        return etiquetaRepository
                .findAll()
                .stream()
                .toList();
    }

    public Optional<Etiqueta> listarEtiquetaId(Long id) {
        Optional<Etiqueta> listaEtiquetaId = etiquetaRepository.findById(id);
        if (listaEtiquetaId.isEmpty()){
            return Optional.empty();
        }
        return listaEtiquetaId;

    }

    public Etiqueta criarEtiqueta(Etiqueta etiqueta) {
        etiquetaRepository.save(etiqueta);
        return etiqueta;
    }

    public Optional<Etiqueta> atualizarEtiqueta(Long id, Etiqueta etiqueta) {
        Optional<Etiqueta> novaEtiqueta = etiquetaRepository.findById(id);
        if (novaEtiqueta.isEmpty()){
            return Optional.empty();
        }
        Etiqueta etiqueta1 = novaEtiqueta.get();
        etiqueta1.setNome(etiqueta.getNome());
        etiqueta1.setCor(etiqueta.getCor());
        return Optional.of(etiquetaRepository.save(etiqueta1));
    }

    public boolean deletarEtiqueta(Long id) {
        if(!etiquetaRepository.existsById(id)){
            return false;

        }
        etiquetaRepository.deleteById(id);
            return true;

    }
}
