package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)



    private String nome;
    private boolean ativa;



}
