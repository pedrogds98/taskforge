package br.com.docodigoaocontrato.taskforge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCadastroDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "O Email está inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "A senha é obrigatório")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;
}
