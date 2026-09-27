package br.com.docodigoaocontrato.taskforge.Repository;

import br.com.docodigoaocontrato.taskforge.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

}
