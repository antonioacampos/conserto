package com.example.conserto;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank(message = "Nome do mecânico é obrigatório")
        String nome,

        int anosDeExperiencia
) {
        public DadosMecanico (Mecanico mecanico)
        {
                this(
                        mecanico.getNome(),
                        mecanico.getAnosDeExperiencia()
                );
        }
}
