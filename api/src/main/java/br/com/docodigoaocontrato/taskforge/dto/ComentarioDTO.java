package br.com.docodigoaocontrato.taskforge.dto;

import br.com.docodigoaocontrato.taskforge.model.Comentario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 500, message = "Deve conter no máximo 500 caracteres")
    private String descricao;

    @NotBlank(message = "O autor é obrigatório")
    private String autor;
}
