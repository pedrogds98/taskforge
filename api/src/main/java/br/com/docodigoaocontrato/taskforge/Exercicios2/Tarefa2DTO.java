package br.com.docodigoaocontrato.taskforge.Exercicios2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor

public class Tarefa2DTO {
    private int id;
    private String nome;
    private int prioridade;
    private boolean concluida;

}
