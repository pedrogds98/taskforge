package br.com.docodigoaocontrato.taskforge.Repository;

import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);
}
