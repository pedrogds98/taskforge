package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @NotNull
    @Min(value = 1, message = "O valor precisa ser entre 1 a 5)
    @Max(value = 5, message = "O valor precisa ser entre 1 e 5)
    private Integer prioridade;
    private boolean concluida;
}
