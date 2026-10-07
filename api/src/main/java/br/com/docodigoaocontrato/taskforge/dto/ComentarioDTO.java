package br.com.docodigoaocontrato.taskforge.dto;

import br.com.docodigoaocontrato.taskforge.model.Comentario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComentarioDTO {
    private Long id;
    private String descricao;
    private String autor;


}
