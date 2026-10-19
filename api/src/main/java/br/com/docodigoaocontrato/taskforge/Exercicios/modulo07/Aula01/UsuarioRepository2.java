package br.com.docodigoaocontrato.taskforge.Exercicios.modulo07.Aula01;

import br.com.docodigoaocontrato.taskforge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository2 extends JpaRepository <Usuario, Long> {
    boolean existsByEmail(String email);
}
