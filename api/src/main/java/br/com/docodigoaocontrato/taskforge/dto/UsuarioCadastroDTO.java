package br.com.docodigoaocontrato.taskforge.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCadastroDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
}
