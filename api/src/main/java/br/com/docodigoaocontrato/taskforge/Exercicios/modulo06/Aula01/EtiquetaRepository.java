package br.com.docodigoaocontrato.taskforge.Exercicios.modulo06.Aula01;

import br.com.docodigoaocontrato.taskforge.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface EtiquetaRepository extends JpaRepository <Etiqueta, Long> {

    boolean deleteAllById(Long id);
}
