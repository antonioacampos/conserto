package com.example.conserto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosDeExperiencia;
    public Mecanico(DadosMecanico dados){
        this.nome= dados.nome();
        this.anosDeExperiencia=dados.anosDeExperiencia();

    }
}

