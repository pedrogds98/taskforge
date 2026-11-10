package br.com.docodigoaocontrato.taskforge.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "Máximo 100 caracteres")
    @Schema(example = "Estudar Spring")
    private String nome;

    @NotNull(message = "A prioridade é obrigatória")
    @Min(value = 1, message = "A prioridade deve ser entre 1 e 5")
    @Max(value = 5, message = "A prioridade deve ser entre 1 e 5")
    @Schema(example = "3")
    private Integer prioridade;


    private Boolean concluida;

    public boolean isConcluida() {
        return false;
    }

    public boolean isPresent() {
        return true;
    }
}
