package br.com.docodigoaocontrato.taskforge.Exercicios.modulo05.Aula01.Desafio;

import br.com.docodigoaocontrato.taskforge.model.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MidiaRepository extends JpaRepository <Midia, Long> {
}