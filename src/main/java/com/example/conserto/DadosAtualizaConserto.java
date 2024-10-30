package com.example.conserto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaConserto(
        @NotNull
        Long id,
        String dataSaida,
        String nomeMecanico,
        String anosExperiencia

) {
}
