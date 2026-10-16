package br.com.docodigoaocontrato.taskforge.Exercicios.modulo07.Aula01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;

}
