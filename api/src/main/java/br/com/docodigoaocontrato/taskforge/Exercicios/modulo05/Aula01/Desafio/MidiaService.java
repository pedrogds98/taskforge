package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01.Desafio;

import br.com.docodigoaocontrato.taskforge.model.Midia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Getter
@Setter
public class MidiaService {

    private final MidiaRepository midiaRepository;

    public List<Midia> buscarMidias() {
        return midiaRepository.findAll();
    }

    public List<Midia> buscarFilmes() {
        return midiaRepository.findAll()
                .stream()
                .filter(midia -> midia.getTipo() == "filme")
                .toList();
    }


    public List<Midia> bemAvaliadas() {
        return midiaRepository.findAll()
                .stream()
                .filter(midia -> midia.getAvaliacao() >= 8.5)
                .toList();
    }
}
