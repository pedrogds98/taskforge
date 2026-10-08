package br.com.docodigoaocontrato.taskforge.Repository;

import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {


}
