package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "O email está inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;
}
