package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "A prioridade é obrigatória")
    @Min(value = 1, message = "A prioridade deve ser entre 1 e 5")
    @Max(value = 5, message = "A prioridade deve ser entre 1 e 5")
    private Integer prioridade;


    private Boolean concluida;

    public boolean isConcluida() {
        return false;
    }
}
