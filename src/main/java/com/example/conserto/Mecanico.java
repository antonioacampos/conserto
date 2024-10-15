package com.example.conserto;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    @NotBlank(message = "Nome do mecânico é obrigatório")
    private String nome;
    private int anosDeExperiencia;
}

